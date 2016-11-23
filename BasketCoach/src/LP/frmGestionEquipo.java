package LP;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class frmGestionEquipo extends JFrame implements ActionListener{

private JButton btnSalir;

	
	public frmGestionEquipo()
	{
		getContentPane().setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 333, 21);
		getContentPane().add(menuBar);
		
		JMenu mnEquipo = new JMenu("Equipo");
		menuBar.add(mnEquipo);
		
		JMenuItem mntmNuevoEquipo = new JMenuItem("Nuevo equipo");
		mnEquipo.add(mntmNuevoEquipo);
		
		JMenuItem mntmBorraEquipo = new JMenuItem("Borra equipo");
		mnEquipo.add(mntmBorraEquipo);
		
		JMenu mnJugador = new JMenu("Jugador");
		menuBar.add(mnJugador);
		
		JMenuItem mntmNuevoJugador = new JMenuItem("Nuevo jugador");
		mnJugador.add(mntmNuevoJugador);
	
		
		createAndShowGUI();
	}

	public void createAndShowGUI()
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		
		case "Salir":
			
			this.dispose();
			frmAdministrador admin=new frmAdministrador();
			admin.setVisible(true);
		}
		
	}
}
