package LP;

import static org.junit.Assert.*;

import org.junit.Test;

import LD.BD;

public class frmA�adirJugadorTest {

	@Test
	public void testA�adir() {
		String nombre = "Jokin"	;
		String ape1 = "Zulaika";		
		int num_j = 4;
		String num_licen_j = "89505354375";
		String num_licen_e = "ent49383";
		String equipo = "Zarautz";
		String contrase�a = "jok";
		
		BD base=new BD();
		base.a�adirJugador(nombre,ape1,equipo,num_licen_j,num_j,contrase�a, num_licen_e);
		
		assertNotNull(base);
		
		
		
	}

}
