package LP;

import static org.junit.Assert.*;

import org.junit.Test;

import LD.BD;
import LN.clsEquipo;

public class frmA�adirEquipoTest {

	@Test
	public void testA�adir() {
		
		String nombre = "Easo";
		String ciudad = "Donosti";
		String categoria = "LigaEBA";
		String licencia = "1k173nd73b";
		
		BD base=new BD();
		base.a�adirEquipo(nombre,ciudad,categoria,licencia);
		
		assertNotNull(base);
		
		
	}

}
