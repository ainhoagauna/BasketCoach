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


	
	public void añadirJugador(String nombre, String ape1, String equipo,String num_licen_j, int num_j,  String contraseña, String num_licen_e )
	{	
		
		
			try {
				
							
				String sentencia="insert into jugador values('"+nombre+"', '"+ape1+"', '"+equipo+"','"+num_licen_j+"','0', '"+num_j+"',  '"+contraseña+"', '"+num_licen_e+"')";
				stmt.executeUpdate(sentencia);
				
				String sentencia2="insert into login values('"+nombre+"' , '"+contraseña+"')";
				stmt.executeUpdate(sentencia2);
				
				String sentencia3="insert into asistencia ('num_j', 'apellido_j') values('"+num_j+"', '"+ape1+"')";
				stmt.executeUpdate(sentencia3);
				
				String sentencia4="insert into minutos ('num_j', 'apellido_j') values('"+num_j+"', '"+ape1+"')";
				stmt.executeUpdate(sentencia4);
				
				String sentencia5="insert into quinteto ('num_j', 'apellido_j') values('"+num_j+"', '"+ape1+"')";
				stmt.executeUpdate(sentencia5);
				
				
				
				
			
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
	
	public DefaultTableModel cargarQuintetos(int numero, String apellido, String uno,String dos, String tres, String cuatro, DefaultTableModel modelo)
	
	{
		
            
            try {
            	ResultSet rs = stmt.executeQuery("select * from quinteto");
            	 while(rs.next() == true) {
            		 numero = rs.getInt("num_j");
            		 apellido = rs.getString("apellido_j");
            		 uno = rs.getString("primer_cuarto");
            		 dos= rs.getString("segundo_cuarto");
            		 tres = rs.getString("tercer_cuarto");
            		 cuatro = rs.getString("cuarto_cuarto");
            		 
            		  modelo.addRow( new Object[] {numero,apellido,uno,dos,tres,cuatro} );
            	 }    
            	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
          
            return modelo;
        
	}

	public DefaultTableModel cargarAsistencia(int numero, String apellido, int bonus,int asistencia,int meritos, int desconvocado, DefaultTableModel modelo)
	{
		try {
        	ResultSet rs = stmt.executeQuery("select * from asistencia");
        	 while(rs.next() == true) {
        		 numero = rs.getInt("num_j");
        		 apellido = rs.getString("apellido_j");
        		 bonus = rs.getInt("bonus_a");
        		 asistencia= rs.getInt("tot_asis_a");
        		 meritos = rs.getInt("meritos_a");
        		 desconvocado = rs.getInt("desconv_a");
        		 
        		  modelo.addRow( new Object[] {numero,apellido,bonus,asistencia,meritos,desconvocado} );
        	 }    
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
      
        return modelo;
	}
	
	public DefaultTableModel cargarJugador2(String nombre,String apellido, String equipo, String licen_j, int asistencia,int numero, String contraseña, String licen_e, DefaultTableModel modelo)
	{
		  
        try {
        	ResultSet rs = stmt.executeQuery("select * from jugador");
        	 while(rs.next() == true) {
        		 
        		 
        		 nombre = rs.getString("nombre_j");
        		 apellido= rs.getString("ape1_j");
        		 equipo= rs.getString("equipo_j");
        		 licen_j= rs.getString("num_licen_j");
        		 asistencia=rs.getInt("asistencia_j");
        		 numero = rs.getInt("num_j");
        		 contraseña= rs.getString("contraseina_j");
        		 licen_e= rs.getString("num_licen_ent");
        		 
        		
        		 
        		  modelo.addRow( new Object[] {nombre,apellido,equipo,licen_j,asistencia,numero,contraseña,licen_e} );
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
        		 
   		
        	 }
        	 
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retorno; 
	}

	/* Ejecuta la actualizacion de la tabla persona dado los valores de actualizacion
	 * y el ID del registro a afectar
	 */
	public boolean update(String valores, String num_j)
	    {
	        boolean res = false;
	        String q = " UPDATE quintetos SET " + valores + " WHERE num_j= " + num_j;
	        try {
	            PreparedStatement pstm = conn.prepareStatement(q);
	            pstm.execute();
	            pstm.close();
	            res=true;
	         }catch(SQLException e){
	            System.out.println(e);
	        }
	        return res;
	    }








}



