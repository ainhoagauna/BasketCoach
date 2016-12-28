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
	private JTextField textField_asistencia;
	private JTextField textField_contraseina;
	private JTextField textField_num_j;
	private JTextField textField_equipo;
	private JTextField textField_num_licen_e;
	private JTextField textField_num_licen_j;
	private JTextField textField_ape2;
	
	
	
	private boolean retorno = false;
	
	Connection conn=BD.dbConnector();
	Statement stmt;
	
	
	
	
	
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
		ape1.setBounds(30, 92, 71, 23);
		getContentPane().add(ape1);
		
		textFieldApe = new JTextField();
		textFieldApe.setBounds(30, 117, 170, 30);
		getContentPane().add(textFieldApe);
		textFieldApe.setColumns(10);
		
		JLabel lblLicen_j = new JLabel("Licencia jugador");
		lblLicen_j.setBounds(311, 18, 129, 24);
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
		lblNmero.setBounds(166, 22, 101, 16);
		getContentPane().add(lblNmero);
		
		JLabel Jlabel_asistencia = new JLabel("Asistencia");
		Jlabel_asistencia.setForeground(Color.BLACK);
		Jlabel_asistencia.setBounds(29, 241, 86, 20);
		getContentPane().add(Jlabel_asistencia);
		
		textField_asistencia = new JTextField();
		textField_asistencia.setColumns(10);
		textField_asistencia.setBounds(29, 272, 161, 30);
		getContentPane().add(textField_asistencia);
		
		JLabel JLabel_asistencia = new JLabel("Contrase\u00F1a");
		JLabel_asistencia.setForeground(Color.BLACK);
		JLabel_asistencia.setBounds(29, 313, 86, 20);
		getContentPane().add(JLabel_asistencia);
		
		textField_contraseina = new JTextField();
		textField_contraseina.setColumns(10);
		textField_contraseina.setBounds(29, 344, 161, 30);
		getContentPane().add(textField_contraseina);
		
		textField_num_j = new JTextField();
		textField_num_j.setColumns(10);
		textField_num_j.setBounds(166, 50, 34, 33);
		getContentPane().add(textField_num_j);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(30, 160, 86, 15);
		getContentPane().add(lblEquipo);
		
		textField_equipo = new JTextField();
		textField_equipo.setBounds(30, 189, 122, 30);
		getContentPane().add(textField_equipo);
		textField_equipo.setColumns(10);
		
		JLabel lblLicenciaEntrenador = new JLabel("Licencia entrenador");
		lblLicenciaEntrenador.setBounds(223, 152, 129, 23);
		getContentPane().add(lblLicenciaEntrenador);
		
		textField_num_licen_e = new JTextField();
		textField_num_licen_e.setBounds(223, 189, 138, 30);
		getContentPane().add(textField_num_licen_e);
		textField_num_licen_e.setColumns(10);
		
		textField_num_licen_j = new JTextField();
		textField_num_licen_j.setBounds(311, 54, 109, 26);
		getContentPane().add(textField_num_licen_j);
		textField_num_licen_j.setColumns(10);
		
		textField_ape2 = new JTextField();
		textField_ape2.setBounds(242, 113, 138, 30);
		getContentPane().add(textField_ape2);
		textField_ape2.setColumns(10);
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
		String ape2=textField_ape2.getText();
		String asistencia=textField_asistencia.getText();
		String num_j=textField_num_j.getText();
		String num_licen_j=textField_num_licen_j.getText();
		String num_licen_e=textField_num_licen_e.getText();
		String equipo=textField_equipo.getText();
		String contraseña=textField_contraseina.getText();
		
		
		BD base=new BD();
		base.añadirJugador(nombre,ape1,ape2,asistencia,num_j,num_licen_j,num_licen_e,equipo,contraseña);
		
		textFieldNombre.setText("");
		textFieldApe.setText("");
		textField_ape2.setText("");
		textField_asistencia.setText("");
		textField_num_j.setText("");
		textField_num_licen_j.setText("");
		textField_num_licen_e.setText("");
		textField_equipo.setText("");
		textField_contraseina.setText("");
						
						
						

	
		
  	}
}
