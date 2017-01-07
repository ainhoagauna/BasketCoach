package LD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import java.io.Serializable;
import java.util.ArrayList;

import COMUN.clsDefiniciones.MiEnumerado;




/**
 * 
 * @author Ianire Andola, Ainhoa Gauna
 * Clase encargada de acceder a los ficheros, llamada desde la lógica de negocios
 */
public class clsDatos implements itfDatos
{

	/**
	 * Rutas en las que van a ser colocados los ficheros creados, ya nombrados en clsConstantes
	 */
	private final String rutaLogin = "Login.dat";
		
	ObjectOutputStream oos;
	ObjectInputStream ois;
	AppendableOutputStream aos;
	
	
	/**
	 * Selecciona la ruta del fichero que se ha elegido
	 * @param fichero
	 * @return la ruta correspondiente a cada fichero
	 */
	private String setMiEnumerado(MiEnumerado fichero)
	{
			switch(fichero)
			{
				case FICHERO_LOGIN:
				{
					return rutaLogin;
				}
					
			}
			return "";
	}
	
	/**
	 * @param fichero: 	enumerado de la clase clsConstantes que indica el fichero del que se va a escribir.
	 * Método que debe crear un objectOutputStream o un AppendableObjectOutputStream para proceder a la escritura del fichero. Si el fichero existe,AppendableObjectOutputStream; de lo 
	 * contrario objectOutputStream
	 */
 	public void ComenzarSave(MiEnumerado fichero)
	{
		String ruta=setMiEnumerado(fichero);
		File fic;
		fic=new File(ruta);
		
		if (fic.exists())
		{
			
			try 
			{
				aos = new AppendableOutputStream(new FileOutputStream(fic,true));
			
			} catch (IOException e) 
			{
			
				e.printStackTrace();
			}
			
		}
			
		else
			{
				
				try {
					fic.createNewFile();
					oos=new ObjectOutputStream (new FileOutputStream(fic));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	

	
	/**
	 * Cierra el fichero en el que se haya estado guardando datos
	 */
	public void TerminarSave ()
	{
			try
			{
				if(oos!=null) oos.close();
				else if(aos!=null)aos.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
	}
	
	/**
	 * 
	 * @param o: Objeto a guardar, que debe implementar la interfaz serializable.
	 * Método que guarda en el fichero indicado previamente el objeto recibido.
	 */
	public void Save(Serializable o )
	{
			try
			{
					if (oos!=null)
					oos.writeObject(o);
					else if(aos!=null)
					aos.writeObject(o);
					
			} catch (FileNotFoundException e ) 
			{
					e.printStackTrace();
			}catch (IOException e)
			{
				e.printStackTrace();
			}
	}
	
	/**
	 * 
	 * @param fichero: enumerado de la clase clsConstantes que indica el fichero del que se va a leer. 
	 * @throws IOException
	 * Método que crea un objectInputStream para la lectura del fichero indicado previamente.
	 */
	public void ComenzarRead (MiEnumerado fichero)
	{
		String ruta=setMiEnumerado(fichero);
		File fic;
		
		fic=new File(ruta);
		
		if (fic.exists())
		{
			try {
				ois=new ObjectInputStream(new FileInputStream(fic));
			} catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Cierra el fichero después de haber leido los datos
	 */
	public void TerminarRead()
	{
		try
		{
			if(ois!=null)ois.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Método encargado de leer el fichero al que se le dirige y devolver los objetos Serializable recogidos en un ArrayList
	 * @return ArrayList: Devuelve un arraylist con los datos leídos, en el tipo Serializable.
	 */
	public ArrayList<Serializable> Read()
	{
		ArrayList<Serializable>lista;
		Serializable o=null;
		
		lista=new ArrayList<Serializable>();
		try
		{
			while ((o=(Serializable) ois.readObject()) != null)
			{
				lista.add(o);
			}
		}
		catch (IOException e)
		{
			if (o==null)
			{
				System.out.println(e.getMessage());
			}
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Comprueba si el fichero al que se este llamando existe o no
	 * @param fichero : Será el fichero que se le pasará para que compruebe si existe o no
	 * @return true si el fichero existe
	 */
	public boolean ComprobarExists(MiEnumerado fichero) 
	{
		boolean existe;
		String ruta=setMiEnumerado(fichero);
		File fic;
		
		fic=new File(ruta);
		
		if(fic.exists())
		{
			existe=true;
		}
		else 
		{
			existe=false;
		}
		
		return existe;
	}
	
	/**
	 * Se borra el fichero (porque vamos a escribir datos modificados).
	 * @param fichero enumerado de la clase clsConstantes que indica el fichero que se va a borrar
	 */
	
	public void ResetFile (MiEnumerado fichero)
	{
		String ruta =setMiEnumerado(fichero);
		File f=new File(ruta);
		f.delete();
			
	}

	
	


}