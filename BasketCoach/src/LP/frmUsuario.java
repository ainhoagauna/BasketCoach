package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class frmUsuario extends JFrame implements ActionListener{

	
	private JButton btnAsistencia;
	private JButton btnMinutos;
	private JButton btnRecordatorios;
	private JButton btnSalir;

	private JLabel lblAsistencia;
	private JLabel lblMinutos;
	private JLabel lblRecordatorios;

	private JPanel contentPane;

		
	public frmUsuario()
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
		btnSalir.setBounds(500,10,80,64);
		getContentPane().add(btnSalir);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		btnSalir.setIcon(new ImageIcon(frmAdministrador.class.getResource("/Image/LogoutIcon.jpg")));
		
		
				
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
		
		setTitle("Usuario");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
		//setBounds(600, 300, 600, 400);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		
					
		case "Asistencia":				
			
			this.asistencia();
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

	

	public void asistencia()
	{
		frmUsuarioAsistencia frame=new frmUsuarioAsistencia();
		frame.setVisible(true);

		frame.toFront();
	}

	
	public void minutos()
	{
		frmUsuarioMinutos frame=new frmUsuarioMinutos();
		frame.setVisible(true);
		
		frame.toFront();
	}

	public void recordatorios()
	{
		frmUsuarioRecordatorios frame=new frmUsuarioRecordatorios();
		frame.setVisible(true);
		
		frame.toFront();
	}


}
