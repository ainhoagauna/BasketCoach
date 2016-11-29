package LP;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JList;



public class frmGestionEquipo extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldApe1;
	private JTextField textFieldApe2;
	private JTextField textFieldNumJug;
	private JTextField textFieldDNI;
	private JTextField textFieldAsistencia;
	private JTextField textFieldContrase�a;

	
	public frmGestionEquipo()
	{
		getContentPane().setLayout(null);

		getContentPane().setBackground(Color.LIGHT_GRAY);
	
		setTitle("Gestion de equipo");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(300, 100, 800, 600);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(537, 49, 46, 18);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(537, 78, 86, 33);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setBounds(537, 122, 86, 23);
		getContentPane().add(lblApellidos);
		
		textFieldApe1 = new JTextField();
		textFieldApe1.setBounds(537, 156, 104, 32);
		getContentPane().add(textFieldApe1);
		textFieldApe1.setColumns(10);
		
		textFieldApe2 = new JTextField();
		textFieldApe2.setBounds(659, 156, 115, 32);
		getContentPane().add(textFieldApe2);
		textFieldApe2.setColumns(10);
		
		JLabel lblNmeroJugador = new JLabel("N\u00FAmero jugador");
		lblNmeroJugador.setForeground(Color.WHITE);
		lblNmeroJugador.setBounds(649, 49, 125, 18);
		getContentPane().add(lblNmeroJugador);
		
		textFieldNumJug = new JTextField();
		textFieldNumJug.setBounds(646, 78, 34, 33);
		getContentPane().add(textFieldNumJug);
		textFieldNumJug.setColumns(10);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setForeground(Color.WHITE);
		lblDNI.setBounds(537, 199, 46, 23);
		getContentPane().add(lblDNI);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(537, 233, 115, 33);
		getContentPane().add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JLabel lblAsistencia = new JLabel("Asistencia");
		lblAsistencia.setForeground(Color.WHITE);
		lblAsistencia.setBounds(537, 277, 86, 20);
		getContentPane().add(lblAsistencia);
		
		textFieldAsistencia = new JTextField();
		textFieldAsistencia.setBounds(537, 308, 161, 30);
		getContentPane().add(textFieldAsistencia);
		textFieldAsistencia.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBounds(537, 349, 86, 20);
		getContentPane().add(lblContrasea);
		
		textFieldContrase�a = new JTextField();
		textFieldContrase�a.setBounds(537, 380, 161, 30);
		getContentPane().add(textFieldContrase�a);
		textFieldContrase�a.setColumns(10);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setForeground(Color.WHITE);
		lblEquipo.setBounds(29, 35, 46, 14);
		getContentPane().add(lblEquipo);
		
		JLabel lblJugador = new JLabel("Jugador");
		lblJugador.setForeground(Color.WHITE);
		lblJugador.setBounds(204, 35, 46, 14);
		getContentPane().add(lblJugador);
		
		JButton btnA�adirEquipo = new JButton("New button");
		btnA�adirEquipo.setBounds(29, 64, 46, 47);	
		btnA�adirEquipo.addActionListener(this);
		btnA�adirEquipo.setActionCommand("A�adir equipo");
		btnA�adirEquipo.setIcon(new ImageIcon(frmGestionEquipo.class.getResource("/Image/equipo a�adir.png")));
		getContentPane().add(btnA�adirEquipo);
		
		JButton btnEliminEquipo = new JButton("");
		btnEliminEquipo.setBounds(85, 64, 44, 47);
		btnEliminEquipo.setIcon(new ImageIcon(frmGestionEquipo.class.getResource("/Image/eliminar equipo.png")));
		btnEliminEquipo.addActionListener(this);
		btnEliminEquipo.setActionCommand("Eliminar equipo");
		getContentPane().add(btnEliminEquipo);
		
		JButton btnA�adirJug = new JButton("New button");
		btnA�adirJug.setBounds(185, 64, 46, 47);
		btnA�adirJug.addActionListener(this);
		btnA�adirJug.setActionCommand("A�adir jugador");
		btnA�adirJug.setIcon(new ImageIcon(frmGestionEquipo.class.getResource("/Image/a�adir jugador.png")));
		getContentPane().add(btnA�adirJug);
		
		JButton btnEliminJug = new JButton("New button");
		btnEliminJug.setBounds(242, 64, 44, 47);
		btnEliminJug.addActionListener(this);	
		btnEliminJug.setActionCommand("Eliminar jugador");	
		btnEliminJug.setIcon(new ImageIcon(frmGestionEquipo.class.getResource("/Image/eliminar jugador.png")));
		getContentPane().add(btnEliminJug);
		
		JList list = new JList();
		list.setBounds(10, 156, 131, 317);
		getContentPane().add(list);

		lblNombre.setForeground(Color.BLACK);
		lblNombre.setBounds(537, 49, 46, 18);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(537, 78, 86, 33);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
//		JLabel lblApellidos = new JLabel("Apellidos");
//		lblApellidos.setForeground(Color.BLACK);
//		lblApellidos.setBounds(537, 122, 86, 23);
//		getContentPane().add(lblApellidos);
//		
//		textFieldApe1 = new JTextField();
//		textFieldApe1.setBounds(537, 156, 104, 32);
//		getContentPane().add(textFieldApe1);
//		textFieldApe1.setColumns(10);
//		
//		textFieldApe2 = new JTextField();
//		textFieldApe2.setBounds(659, 156, 115, 32);
//		getContentPane().add(textFieldApe2);
//		textFieldApe2.setColumns(10);
//		
//		JLabel lblNmeroJugador = new JLabel("N\u00FAmero jugador");
//		lblNmeroJugador.setForeground(Color.BLACK);
//		lblNmeroJugador.setBounds(649, 49, 125, 18);
//		getContentPane().add(lblNmeroJugador);
//		
//		textFieldNumJug = new JTextField();
//		textFieldNumJug.setBounds(646, 78, 34, 33);
//		getContentPane().add(textFieldNumJug);
//		textFieldNumJug.setColumns(10);
//		
//		JLabel lblDNI = new JLabel("DNI");
//		lblDNI.setForeground(Color.BLACK);
//		lblDNI.setBounds(537, 199, 46, 23);
//		getContentPane().add(lblDNI);
//		
//		textFieldDNI = new JTextField();
//		textFieldDNI.setBounds(537, 233, 115, 33);
//		getContentPane().add(textFieldDNI);
//		textFieldDNI.setColumns(10);
//		
//		JLabel lblAsistencia = new JLabel("Asistencia");
//		lblAsistencia.setForeground(Color.BLACK);
//		lblAsistencia.setBounds(537, 277, 86, 20);
//		getContentPane().add(lblAsistencia);
//		
//		textFieldAsistencia = new JTextField();
//		textFieldAsistencia.setBounds(537, 308, 161, 30);
//		getContentPane().add(textFieldAsistencia);
//		textFieldAsistencia.setColumns(10);
//		
//		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
//		lblContrasea.setForeground(Color.BLACK);
//		lblContrasea.setBounds(537, 349, 86, 20);
//		getContentPane().add(lblContrasea);
//		
//		textFieldContrase�a = new JTextField();
//		textFieldContrase�a.setBounds(537, 380, 161, 30);
//		getContentPane().add(textFieldContrase�a);
//		textFieldContrase�a.setColumns(10);
//		
//		JLabel lblEquipo = new JLabel("Equipo");
//		lblEquipo.setForeground(Color.BLACK);
//		lblEquipo.setBounds(29, 35, 46, 14);
//		getContentPane().add(lblEquipo);
//		
//		JLabel lblJugador = new JLabel("Jugador");
//		lblJugador.setForeground(Color.BLACK);
//		lblJugador.setBounds(204, 35, 46, 14);
//		getContentPane().add(lblJugador);
//				
//		ButtonIcon btnA�adirEquipo=new ButtonIcon();
//		btnA�adirEquipo.setBounds(29, 64, 46, 47);	
//		btnA�adirEquipo.setIcon(new ImageIcon(frmGestionEquipo.class.getResource("/Image/equipo a�adir.png")));
//		btnA�adirEquipo.addActionListener(this);
//		btnA�adirEquipo.setActionCommand("A�adir equipo");
//		getContentPane().add(btnA�adirEquipo);
//		
//		
//		ButtonIcon btnEliminEquipo = new ButtonIcon();
//		btnEliminEquipo.setBounds(85, 64, 44, 47);
//		btnEliminEquipo.setIcon(new ImageIcon(frmGestionEquipo.class.getResource("/Image/eliminar equipo.png")));
//		btnEliminEquipo.addActionListener(this);
//		btnEliminEquipo.setActionCommand("Eliminar equipo");
//		getContentPane().add(btnEliminEquipo);
//		
//		ButtonIcon btnA�adirJug = new ButtonIcon();
//		btnA�adirJug.setBounds(185, 64, 46, 47);
//		btnA�adirJug.addActionListener(this);
//		btnA�adirJug.setActionCommand("A�adir jugador");
//		btnA�adirJug.setIcon(new ImageIcon(frmGestionEquipo.class.getResource("/Image/a�adir jugador.png")));
//		getContentPane().add(btnA�adirJug);
//		
//		ButtonIcon btnEliminJug = new ButtonIcon();
//		btnEliminJug.setBounds(242, 64, 44, 47);
//		btnEliminJug.addActionListener(this);	
//		btnEliminJug.setActionCommand("Eliminar jugador");	
//		btnEliminJug.setIcon(new ImageIcon(frmGestionEquipo.class.getResource("/Image/eliminar jugador.png")));
//		getContentPane().add(btnEliminJug);
//		
//		JList list = new JList();
//		list.setBounds(10, 156, 131, 317);
//		getContentPane().add(list);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(534, 502, 89, 23);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		getContentPane().add(btnSalir);
		
				
		createAndShowGUI();
	}

	public void createAndShowGUI()
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		
		case "A�adir equipo":
			
			frmA�adirEquipo objA�a=new frmA�adirEquipo();
			objA�a.setVisible(true);
			break;
			
		case "Salir":
			
			this.dispose();

			frmAdministrador admin = new frmAdministrador();
			admin.setVisible(true);
			admin.toFront();
			
			
		}
		
	}
	
}
