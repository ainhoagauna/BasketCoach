package LD;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

public class BD 
{
	static Connection conn = null;	
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


	
	public void a�adirJugador(String nombre, String ape1, String equipo,String num_licen_j, int num_j,  String contrase�a, String num_licen_e )
	{	
		
		
			try {
				
							
				String sentencia="insert into jugador values('"+nombre+"', '"+ape1+"', '"+equipo+"','"+num_licen_j+"','0', '"+num_j+"',  '"+contrase�a+"', '"+num_licen_e+"')";
				stmt.executeUpdate(sentencia);
				
				String sentencia2="insert into login values('"+nombre+"' , '"+contrase�a+"')";
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
	
	public void eliminarJugador(JTable table, int fila, int columna,int columna2)
	{
		String jugador=table.getValueAt(fila, columna).toString();
		columna=0;
		columna2=6;
		try {
			
			String eliminado=jugador;
			
			String sentencia="delete from jugador where num_j='"+table.getValueAt(fila,columna)+"'";
			stmt.executeUpdate(sentencia);			
			
			String sentencia2="delete from asistencia where num_j= '"+eliminado+"'";
			stmt.executeUpdate(sentencia2);
			
			String sentencia3="delete from minutos where num_j= '"+jugador+"'";
			stmt.executeUpdate(sentencia3);
			
			String sentencia4="delete from quinteto where num_j= '"+jugador+"'";
			stmt.executeUpdate(sentencia4);
			
			String sentencia5="delete from login where password= '"+table.getValueAt(fila,columna2)+"'";
			stmt.executeUpdate(sentencia5);
			

			
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarJugador(JTextField textFieldNombre,JTextField textFieldApellido, JTextField textFieldEquipo, JTextField textFieldLicen_j, JTextField textFieldAsistencia, JTextField textFieldNumero,JTextField textFieldContrase�a, JTextField textFieldLicen_ent,JTable table, int fila, int columna)
	{
		
		columna=0;
		try {
			
			ResultSet rs = stmt.executeQuery("select * from jugador where num_="+table.getValueAt(fila, 0));
       	 while(rs.next() == true) {
       		 
       		 
       		 textFieldNombre.setText(rs.getString("nombre_j"));
       		 textFieldApellido.setText( rs.getString("ape1_j"));
       		 textFieldEquipo.setText(rs.getString("equipo_j"));
       		 textFieldLicen_j.setText(rs.getString("num_licen_j"));
       		// textFieldAsistencia.setInt(rs.getInt("asistencia_j"));
//       		 textFieldNumero.setText( rs.getInt("num_j"));
       		 textFieldContrase�a.setText (rs.getString("contraseina_j"));
       		 textFieldLicen_ent.setText(rs.getString("num_licen_ent"));
       		 
       		
       		 
       		 
       	 } 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void modificarJugador(String nombre, String ape1, String equipo,String num_licen_j, int num_j,  String contrase�a, String num_licen_e,JTable table, int fila, int columna, int columna2)
	{
		columna=0;
		columna2=6;
		
		try {
			String sentencia="update jugador set nombre_j='"+nombre+"', ape1_j='"+ape1+"', equipo_j='"+equipo+"', num_licen_j='"+num_licen_j+"',asistencia_j='"+0+"',num_j='"+num_j+"', contraseina_j='"+contrase�a+"', num_licen_ent='"+num_licen_e+"' where num_j= '"+table.getValueAt(fila,columna)+"'";			
			stmt.executeUpdate(sentencia);
			
					
			String sentencia2="update asistencia set apellido_j='"+ape1+"' where num_j= '"+table.getValueAt(fila,columna)+"'";
			stmt.executeUpdate(sentencia2);
			
			String sentencia3="update minutos set apellido_j='"+ape1+"' where num_j= '"+table.getValueAt(fila,columna)+"'";
			stmt.executeUpdate(sentencia3);
			
			String sentencia4="update quinteto set apellido_j='"+ape1+"' where num_j= '"+table.getValueAt(fila,columna)+"'";
			stmt.executeUpdate(sentencia4);
	
			String sentencia5="update login set password='"+contrase�a+"' where password= '"+table.getValueAt(fila,columna2)+"'";
			stmt.executeUpdate(sentencia5);
			
			String sentencia6="update login set username='"+nombre+"' where password= '"+table.getValueAt(fila,columna2)+"'";
			stmt.executeUpdate(sentencia6);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modificarQuinteto(String modificado, String num, String ape, String uno, String dos,String tres, String cuatro, JTable table, int fila, int columna)
	{
		
		
		try {
			
			if(columna==2)
				
			{
				
				String sentencia="update quinteto set primer_cuarto='"+modificado+"' where num_j='"+table.getValueAt(fila,0)+"'";
				stmt.executeUpdate(sentencia);
			}
			
			else if(columna==3)
			{
				String sentencia="update quinteto set segundo_cuarto='"+modificado+"' where num_j='"+table.getValueAt(fila,0)+"'";
				stmt.executeUpdate(sentencia);
			}
			
			else if(columna==4)
			{
				String sentencia="update quinteto set tercer_cuarto='"+modificado+"' where num_j='"+table.getValueAt(fila,0)+"'";
				stmt.executeUpdate(sentencia);
			}
			else if (columna==5)
			{
				String sentencia="update quinteto set cuarto_cuarto='"+modificado+"' where num_j='"+table.getValueAt(fila,0)+"'";
				stmt.executeUpdate(sentencia);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modificarMinutos(String modificado,String num, String apellido, String minutos, String partidos, String fecha,  JTable table, int fila, int columna)
	{
		try {
			
			if(columna==2)
				
			{
				
				String sentencia="update minutos set minutos_m='"+modificado+"' where num_j='"+table.getValueAt(fila,0)+"'";
				stmt.executeUpdate(sentencia);
			}
			
			else if(columna==3)
			{
				String sentencia="update minutos set num_part_m='"+modificado+"' where num_j='"+table.getValueAt(fila,0)+"'";
				stmt.executeUpdate(sentencia);
			}
			
			else if(columna==4)
			{
				String sentencia="update minutos set fecha_part_m='"+modificado+"' where num_j='"+table.getValueAt(fila,0)+"'";
				stmt.executeUpdate(sentencia);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modificarAsistencia(String modificado, String num, String apellido, String bonus, String asistencia, String meritos, String desconv, JTable table, int fila, int columna)
	{
		try {
			
			if(columna==2)
				
			{
				
				String sentencia="update asistencia set bonus_a='"+modificado+"' where num_j='"+table.getValueAt(fila,0)+"'";
				stmt.executeUpdate(sentencia);
			}
			
			else if(columna==3)
			{
				String sentencia="update asistencia set tot_asis_a='"+modificado+"' where num_j='"+table.getValueAt(fila,0)+"'";
				stmt.executeUpdate(sentencia);
			}
			
			else if(columna==4)
			{
				String sentencia="update asistencia set meritos_a='"+modificado+"' where num_j='"+table.getValueAt(fila,0)+"'";
				stmt.executeUpdate(sentencia);
			}
			
			else if(columna==5)
			{
				String sentencia="update asistencia set desconv_a='"+modificado+"' where num_j='"+table.getValueAt(fila,0)+"'";
				stmt.executeUpdate(sentencia);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void a�adirEquipo(String nombre,String ciudad, String categoria, String licencia)
	{
		try {
			
			
			String sentencia="insert into equipo values('"+nombre+"', '"+ciudad+"', '"+categoria+"', '"+licencia+"')";
			stmt.executeUpdate(sentencia);
			
			JOptionPane.showMessageDialog(null, "�Equipo a�adido correctamente!");	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	
	public DefaultTableModel cargarQuintetos(int numero, String apellido, String uno,String dos, String tres, String cuatro, DefaultTableModel modelo)
	
	{
		
            
            try {
            	ResultSet rs = stmt.executeQuery("select * from quinteto order by num_j");
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
        	ResultSet rs = stmt.executeQuery("select * from asistencia order by num_j");
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
	
	public DefaultTableModel cargarJugador2(int numero,String nombre,String apellido, String equipo, String licen_j, int asistencia, String contrase�a, String licen_e, DefaultTableModel modelo)
	{
		  
        try {
        	ResultSet rs = stmt.executeQuery("select * from jugador order by num_j");
        	 while(rs.next() == true) {
        		 
        		 
        		 nombre = rs.getString("nombre_j");
        		 apellido= rs.getString("ape1_j");
        		 equipo= rs.getString("equipo_j");
        		 licen_j= rs.getString("num_licen_j");
        		 asistencia=rs.getInt("asistencia_j");
        		 numero = rs.getInt("num_j");
        		 contrase�a= rs.getString("contraseina_j");
        		 licen_e= rs.getString("num_licen_ent");
        		 
        		
        		 
        		  modelo.addRow( new Object[] {numero,nombre,apellido,equipo,licen_j,asistencia,contrase�a,licen_e} );
        	 }    
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelo;
	}   
   
    public DefaultTableModel cargarMinutos(int numJugador, String apellido,int minutos, int numPartido, Date fecha, DefaultTableModel modelo)
	{
		

  	  try {
        	ResultSet rs = stmt.executeQuery("select * from minutos order by num_j");
        	 while(rs.next() == true) 
        	 {
        		 minutos = rs.getInt("minutos_m");
        		 numPartido = rs.getInt("num_part_m");
        		 fecha= rs.getDate("fecha_part_m");
        		 numJugador=rs.getInt("num_j");
        		 apellido = rs.getString("apellido_j");
        		
        		 modelo.addRow( new Object[] {numJugador,apellido,minutos,numPartido,fecha} );
        	 }    
        	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return modelo;
		
		
	}	

	
	public boolean contrase�a(String nombre, String contrase�a) {
		// TODO Auto-generated method stub
		
		boolean retorno = true;
		try {
        	ResultSet rs = stmt.executeQuery("select username,password from login where username='nombre' and password='contrase�a'");
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
	
	public static void a�adirRecordatorio(String string,String comentario, JList list, DefaultListModel modeloLista)
	{
		try {			
			
			String sentencia="insert into recordatorio values('"+string+"', '"+comentario+"')";
			stmt.executeUpdate(sentencia);
			
			 list.setModel(modeloLista);
			
			JOptionPane.showMessageDialog(null, "�Recordatorio a�adido correctamente!");	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/* 
	 * Ejecuta la actualizacion de la tabla recordatorio dado los valores de actualizacion	 *
	 */
	public static boolean actualizarRecordatorio(JDateChooser fecha,String comentario)
	    {
	        boolean res = false;
	        String q = " UPDATE recordatorio SET " + fecha + " WHERE coment_r= " + comentario;
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

	/*
	 *Cargar el recordatorio que este guardado en una fecha. 
	 */
	 public static String cargarRecordatorio(JDateChooser fecha,String comentario)
		{
			

	  	  try {
	        	ResultSet rs = stmt.executeQuery("select * from recordatorio WHERE fecha_r=" + fecha);
	        	 while(rs.next() == true) 
	        	 {	        		 
	        		 comentario = rs.getString("coment_r");      		
	        		 
	        	 }    
	        	 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	  	  return comentario;
								
			
		}	
	

	 public boolean leerNumero(int num_j)
		{
			boolean retorno = false;
			try {
	        	ResultSet rs = stmt.executeQuery("select num_j from jugador");
	        	 while(rs.next() == true) {
	        		 
	        		 if(rs.equals(num_j))
	        		 {
	        			 retorno=true;
	        			 
	        		 }
	        		 
	   		
	        	 }
	        	 
	        	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "�Ya existe un jugador con ese n�mero!");
			}
			
			return retorno;
			
		}


	 
	 public void cargarEventos(JList list, DefaultListModel modeloLista)
	 {
		 
		try {
			ResultSet rs = stmt.executeQuery("select * from recordatorio order by fecha_r");
			modeloLista.clear();
			while(rs.next() == true) {
				 modeloLista.addElement(rs.getString("fecha_r"));
				 modeloLista.addElement(rs.getString("coment_r"));
				 
				 
				 list.setModel(modeloLista);
		} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 	
		}	 
		 
	public void eliminarRecordatorio(JList list)
	{

		try {
			
		
			
			String sentencia="delete from recordatorio where coment_r='"+list.getSelectedValue().toString()+"'";
			stmt.executeUpdate(sentencia);	
			
			
		
			
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 
	
	 
}	



