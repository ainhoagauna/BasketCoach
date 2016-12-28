package LP;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

import LD.BD;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.event.ListDataListener;



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
	private JTextField textFieldContraseña;
	private JList list;
	private JList jugador;
	private DefaultListModel modeloLista=new DefaultListModel();
	private DefaultListModel modeloLista2=new DefaultListModel();
	JScrollPane scrollPaneLista;
	private JTextField textField;
	private JTextField textField_num_licen_e;

	
	public frmGestionEquipo()
	{
		getContentPane().setLayout(null);
			
	
		setTitle("Gestion de equipo");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(300, 100, 917, 600);
					
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setBounds(537, 49, 46, 18);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(537, 78, 86, 33);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(Color.BLACK);
		lblApellidos.setBounds(537, 122, 86, 23);
		getContentPane().add(lblApellidos);
		
		textFieldApe1 = new JTextField();
		textFieldApe1.setBounds(537, 156, 130, 32);
		getContentPane().add(textFieldApe1);
		textFieldApe1.setColumns(10);
		
		textFieldApe2 = new JTextField();
		textFieldApe2.setBounds(694, 156, 115, 32);
		getContentPane().add(textFieldApe2);
		textFieldApe2.setColumns(10);
		
		JLabel lblNmeroJugador = new JLabel("N\u00FAmero jugador");
		lblNmeroJugador.setForeground(Color.BLACK);
		lblNmeroJugador.setBounds(649, 49, 125, 18);
		getContentPane().add(lblNmeroJugador);
		
		textFieldNumJug = new JTextField();
		textFieldNumJug.setBounds(646, 78, 34, 33);
		getContentPane().add(textFieldNumJug);
		textFieldNumJug.setColumns(10);
		
		JLabel lblDNI = new JLabel("Equipo");
		lblDNI.setForeground(Color.BLACK);
		lblDNI.setBounds(537, 199, 46, 23);
		getContentPane().add(lblDNI);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(537, 233, 115, 33);
		getContentPane().add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JLabel lblAsistencia = new JLabel("Asistencia");
		lblAsistencia.setForeground(Color.BLACK);
		lblAsistencia.setBounds(537, 277, 86, 20);
		getContentPane().add(lblAsistencia);
		
		textFieldAsistencia = new JTextField();
		textFieldAsistencia.setBounds(537, 308, 161, 30);
		getContentPane().add(textFieldAsistencia);
		textFieldAsistencia.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.BLACK);
		lblContrasea.setBounds(537, 349, 86, 20);
		getContentPane().add(lblContrasea);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(537, 380, 161, 30);
		getContentPane().add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setForeground(Color.BLACK);
		lblEquipo.setBounds(29, 35, 46, 14);
		getContentPane().add(lblEquipo);
		
		JLabel lblJugador = new JLabel("Jugador");
		lblJugador.setForeground(Color.BLACK);
		lblJugador.setBounds(204, 35, 46, 14);
		getContentPane().add(lblJugador);
		
		JButton btnAñadirEquipo = new JButton("New button");
		btnAñadirEquipo.setBounds(29, 64, 46, 47);	
		btnAñadirEquipo.addActionListener(this);
		btnAñadirEquipo.setActionCommand("Añadir equipo");
		btnAñadirEquipo.setIcon(new ImageIcon(frmGestionEquipo.class.getResource("/Image/equipo añadir.png")));
		getContentPane().add(btnAñadirEquipo);
		
		JButton btnEliminEquipo = new JButton("");
		btnEliminEquipo.setBounds(85, 64, 44, 47);
		btnEliminEquipo.setIcon(new ImageIcon(frmGestionEquipo.class.getResource("/Image/eliminar equipo.png")));
		btnEliminEquipo.addActionListener(this);
		btnEliminEquipo.setActionCommand("Eliminar equipo");
		getContentPane().add(btnEliminEquipo);
		
		JButton btnAñadirJug = new JButton("");
		btnAñadirJug.setBounds(185, 64, 46, 47);
		btnAñadirJug.addActionListener(this);
		btnAñadirJug.setActionCommand("Añadir jugador");
		btnAñadirJug.setIcon(new ImageIcon(frmGestionEquipo.class.getResource("/Image/añadir jugador.png")));
		getContentPane().add(btnAñadirJug);
		
		JButton btnEliminJug = new JButton("New button");
		btnEliminJug.setBounds(242, 64, 44, 47);
		btnEliminJug.addActionListener(this);	
		btnEliminJug.setActionCommand("Eliminar jugador");	
		btnEliminJug.setIcon(new ImageIcon(frmGestionEquipo.class.getResource("/Image/eliminar jugador.png")));
		getContentPane().add(btnEliminJug);
		
		list = new JList();
		list.setBounds(10, 156, 86, 141);
		getContentPane().add(list);
		
		cargarLista();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(135, 163, 178, 269);
		getContentPane().add(scrollPane);
		
		jugador=new JList();
		scrollPane.setViewportView(jugador);
		
		cargarListaJugador();

		lblNombre.setForeground(Color.BLACK);
		lblNombre.setBounds(537, 49, 46, 18);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(537, 78, 86, 33);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(534, 502, 89, 23);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		getContentPane().add(btnSalir);
		
		JLabel lblEquipoList = new JLabel("EQUIPOS");
		lblEquipoList.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEquipoList.setBounds(10, 131, 86, 14);
		getContentPane().add(lblEquipoList);
		
		JLabel lblLicenciaJugador = new JLabel("Licencia jugador");
		lblLicenciaJugador.setBounds(773, 49, 114, 17);
		getContentPane().add(lblLicenciaJugador);
		
		textField = new JTextField();
		textField.setText("                      ");
		textField.setBounds(773, 78, 96, 33);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEntrenador = new JLabel("Licencia entrenador");
		lblEntrenador.setBounds(694, 200, 103, 21);
		getContentPane().add(lblEntrenador);
		
		textField_num_licen_e = new JTextField();
		textField_num_licen_e.setBounds(694, 233, 145, 33);
		getContentPane().add(textField_num_licen_e);
		textField_num_licen_e.setColumns(10);
		
	
		
	}
	
	

	@SuppressWarnings("unchecked")
	public void cargarLista()
	{
		BD base=new BD();
		base.cargarLista(modeloLista);
		   	 
	    list.setModel(modeloLista);		    

		
		   
		
		
	}	
		
	@SuppressWarnings("unchecked")
	public void cargarListaJugador()
		{
		
		
		
		BD base=new BD();
		base.cargarJugador(modeloLista2);
		   	 
	    jugador.setModel(modeloLista2);
	    
	   
}
	    
		
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		
		case "Añadir equipo":
			
			frmAñadirEquipo objAña=new frmAñadirEquipo();
			objAña.setVisible(true);
			break;
			
		case "Eliminar equipo":
			
//			eliminarEquipo objElim=new eliminarEquipo();
//			objElim.actionPerformed(null);
			this.eliminarEquipo();
			break;
			
		case "Añadir jugador":
			
			frmAñadirJugador objAñadir=new frmAñadirJugador();
			objAñadir.setVisible(true);
			break;
			
		case "Salir":
			
			this.dispose();

			frmAdministrador admin = new frmAdministrador();
			admin.setVisible(true);
			admin.toFront();
			
			
		}
		
		
	}
	
	public void eliminarEquipo()
	{
		System.out.println("ok");
		int i=0;
		modeloLista.getElementAt(i);
		eliminarEquipo objElim=new eliminarEquipo();
		
		
	}
}
