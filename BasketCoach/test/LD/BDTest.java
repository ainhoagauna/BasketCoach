/**
 * 
 */
package LD;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 *
 */
public class BDTest 
{

	BD j;
	int num;	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		j = new BD();
		
		num = j.testMostrarJugador();
				
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception 
	{
		
	}

	/**
	 * 
	 */
	@Test
	public void test() 
	{
		assertEquals(num,11);
	}

}
