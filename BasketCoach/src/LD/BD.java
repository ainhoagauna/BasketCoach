package LD;

import java.io.File;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class BD 
{
	Connection conn = null;	
	static Statement stmt;
	
	public static Connection dbConnector ()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");

//			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ALUMNO\\Documents\\Git\\BasketCoach\\BasketCoach\\BasketCoach(Database).s3db");

			File fichero = new File("BasketCoach(Database).s3db");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + fichero.getAbsolutePath());
			
			stmt=conn.createStatement();
			stmt.setQueryTimeout(30);

			JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	


	public static String DirectorioActual()
	{
	    String directorio = System.getProperty("java.class.path");
	    File dir = new File(directorio);
	    String directorioPadre = dir.getParent();
	    return directorioPadre;
	}


	
	public void añadirJugador(String nombre, String ape1, String ape2,String asistencia, String num_j, String num_licen_j,String num_licen_e, String equipo, String contraseña)
	{	
		
		
			try {
				
							
				String sentencia="insert into jugador values('"+nombre+"', '"+ape1+"', '"+ape2+"','"+asistencia+"', '"+num_j+"', '"+num_licen_j+"','"+num_licen_e+"', '"+equipo+"', '"+contraseña+"')";
				stmt.executeUpdate(sentencia);
				
				
				
				JOptionPane.showMessageDialog(null, "¡Jugador añadido correctamente!");	
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
	
	}
	
	public void añadirEquipo(String nombre,String ciudad, String categoria, String licencia)
	{
		try {
			
			
			String sentencia="insert into equipo values('"+nombre+"', '"+ciudad+"', '"+categoria+"', '"+licencia+"')";
			stmt.executeUpdate(sentencia);
			
			JOptionPane.showMessageDialog(null, "¡Equipo añadido correctamente!");	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public DefaultListModel cargarLista(DefaultListModel modeloLista)
	{
		String equipo;
		
	     
	      try {
	    	
	    	ResultSet rs = stmt.executeQuery("select nombre_e from equipo");
			while(rs.next())
			  { 
				  // Leer el resultset
				 
				  modeloLista.addElement(rs.getString("nombre_e"));
				  
				  

			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modeloLista;
	}
	
	public DefaultListModel cargarJugador(DefaultListModel modeloLista2)
	{
		
		
	     
	      try {
	    	
	    	ResultSet rs = stmt.executeQuery("select * from jugador");
			while(rs.next())
			  { 
				  // Leer el resultset
				 
				  modeloLista2.addElement(rs.getString("num_j") + " " + rs.getString("nombre_j") + " " + rs.getString("ape1_j"));
				  
				  
				      

			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modeloLista2;
	}
	
	
	
	public DefaultTableModel cargarQuintetos(int numero, String nombre, String uno,String dos, String tres, String cuatro, DefaultTableModel modelo)
	
	{
		
            
            try {
            	ResultSet rs = stmt.executeQuery("select * from quinteto");
            	 while(rs.next() == true) {
            		 numero = rs.getInt("num_j");
            		 nombre = rs.getString("nombre_j");
            		 uno = rs.getString("primer_cuarto");
            		 dos= rs.getString("segundo_cuarto");
            		 tres = rs.getString("tercer_cuarto");
            		 cuatro = rs.getString("cuarto_cuarto");
            		 
            		  modelo.addRow( new Object[] {numero,nombre,uno,dos,tres,cuatro} );
            	 }    
            	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
          
            return modelo;
        
	}

	public DefaultTableModel cargarAsistencia(int numero, String nombre, int bonus,int asistencia,int meritos, int desconvocado, DefaultTableModel modelo)
	{
		try {
        	ResultSet rs = stmt.executeQuery("select * from asistencia");
        	 while(rs.next() == true) {
        		 numero = rs.getInt("num_j");
        		 nombre = rs.getString("nombre_j");
        		 bonus = rs.getInt("bonus_a");
        		 asistencia= rs.getInt("tot_asis_a");
        		 meritos = rs.getInt("meritos_a");
        		 desconvocado = rs.getInt("desconv_a");
        		 
        		  modelo.addRow( new Object[] {numero,nombre,bonus,asistencia,meritos,desconvocado} );
        	 }    
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
      
        return modelo;
	}
	
	public DefaultTableModel cargarJugador2(int numero,String nombre, String apellido, DefaultTableModel modelo)
	{
		  
        try {
        	ResultSet rs = stmt.executeQuery("select * from jugador");
        	 while(rs.next() == true) {
        		 numero = rs.getInt("num_j");
        		 nombre = rs.getString("nombre_j");
        		 apellido= rs.getString("ape1_j");
        		
        		 
        		  ((DefaultTableModel) modelo).addRow( new Object[] {numero,nombre,apellido} );
        	 }    
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		
		
		
		
		return modelo;
		
	}



	
	
	public boolean contraseña(String nombre, String contraseña) {
		// TODO Auto-generated method stub
		
		boolean retorno = true;
		try {
        	ResultSet rs = stmt.executeQuery("select username,password from login where username='nombre' and password='contraseña'");
        	 while(rs.next() == true) {
        		 
        		 if(rs!=null)
        		 {
        			 retorno=true;
        		 }
        		 
//        		 else
//        		 {
//        			 retorno=false;
//        		 }
        		 
//        		 nombre = rs.getString("username");
//        		 contraseña=rs.getString("password");
        		
        	 }
        	 
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retorno; 
	}










}



