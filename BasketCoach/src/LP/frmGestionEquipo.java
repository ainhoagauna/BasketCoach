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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

import LD.sqliteConnection;

import java.awt.Font;



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
	private DefaultListModel modeloLista=new DefaultListModel();
	JScrollPane scrollPaneLista;

	
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
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(537, 380, 161, 30);
		getContentPane().add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setForeground(Color.WHITE);
		lblEquipo.setBounds(29, 35, 46, 14);
		getContentPane().add(lblEquipo);
		
		JLabel lblJugador = new JLabel("Jugador");
		lblJugador.setForeground(Color.WHITE);
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
		
		JButton btnAñadirJug = new JButton("New button");
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
		
				
		
	}
	
	

	@SuppressWarnings("unchecked")
	public void cargarLista()
	{
				
		Connection conn=sqliteConnection.dbConnector();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			
						
			ResultSet rs = stmt.executeQuery("select nombre_e from equipo");
					     
		      while(rs.next())
		      { 
		    	  // Leer el resultset
		    	 
		    	  modeloLista.addElement(rs.getString("nombre_e"));
		    	  list.setModel(modeloLista);		    

		      }
		   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
			break;
			
		case "Salir":
			
			this.dispose();

			frmAdministrador admin = new frmAdministrador();
			admin.setVisible(true);
			admin.toFront();
			
			
		}
		
	}
	
	
}
