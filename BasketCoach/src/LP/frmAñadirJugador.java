package LP;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import LD.BD;
import java.awt.Color;

public class frmAñadirJugador extends JFrame implements ActionListener{

	private JTextField textFieldNombre;	
	private JTextField textFieldApe;
	private JTextField textField_contraseina;
	private JTextField textField_num_j;
	private JTextField textField_equipo;
	private JTextField textField_num_licen_e;
	private JTextField textField_num_licen_j;
	
	
	
	public frmAñadirJugador() {
		
		getContentPane().setLayout(null);
		setTitle("Añadir jugador");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(300, 100, 518, 486);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(30, 19, 86, 23);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(30, 50, 86, 30);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel ape1 = new JLabel("Apellido");
		ape1.setBounds(182, 19, 71, 23);
		getContentPane().add(ape1);
		
		textFieldApe = new JTextField();
		textFieldApe.setBounds(182, 50, 170, 30);
		getContentPane().add(textFieldApe);
		textFieldApe.setColumns(10);
		
		JLabel lblLicen_j = new JLabel("Licencia jugador");
		lblLicen_j.setBounds(182, 165, 129, 24);
		getContentPane().add(lblLicen_j);
		
		
		JButton btnAñadir = new JButton("A\u00D1ADIR");
		btnAñadir.setBounds(133, 403, 89, 23);
		btnAñadir.addActionListener(this);
		btnAñadir.setActionCommand("AÑADIR");		
		getContentPane().add(btnAñadir);
		
		JButton btnSalir = new JButton("ATRAS");
		btnSalir.setBounds(272, 403, 89, 23);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("ATRAS");
		getContentPane().add(btnSalir);
		
		JLabel lblNmero = new JLabel("N\u00FAmero jugador");
		lblNmero.setBounds(30, 159, 101, 16);
		getContentPane().add(lblNmero);
		
		JLabel JLabel_asistencia = new JLabel("Contrase\u00F1a");
		JLabel_asistencia.setForeground(Color.BLACK);
		JLabel_asistencia.setBounds(30, 258, 86, 20);
		getContentPane().add(JLabel_asistencia);
		
		textField_contraseina = new JTextField();
		textField_contraseina.setColumns(10);
		textField_contraseina.setBounds(30, 290, 161, 30);
		getContentPane().add(textField_contraseina);
		
		textField_num_j = new JTextField();
		textField_num_j.setColumns(10);
		textField_num_j.setBounds(30, 186, 34, 33);
		getContentPane().add(textField_num_j);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(30, 96, 86, 15);
		getContentPane().add(lblEquipo);
		
		textField_equipo = new JTextField();
		textField_equipo.setBounds(30, 117, 122, 30);
		getContentPane().add(textField_equipo);
		textField_equipo.setColumns(10);
		
		JLabel lblLicenciaEntrenador = new JLabel("Licencia entrenador");
		lblLicenciaEntrenador.setBounds(182, 91, 129, 23);
		getContentPane().add(lblLicenciaEntrenador);
		
		textField_num_licen_e = new JTextField();
		textField_num_licen_e.setBounds(182, 117, 138, 30);
		getContentPane().add(textField_num_licen_e);
		textField_num_licen_e.setColumns(10);
		
		textField_num_licen_j = new JTextField();
		textField_num_licen_j.setBounds(182, 200, 109, 26);
		getContentPane().add(textField_num_licen_j);
		textField_num_licen_j.setColumns(10);
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
		String nombre=textFieldNombre.getText();	
		String ape1=textFieldApe.getText();
		
		//int asistencia=Integer.parseInt(textField_asistencia.getText());
		int num_j=Integer.parseInt(textField_num_j.getText());
		String num_licen_j=textField_num_licen_j.getText();
		String num_licen_e=textField_num_licen_e.getText();
		String equipo=textField_equipo.getText();
		String contraseña=textField_contraseina.getText();
		
		
		if(textField_num_j.getText().isEmpty() || textFieldNombre.getText().isEmpty() ||textFieldApe.getText().isEmpty() ||textField_num_licen_j.getText().isEmpty() ||textField_num_licen_e.getText().isEmpty() ||textField_contraseina.getText().isEmpty() ||textField_equipo.getText().isEmpty()  )
		{
			JOptionPane.showMessageDialog(null, "Rellene todos los campos");
		}
		
		else
		{
			BD base=new BD();
			base.añadirJugador(nombre,ape1,equipo,num_licen_j,num_j,contraseña, num_licen_e);
			
			JOptionPane.showMessageDialog(null, "¡Jugador añadido correctamente!");	
			
			textFieldNombre.setText("");
			textFieldApe.setText("");
			textField_num_j.setText("");
			textField_num_licen_j.setText("");
			textField_num_licen_e.setText("");
			textField_equipo.setText("");
			textField_contraseina.setText("");
		}
		
		
		
		
		
		
		
						
		
		
  	}


	
}
