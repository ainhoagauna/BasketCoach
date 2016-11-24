package LP;

import LD.sqliteConnection;
import LN.clsGestorAdministrador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.*;

import javax.swing.*;

public class frmPrincipal extends JFrame

{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField textField_usuario;
	private JLabel lblLogin;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JButton btnEntrar;
	private JPasswordField pfContraseña;
	
	Connection connection = null;
		
	public frmPrincipal()
	{
		createAndShowGUI();
		this.setLocationRelativeTo(null); //Para que la ventana salga en el centro de la pantalla
		
		connection = sqliteConnection.dbConnector();
		
	}

	public void createAndShowGUI()
	{
		getContentPane().setLayout(null);
		
		String path = "/Image/airjordan.png";  
		URL url = this.getClass().getResource(path);  
		ImageIcon icon = new ImageIcon(url);  
		  
		JLabel label = new JLabel(" ");  
		label.setIcon(icon); 
				
		lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogin.setBounds(188, 27, 66, 32);
		getContentPane().add(lblLogin);
			
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(102, 93, 66, 32);
		getContentPane().add(lblUsuario);
		
		textField_usuario = new JTextField();
		textField_usuario.setBounds(67, 123, 141, 30);
		getContentPane().add(textField_usuario);
		textField_usuario.setColumns(10);
		
		lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContraseña.setBounds(264, 102, 87, 14);
		getContentPane().add(lblContraseña);
		
		pfContraseña = new JPasswordField();
		pfContraseña.setBounds(234, 122, 141, 32);
		getContentPane().add(pfContraseña);
		pfContraseña.setColumns(10);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String query = "select * from LOGIN where USERNAME=? and PASSWORD=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textField_usuario.getText());
					pst.setString(2, pfContraseña.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next())
					{
						count = count +1;
					}
					if(count == 1)
					{
						JOptionPane.showMessageDialog(null, "Has iniciado sesión correctamente");
											
						clsGestorAdministrador objA = new clsGestorAdministrador();		
	
						String nombre = textField_usuario.getText();
						String contraseña = pfContraseña.getText();
						
						objA.LeerContraseña(nombre, contraseña);
						
						if(objA.LeerContraseña(nombre, contraseña)==true)
						{
							frmAdministrador objAdmin = new frmAdministrador();
							objAdmin.setVisible(true);						
						}
						else
						{		
							
						}
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "Usuario y contraseña duplicados");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos");
					}				
					
					rs.close();
					pst.close();
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);				
				}
							
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.setBounds(168, 189, 100, 23);
		getContentPane().add(btnEntrar);
		
		
		setTitle("Basket Coach");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(450, 200, 450, 300);
		
		
	}
	



}