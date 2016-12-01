package LP;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import LD.sqliteConnection;
import LN.clsGestorAdministrador;

public class frmA�adirEquipo extends JFrame implements ActionListener{
	private JTextField textFieldNombre;
	private JTextField textFieldCiudad;
	private JTextField textFieldCategoria;
	
	private boolean retorno = false;
	
	
	public frmA�adirEquipo() {
		getContentPane().setLayout(null);
		setTitle("A�adir equipo");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(300, 100, 350, 300);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(30, 19, 46, 23);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(30, 50, 86, 30);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(166, 19, 71, 23);
		getContentPane().add(lblCiudad);
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.setBounds(166, 50, 86, 30);
		getContentPane().add(textFieldCiudad);
		textFieldCiudad.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(30, 91, 86, 24);
		getContentPane().add(lblCategoria);
		
		textFieldCategoria = new JTextField();
		textFieldCategoria.setBounds(30, 126, 86, 30);
		getContentPane().add(textFieldCategoria);
		textFieldCategoria.setColumns(10);
		
		JButton btnA�adir = new JButton("A\u00D1ADIR");
		btnA�adir.setBounds(50, 188, 89, 23);
		btnA�adir.addActionListener(this);
		btnA�adir.setActionCommand("A�ADIR");		
		getContentPane().add(btnA�adir);
		
		JButton btnSalir = new JButton("ATRAS");
		btnSalir.setBounds(166, 188, 89, 23);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("ATRAS");
		getContentPane().add(btnSalir);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()){
		case "A�ADIR":
			this.a�adir();
			
			break;
			
		case "ATRAS":
			
			
			this.dispose();			
			break;		
			
		}
	}
	
	public void a�adir()
  	{
 
 
  		Connection conn=sqliteConnection.dbConnector();
  		Statement stmt;
  		try {
  			stmt = conn.createStatement();

 			
// 			String query = "select * from equipo where nombre_e=?";
//			PreparedStatement pst = conn.prepareStatement(query);
//			pst.setString(1, textFieldNombre.getText());
//			
//			
//			ResultSet rs = pst.executeQuery();
//			int count = 0;
//			while(rs.next())
//			{
//				count = count +1;
//			}
//			if(count == 1)
//			{

									
				
				String nombre_e = textFieldNombre.getText();
				
				
				this.LeerContrase�a(nombre_e);
				
				if(LeerContrase�a(nombre_e)==false)
				{
					stmt.executeUpdate("insert into equipo values('"+textFieldNombre.getText()+"', '"+textFieldCiudad.getText()+"', '"+textFieldCategoria.getText()+"')");
				}
					JOptionPane.showMessageDialog(null, "�Equipo a�adido correctamente!");	
					
//				else
//				{
//						JOptionPane.showMessageDialog(null, "Este equipo ya existe");
//				}
		//}
				
				
				
//			rs.close();
//			pst.close();		
				
  			
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
 		
 		finally {
 			  if (conn != null) {
			    try {
 			      conn.close(); // <-- This is important
 			    } catch (SQLException e) {
 			      /* handle exception */
 			    }
 			  }
 			}
  		}
 		
  		
  public boolean LeerContrase�a(String nombre_e)
		{		
	  
 			
 			if(nombre_e.equals("select nombre_e from equipo"))
			{
				retorno=true;
			}
			else
			{
				retorno=false;
				JOptionPane.showMessageDialog(null, "Este equipo ya existe");
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