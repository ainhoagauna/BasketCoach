package LP;

import static org.junit.Assert.*;

import org.junit.Test;

import LD.BD;
import LN.clsEquipo;

public class frmAñadirEquipoTest {

	@Test
	public void testAñadir() {
		
		String nombre = "Easo";
		String ciudad = "Donosti";
		String categoria = "LigaEBA";
		String licencia = "1k173nd73b";
		
		BD base=new BD();
		base.añadirEquipo(nombre,ciudad,categoria,licencia);
		
		assertNotNull(base);
		
		
	}

}
