package LN;

import static COMUN.clsDefiniciones.*;

public class clsGestorAdministrador 
{
	/**
	 * Variables de la clase.
	 */
	private boolean retorno = false;

	/**
	 * Constructor sin par�metros de la clase clsGestorAdministrador.
	 */
	public clsGestorAdministrador()
	{
		
	}
	
	/**
	 * M�todo que comprueba los datos introducidos.
	 * @param nombre nombre de usuario introducido.
	 * @param contrase�a contrase�a de acceso introducido.
	 * @return retorno : devolvera tru o false si coincide con los datos del administrador o no.
	 */
	public boolean LeerContrase�a(String nombre, String contrase�a)
	{		
		if(contrase�a.equals(passAdmin) && nombre.equals(usuAdmin))
		{
			retorno=true;
		}
		else
		{
			retorno=false;
		}
		
		return retorno;
	}

	public boolean isRetorno()
	{
		return retorno;
	}

	public void setRetorno(boolean retorno) 
	{
		this.retorno = retorno;
	}
	
	
}
