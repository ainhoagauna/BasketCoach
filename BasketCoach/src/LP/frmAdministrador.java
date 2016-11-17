package LP;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class frmAdministrador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnGestionDeEquipos;
	private JButton btnAsistencia;
	private JButton btnMinutos;
	private JButton btnRecordatorios;
	private JButton btnQuintetos;
	
	private Dimension tamañoPantalla;
	private Rectangle pantalla;
		
		
	public frmAdministrador()
	{
		this.pack();
		this.setVisible(true);
		                
		createAndShowGUI();
	}
	
	public void createAndShowGUI()
	{
		
		setTitle("BasketCoach - Administrador");	
		setBounds(450, 200, 450, 300);
		
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
