package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import LD.BD;

public class a extends JFrame implements ActionListener {
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEquipo;
	private JTextField textFieldLicen_j;
	private JTextField textFieldAsistencia;
	private JTextField textFieldNumero;
	private JTextField textFieldContraseña;
	private JTextField textFieldLicen_ent;
	private JTable table=null;
	private DefaultTableModel modelo=null;

	public a()
	{
		getContentPane().setLayout(null);
		desabilitar();
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(30, 32, 56, 16);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(30, 61, 116, 22);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(194, 32, 56, 16);
		getContentPane().add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(194, 61, 116, 22);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(365, 32, 56, 16);
		getContentPane().add(lblEquipo);
		
		textFieldEquipo = new JTextField();
		textFieldEquipo.setBounds(365, 61, 116, 22);
		getContentPane().add(textFieldEquipo);
		textFieldEquipo.setColumns(10);
		
		JLabel lblLicencia = new JLabel("Licencia");
		lblLicencia.setBounds(30, 111, 56, 16);
		getContentPane().add(lblLicencia);
		
		textFieldLicen_j = new JTextField();
		textFieldLicen_j.setBounds(30, 140, 116, 22);
		getContentPane().add(textFieldLicen_j);
		textFieldLicen_j.setColumns(10);
		
		JLabel lblAsistencia = new JLabel("Asistencia");
		lblAsistencia.setBounds(194, 111, 95, 16);
		getContentPane().add(lblAsistencia);
		
		textFieldAsistencia = new JTextField();
		textFieldAsistencia.setBounds(194, 140, 42, 22);
		getContentPane().add(textFieldAsistencia);
		textFieldAsistencia.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(334, 111, 56, 16);
		getContentPane().add(lblNumero);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(328, 140, 56, 22);
		getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(30, 206, 78, 16);
		getContentPane().add(lblContrasea);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(30, 235, 116, 22);
		getContentPane().add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		JLabel lblLicenciaEntrenador = new JLabel("Licencia entrenador");
		lblLicenciaEntrenador.setBounds(194, 206, 163, 16);
		getContentPane().add(lblLicenciaEntrenador);
		
		textFieldLicen_ent = new JTextField();
		textFieldLicen_ent.setBounds(194, 235, 116, 22);
		getContentPane().add(textFieldLicen_ent);
		textFieldLicen_ent.setColumns(10);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(50, 474, 102, 25);
		getContentPane().add(btnNuevo);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(213, 474, 97, 25);
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("GUARDAR");
		getContentPane().add(btnGuardar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(365, 474, 115, 25);
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("MODIFICAR");
		getContentPane().add(btnModificar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(527, 474, 97, 25);
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand("ELIMINAR");
		getContentPane().add(btnEliminar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(673, 474, 97, 25);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("SALIR");
		getContentPane().add(btnSalir);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JUGADORES", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(24, 264, 857, 186);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 18, 845, 161);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		llenar();
		
		
		setTitle("Gestion de equipo");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(300, 100, 917, 600);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		switch(e.getActionCommand()){
			
		case "NUEVO":
			
			limpiar();
			habilitar();
			
			break;
			
		case "MODIFICAR":
			

			break;
			
		case "GUARDAR":
			
			this.guardar();
			break;
			
		case "ELIMINAR":
			
						
			break;
			
		case "SALIR":
			
			this.dispose();

			frmAdministrador admin = new frmAdministrador();
			admin.setVisible(true);
			admin.toFront();
			break;
		}
	}


	void llenar()
	{
		String nombre=null;
		String apellido=null;
		String equipo=null;
		String licen_j=null;
		int asistencia=0;
		int num_j=0;
		String contraseña=null;
		String licen_e=null;
		
		String[] columnas = {"NOMBRE","APELLIDO","EQUIPO","LICENCIA JUGADOR","NUMERO", "CONTRASEÑA", "LICENCIA ENTRENADOR"};
		
		modelo = new DefaultTableModel(null,columnas);		
		table.setModel(modelo);
		
		BD base=new BD();
		base.cargarJugador2(nombre,apellido,equipo,licen_j,asistencia,num_j,contraseña,licen_e,modelo);
		
		modelo.addRow( new Object[] {nombre,apellido,equipo,licen_j,asistencia,num_j,contraseña,licen_e} );
	}

	public void guardar()
	{
		String nombre=textFieldNombre.getText();	
		String ape1=textFieldApellido.getText();
		String equipo=textFieldEquipo.getText();
		String licen_j=textFieldLicen_j.getText();		
		int asistencia=Integer.parseInt(textFieldAsistencia.getText());
		int num_j=Integer.parseInt(textFieldNumero.getText());
		String contraseña=textFieldContraseña.getText();
		String licen_e=textFieldLicen_ent.getText();
		
		
		
		BD base=new BD();
		base.añadirJugador(nombre,ape1,equipo,licen_j,num_j,contraseña,licen_e);
		
		JOptionPane.showMessageDialog(null, "¡Jugador añadido correctamente!");
		
		llenar();
		limpiar();
		
		
	}
	
	public void desabilitar()
	{
		textFieldNombre.setEditable(false);
		textFieldApellido.setEditable(false);
		textFieldEquipo.setEditable(false);
		textFieldLicen_j.setEditable(false);
		textFieldAsistencia.setEditable(false);
		textFieldNumero.setEditable(false);
		textFieldContraseña.setEditable(false);
		textFieldLicen_ent.setEditable(false);
	}
	
	public void habilitar()
	{
		textFieldNombre.setEditable(true);
		textFieldApellido.setEditable(true);
		textFieldEquipo.setEditable(true);
		textFieldLicen_j.setEditable(true);
		textFieldAsistencia.setEditable(true);
		textFieldNumero.setEditable(true);
		textFieldContraseña.setEditable(true);
		textFieldLicen_ent.setEditable(true);
	}
	
	public void limpiar()
	{
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldEquipo.setText("");
		textFieldLicen_j.setText("");
		textFieldAsistencia.setText("");
		textFieldNumero.setText("");
		textFieldContraseña.setText("");
		textFieldLicen_ent.setText("");
	}

}
