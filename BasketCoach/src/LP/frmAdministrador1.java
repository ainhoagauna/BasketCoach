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


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class frmAdministrador1 extends JFrame implements ActionListener {


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


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	switch(e.getActionCommand()){
	
	case "Equipo":

//	private Dimension tamañoPantalla;
//	private Rectangle pantalla;
		

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
		
		this.salir();
//		this.dispose();			
//		JOptionPane.showMessageDialog(this, "Has cerrado sesión");
		break;
	}
	}
public frmAdministrador1()
	{
//		this.pack();
		this.setVisible(true);
		                
		createAndShowGUI();

	}
	
	

public void salir()
{
	Object[]ops = {"Sí","No","Cancelar" };
	JOptionPane.showOptionDialog( btnSalir,"¿Confirmar?", "Borrado",
	JOptionPane.YES_NO_CANCEL_OPTION,
	JOptionPane.QUESTION_MESSAGE, null,
	ops, ops[0]);
	
	
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




	public void createAndShowGUI()
	{
		
		setTitle("BasketCoach - Administrador");	

		setBounds(600, 200, 600, 300);
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() 
		{
		    @Override
		    public void windowClosing(WindowEvent we)
		    { 
		        String ObjButtons[] = {"Si","Cancelar"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"¿Seguro que deseas salir?","BasketCoach - Aviso",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
		    }
		});

		setBounds(450, 200, 450, 300);

		
		btnGestionDeEquipos = new JButton("Gestion de equipos");
		btnGestionDeEquipos.setBounds(29, 107, 145, 23);
		getContentPane().add(btnGestionDeEquipos);
		btnGestionDeEquipos.addActionListener(this);
		btnGestionDeEquipos.setActionCommand("Equipo");
		
//		lblEquipo= new JLabel("");
//		lblEquipo.setIcon(new ImageIcon(frmAdministrador.class.getResource("/Image/equipo.jpg")));	
//		lblEquipo.setBounds(50, 60, 145, 90);
//		lblEquipo.setVisible(true);
//		getContentPane().add(lblEquipo);
		
		
		btnAsistencia = new JButton("Asistencias");
		btnAsistencia.setBounds(183, 107, 110, 23);
		getContentPane().add(btnAsistencia);
		btnAsistencia.addActionListener(this);
		btnAsistencia.setActionCommand("Asistencia");
		
		btnQuintetos = new JButton("Quintetos");
		btnQuintetos.setBounds(306, 107, 100, 23);
		getContentPane().add(btnQuintetos);
		btnQuintetos.addActionListener(this);
		btnQuintetos.setActionCommand("Quintetos");
		
		btnMinutos = new JButton("Gestion de minutos");
		btnMinutos.setBounds(74, 236, 150, 23);
		getContentPane().add(btnMinutos);
		btnMinutos.addActionListener(this);
		btnMinutos.setActionCommand("Minutos");
		
		btnRecordatorios = new JButton("Recordatorios");
		btnRecordatorios.setBounds(247, 236, 130, 23);
		getContentPane().add(btnRecordatorios);

		btnRecordatorios.addActionListener(this);
		btnRecordatorios.setActionCommand("Recordatorios");
				
		btnSalir= new JButton("Salir");
		btnSalir.setBounds(500,10,80,56);
		getContentPane().add(btnSalir);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		btnSalir.setIcon(new ImageIcon(frmAdministrador1.class.getResource("/Image/LogoutIcon.jpg")));		

		
		this.getContentPane().setLayout(null);		
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() 
		{
		    @Override
		    public void windowClosing(WindowEvent we)
		    { 
		        String ObjButtons[] = {"Si","Cancelar"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"¿Seguro que deseas salir?","BasketCoach - Aviso",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
		    }
		});
		

	}
}
