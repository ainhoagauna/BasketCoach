package LP;

import LD.sqliteConnection;
import LN.clsGestorAdministrador;

import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.*;

import javax.swing.*;
import java.awt.Color;

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
		setResizable(false);
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
				
		lblLogin = new JLabel("Basket Coach");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 54));
		lblLogin.setBounds(474, 62, 321, 80);
		getContentPane().add(lblLogin);
			
		lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUsuario.setBounds(497, 172, 100, 32);
		getContentPane().add(lblUsuario);
		
		textField_usuario = new JTextField();
		textField_usuario.setBounds(474, 213, 141, 30);
		getContentPane().add(textField_usuario);
		textField_usuario.setColumns(10);
		
		lblContraseña = new JLabel("CONTRASE\u00D1A");
		lblContraseña.setForeground(Color.WHITE);
		lblContraseña.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblContraseña.setBounds(641, 177, 141, 23);
		getContentPane().add(lblContraseña);
		
		pfContraseña = new JPasswordField();
		pfContraseña.setBounds(641, 212, 141, 32);
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
		btnEntrar.setBounds(574, 272, 100, 23);
		getContentPane().add(btnEntrar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.LEFT);
		lblFondo.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Image/fondoPrincipal.jpg")));
		lblFondo.setBounds(0, 0, 817, 469);
		getContentPane().add(lblFondo);
		
		
		setTitle("Basket Coach");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(450, 200, 823, 508);
		
		
	}
}