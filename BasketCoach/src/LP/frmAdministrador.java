package LP;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmAdministrador extends JFrame implements ActionListener {

private JButton btnGestionDeEquipos;
private JButton btnAsistencia;
private JButton btnMinutos;
private JButton btnRecordatorios;
private JButton btnQuintetos;
private JButton btnSalir;

private JLabel lblEquipo;
private JLabel lblQuinteto;
private JLabel lblAsistencia;
private JLabel lblMinutos;
private JLabel lblRecordatorios;

private JPanel contentPane;

	
public frmAdministrador()
{
	this.pack();
	this.setVisible(true);
	setResizable(true);
	
	
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	
	

	createAndShowGUI();
}

public void createAndShowGUI()
{
	//getContentPane().setLayout(null);
	
	btnSalir= new JButton("Salir");
	btnSalir.setBounds(500,10,80,56);
	getContentPane().add(btnSalir);
	btnSalir.addActionListener(this);
	btnSalir.setActionCommand("Salir");
	btnSalir.setIcon(new ImageIcon(frmAdministrador.class.getResource("/Image/LogoutIcon.jpg")));
	
	
	btnGestionDeEquipos = new JButton("Gestion de equipos");
	btnGestionDeEquipos.setBounds(50, 150, 145, 23);
	getContentPane().add(btnGestionDeEquipos);
	btnGestionDeEquipos.addActionListener(this);
	btnGestionDeEquipos.setActionCommand("Equipo");

	lblEquipo= new JLabel("");
	lblEquipo.setIcon(new ImageIcon(frmAdministrador.class.getResource("/Image/equipo.jpg")));	
	lblEquipo.setBounds(50, 60, 145, 90);
	lblEquipo.setVisible(true);
	getContentPane().add(lblEquipo);
	
	btnAsistencia = new JButton("Asistencias");
	btnAsistencia.setBounds(220, 150, 110, 23);
	getContentPane().add(btnAsistencia);
	btnAsistencia.addActionListener(this);
	btnAsistencia.setActionCommand("Asistencia");
	

	lblAsistencia= new JLabel("");
	lblAsistencia.setIcon(new ImageIcon(frmAdministrador.class.getResource("/Image/Asistencia.jpg")));
	lblAsistencia.setBounds(220, 60, 110,90);
	lblAsistencia.setVisible(true);
	getContentPane().add(lblAsistencia);
	
	
	btnQuintetos = new JButton("Quintetos");
	btnQuintetos.setBounds(350, 150, 100, 23);
	getContentPane().add(btnQuintetos);
	btnQuintetos.addActionListener(this);
	btnQuintetos.setActionCommand("Quintetos");
	
	btnMinutos = new JButton("Gestion de minutos");
	btnMinutos.setBounds(74, 300, 150, 23);
	getContentPane().add(btnMinutos);
	btnMinutos.addActionListener(this);
	btnMinutos.setActionCommand("Minutos");
	
	btnRecordatorios = new JButton("Recordatorios");
	btnRecordatorios.setBounds(300, 300, 130, 23);
	getContentPane().add(btnRecordatorios);
	btnRecordatorios.addActionListener(this);
	btnRecordatorios.setActionCommand("Recordatorios");
	
	setTitle("Administrador");	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	this.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
	//setBounds(600, 300, 600, 400);
	
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	switch(e.getActionCommand()){
	
	case "Equipo":
		
		this.dispose();
		this.equipo();		
		break;
		
	case "Asistencia":				
		
		this.asistencia();
	    break;		
	case "Quintetos":
		
		this.quintetos();
		break;
	
	case "Minutos":
		
		this.minutos();
		break;
		
	case "Recordatorios":
		
		this.recordatorios();
		break;
	
	case "Salir":
		
		this.dispose();
		frmPrincipal principal=new frmPrincipal();		
		JOptionPane.showMessageDialog(this, "Has cerrado sesión");
		principal.setVisible(true);
		break;
	}
	
}

public void equipo()
{
	frmGestionEquipo frame=new frmGestionEquipo();
	frame.setVisible(true);
	
	frame.toFront();
}

public void asistencia()
{
	frmAsistencia frame=new frmAsistencia();
	frame.setVisible(true);

	frame.toFront();
}

public void quintetos()
{
	frmQuintetos frame=new frmQuintetos();
	frame.setVisible(true);
	
	frame.toFront();
}
public void minutos()
{
	frmMinutos frame=new frmMinutos();
	frame.setVisible(true);
	
	frame.toFront();
}

public void recordatorios()
{
	frmRecordatorios frame=new frmRecordatorios();
	frame.setVisible(true);
	
	frame.toFront();
}



}
