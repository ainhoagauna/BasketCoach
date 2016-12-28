package LP;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import LD.BD;
import LN.clsGestorAdministrador;

public class frmAñadirEquipo extends JFrame implements ActionListener{
	private JTextField textFieldNombre;
	private JTextField textFieldCiudad;
	private JTextField textFieldCategoria;
	private JTextField textField;
	
	
	
	
	public frmAñadirEquipo() {
		getContentPane().setLayout(null);
		setTitle("Añadir equipo");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(300, 100, 350, 384);
		
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
		
		JButton btnAñadir = new JButton("A\u00D1ADIR");
		btnAñadir.setBounds(53, 272, 89, 23);
		btnAñadir.addActionListener(this);
		btnAñadir.setActionCommand("AÑADIR");		
		getContentPane().add(btnAñadir);
		
		JButton btnSalir = new JButton("ATRAS");
		btnSalir.setBounds(166, 272, 89, 23);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("ATRAS");
		getContentPane().add(btnSalir);
		
		JLabel lblLicenciaEntrenador = new JLabel("Licencia entrenador");
		lblLicenciaEntrenador.setBounds(30, 178, 112, 23);
		getContentPane().add(lblLicenciaEntrenador);
		
		textField = new JTextField();
		textField.setBounds(30, 214, 112, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()){
		case "AÑADIR":
			this.añadir();
			
			break;
			
		case "ATRAS":
			
			
			this.dispose();			
			break;		
			
		}
	}
	
	
	public void añadir()
  	{
		
		String nombre= textFieldNombre.getText();
		String ciudad= textFieldCiudad.getText();
		String categoria=textFieldCategoria.getText();
		String licencia=textField.getText();
		BD base=new BD();
		base.añadirEquipo(nombre,ciudad,categoria,licencia);
 
  		textFieldCategoria.setText("");
		textFieldCiudad.setText("");
		textFieldNombre.setText("");
		textField.setText("");
						
				
		
  	}
 		
  		

	
	
}