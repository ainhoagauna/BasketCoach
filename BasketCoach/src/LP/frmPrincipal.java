package LP;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class frmPrincipal extends JFrame

{
	private JTextField textField_usuario;
	private JTextField textField_contrase�a;
	private JLabel lblLogin;
	private JLabel lblUsuario;
	private JLabel lblContrase�a;
	private JButton btnEntrar;
	
	
	
	public frmPrincipal()
	
	{
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		
		createAndShowGUI();
		
	}

public void createAndShowGUI()
{
	getContentPane().setLayout(null);

	
	lblLogin = new JLabel("LOGIN");
	lblLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblLogin.setBounds(187, 5, 141, 32);
	getContentPane().add(lblLogin);
		
	lblUsuario = new JLabel("Usuario");
	lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblUsuario.setBounds(152, 40, 141, 32);
	getContentPane().add(lblUsuario);
	
	textField_usuario = new JTextField();
	textField_usuario.setBounds(152, 69, 141, 30);
	getContentPane().add(textField_usuario);
	textField_usuario.setColumns(10);
	
	lblContrase�a = new JLabel("Contrase\u00F1a");
	lblContrase�a.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblContrase�a.setBounds(152, 110, 115, 14);
	getContentPane().add(lblContrase�a);
	
	textField_contrase�a = new JTextField();
	textField_contrase�a.setBounds(152, 135, 141, 32);
	getContentPane().add(textField_contrase�a);
	textField_contrase�a.setColumns(10);
	
	btnEntrar = new JButton("ENTRAR");
	btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnEntrar.setBounds(165, 202, 100, 23);
	getContentPane().add(btnEntrar);
	
	
	setTitle("Basket Coach");	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	setBounds(450, 200, 450, 300);
	
	
}

}
