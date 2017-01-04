package LP;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

import LD.BD;


public class frmEquipoGestion extends JFrame implements ActionListener, MouseListener{
	
	
	
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
	
	private JButton btnNuevo=null;
	private JButton btnGuardar=null;
	private JButton btnModificar=null;
	private JButton btnEliminar=null;
	

	public frmEquipoGestion()
	{		
		getContentPane().setLayout(null);

		
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
		lblContrasea.setBounds(30, 175, 78, 16);
		getContentPane().add(lblContrasea);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(30, 204, 116, 22);
		getContentPane().add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		JLabel lblLicenciaEntrenador = new JLabel("Licencia entrenador");
		lblLicenciaEntrenador.setBounds(194, 175, 163, 16);
		getContentPane().add(lblLicenciaEntrenador);
		
		textFieldLicen_ent = new JTextField();
		textFieldLicen_ent.setBounds(194, 204, 116, 22);
		getContentPane().add(textFieldLicen_ent);
		textFieldLicen_ent.setColumns(10);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(50, 474, 102, 25);
		btnNuevo.addActionListener(this);
		btnNuevo.setActionCommand("NUEVO");
		getContentPane().add(btnNuevo);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(213, 474, 97, 25);
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("GUARDAR");
		getContentPane().add(btnGuardar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(365, 474, 115, 25);
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("MODIFICAR");
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
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
		
				
		desabilitar();
		llenar();
		
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e)
			{
				habilitar();
				textFieldNumero.setEnabled(false);
				limpiar();
			    
			    int row = table.rowAtPoint(e.getPoint());
			// si uno de los campos de la BD esta vacio, dara un error y no mostrará el registro de la siguientes columnas, poner todos los campos a 0 o null por defecto
			    
			    textFieldNumero.setText(table.getValueAt(row, 0).toString());
			    textFieldNombre.setText(table.getValueAt(row, 1).toString());
			    textFieldApellido.setText(table.getValueAt(row, 2).toString());
			    textFieldEquipo.setText(table.getValueAt(row, 3).toString());
			    textFieldLicen_j.setText(table.getValueAt(row, 4).toString());
			    textFieldAsistencia.setText(table.getValueAt(row, 5).toString());			    
			    textFieldContraseña.setText(table.getValueAt(row, 6).toString());
			    textFieldLicen_ent.setText(table.getValueAt(row, 7).toString());
			    
			    btnEliminar.setEnabled(true);
				btnModificar.setEnabled(true);
				btnGuardar.setEnabled(false);
				
			}
			
		});
		
		 
		
		
		setTitle("Gestion de equipo");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(300, 100, 917, 600);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		switch(e.getActionCommand()){
			
		case "NUEVO":
			
			btnGuardar.setEnabled(true);
			btnModificar.setEnabled(false);
			btnEliminar.setEnabled(false);
			limpiar();
			habilitar();
			
			break;
			
		case "MODIFICAR":
			
			this.modificar();
			break;
			
		case "GUARDAR":
			
			this.guardar();
			break;
			
		case "ELIMINAR":
			
			this.eliminar();			
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
		
		String[] columnas = {"NUMERO","NOMBRE","APELLIDO","EQUIPO","LICENCIA JUGADOR","ASISTENCIA", "CONTRASEÑA", "LICENCIA ENTRENADOR"};
		
		modelo = new DefaultTableModel(null,columnas);		
		table.setModel(modelo);
		
		BD base=new BD();
		base.cargarJugador2(num_j,nombre,apellido,equipo,licen_j,asistencia,contraseña,licen_e,modelo);
		
		modelo.addRow( new Object[] {num_j,nombre,apellido,equipo,licen_j,asistencia,contraseña,licen_e} );
		
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
		
		
		if(base.leerNumero(num_j)==true)
		{
			JOptionPane.showMessageDialog(null, "¡Ya existe un jugador con ese número!");
		}
		
		else
		{
			base.añadirJugador(nombre,ape1,equipo,licen_j,num_j,contraseña,licen_e);
			
			JOptionPane.showMessageDialog(null, "¡Jugador añadido correctamente!");
			
			llenar();
			limpiar();
		}
		
		
		
	}
	
	public void eliminar()
	{
		int fila=table.getSelectedRow();
		
		
		BD base=new BD();
		base.eliminarJugador(table, fila,0);
		
	   
	        llenar();
	        JOptionPane.showMessageDialog(null, "Jugador eliminado");
	        limpiar();
	   
	}
	
	public void modificar()
	{
		
		int fila=table.getSelectedRow();
		int columna=table.getSelectedColumn();
		
		String nombre=textFieldNombre.getText();	
		String ape1=textFieldApellido.getText();
		String equipo=textFieldEquipo.getText();
		String licen_j=textFieldLicen_j.getText();		
		int asistencia=Integer.parseInt(textFieldAsistencia.getText());
		int num_j=Integer.parseInt(textFieldNumero.getText());
		String contraseña=textFieldContraseña.getText();
		String licen_e=textFieldLicen_ent.getText();
		
		BD base=new BD();
		base.modificarJugador(nombre,ape1,equipo,licen_j,num_j,contraseña,licen_e,table, fila,columna);
		
	   
	        llenar();
	        JOptionPane.showMessageDialog(null, "Jugador modificado");
	        limpiar();
		
		
	}
	public void desabilitar()
	{
		
		textFieldNombre.setEnabled(false);
		textFieldApellido.setEnabled(false);
		textFieldEquipo.setEnabled(false);
		textFieldLicen_j.setEnabled(false);
		textFieldAsistencia.setEnabled(false);
		textFieldNumero.setEnabled(false);
		textFieldContraseña.setEnabled(false);
		textFieldLicen_ent.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnModificar.setEnabled(false);
		
	}
	
	public void habilitar()
	{
		textFieldNombre.requestFocus();
		textFieldNombre.setEnabled(true);
		textFieldApellido.setEnabled(true);
		textFieldEquipo.setEnabled(true);
		textFieldLicen_j.setEnabled(true);
		textFieldAsistencia.setEnabled(true);
		textFieldNumero.setEnabled(true);
		textFieldContraseña.setEnabled(true);
		textFieldLicen_ent.setEnabled(true);
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

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	


	

}