package LP;

import static org.junit.Assert.*;

import org.junit.Test;

import LD.BD;

public class frmAñadirJugadorTest {

	@Test
	public void testAñadir() {
		String nombre = "Jokin"	;
		String ape1 = "Zulaika";		
		int num_j = 4;
		String num_licen_j = "89505354375";
		String num_licen_e = "ent49383";
		String equipo = "Zarautz";
		String contraseña = "jok";
		
		BD base=new BD();
		base.añadirJugador(nombre,ape1,equipo,num_licen_j,num_j,contraseña, num_licen_e);
		
		assertNotNull(base);
		
		
		
	}

}
