package LP;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmAdministrador extends JFrame {

private JButton btnGestionDeEquipos;
private JButton btnAsistencia;
private JButton btnMinutos;
private JButton btnRecordatorios;
private JButton btnQuintetos;


	
public frmAdministrador()
{
	this.pack();
	this.setVisible(true);
	createAndShowGUI();
}

public void createAndShowGUI()
{
	getContentPane().setLayout(null);
	
	btnGestionDeEquipos = new JButton("Gestion de equipos");
	btnGestionDeEquipos.setBounds(29, 107, 145, 23);
	getContentPane().add(btnGestionDeEquipos);
	
	btnAsistencia = new JButton("Asistencias");
	btnAsistencia.setBounds(183, 107, 110, 23);
	getContentPane().add(btnAsistencia);
	
	btnQuintetos = new JButton("Quintetos");
	btnQuintetos.setBounds(306, 107, 100, 23);
	getContentPane().add(btnQuintetos);
	
	btnMinutos = new JButton("Gestion de minutos");
	btnMinutos.setBounds(74, 236, 150, 23);
	getContentPane().add(btnMinutos);
	
	btnRecordatorios = new JButton("Recordatorios");
	btnRecordatorios.setBounds(247, 236, 130, 23);
	getContentPane().add(btnRecordatorios);
	
	setTitle("Administrador");	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	setBounds(450, 200, 450, 300);
	
}
}
