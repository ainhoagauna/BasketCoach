package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

public class frmRecordatorios extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnSalir;
	private JTextArea txtComent;
	private	JButton btnGuardar;
	private JButton btnBorrar;
	private JLabel lblFechaSeleccionada;
	private JLabel lblRecordatorio;
	private JDateChooser dateChooser;

	
	public frmRecordatorios()
	{
//		this.pack();
		this.setVisible(true);
		setResizable(true);
		
	
		
		createAndShowGUI();
		this.setLocationRelativeTo(null); //Para que la ventana salga en el centro de la pantalla
	}

	public void createAndShowGUI()
	{
		getContentPane().setLayout(null);	
		
		
		btnSalir=new JButton("Salir");
		btnSalir.setBounds(1000,664,100,30);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		getContentPane().add(btnSalir);
		
		txtComent = new JTextArea();
		txtComent.setBounds(323, 210, 393, 267);
		getContentPane().add(txtComent);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(428, 488, 89, 23);
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("Guardar");
		getContentPane().add(btnGuardar);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.setBounds(540, 488, 89, 23);
		btnBorrar.addActionListener(this);
		btnBorrar.setActionCommand("Borrar");
		getContentPane().add(btnBorrar);
		
		lblFechaSeleccionada = new JLabel("Fecha seleccionada");
		lblFechaSeleccionada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblFechaSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaSeleccionada.setBounds(445, 129, 169, 14);
		getContentPane().add(lblFechaSeleccionada);
		
		lblRecordatorio = new JLabel("Recordatorio");
		lblRecordatorio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRecordatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecordatorio.setBounds(445, 185, 169, 14);
		getContentPane().add(lblRecordatorio);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(400, 154, 248, 20);
		getContentPane().add(dateChooser);
		
		
		setTitle("Recordatorios");	
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);	
		setBounds(500, 200, 1145, 744);
		
	}
	
	/** Añade un recordatorio a la tabla RECORDATORIOS de BD, 
	 * que debe estar abierta y tener el formato y los nombres de campos apropiados:
	 * (FECHA_R Date, COMENT_R String)
	 * Usa la sentencia INSERT de SQL.
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @return	true si la inserción es correcta, false en caso contrario
	 */
	public boolean anyadirFilaATabla( Statement st ) {
		
		if (chequearYaTexto(st)) {  // Si está ya en la tabla
			return modificarFilaEnTabla(st);
		}
		// Inserción normal
		try {
			String sentSQL = "insert into RECORDATORIO values(" +
					"'" + dateChooser + "', " +
					"'" + txtComent + "', " + "')";
			int val = st.executeUpdate( sentSQL );
			if (val!=1) return false;  // Se tiene que añadir 1 - error si no
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/** Comprueba si un texto ya en la tabla RECORDATORIO de BD
	 * @param st	Sentencia ya abierta de base de datos
	 * @return	true si el texto ya está en la tabla, false en caso contrario
	 */
	public boolean chequearYaTexto( Statement st ) {
		try {
			String sentSQL = "select * from RECORDATORIO " +
					"where (COMENT_R = '" + txtComent.getText() + "')";			
			ResultSet rs = st.executeQuery( sentSQL );
			if (rs.next()) {  // Normalmente se recorre con un while, pero aquí solo hay que ver si ya existe
				rs.close();
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/** Modifica los datos de un recordatorio en la tabla RECORDATORIO de BD, 
	 * que debe estar abierta y tener el formato y los nombres de campos apropiados:
	 * (FECHA_R Date, COMENT_R string)
	 * Usa la sentencia UPDATE de SQL.
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @return	true si la modificación es correcta, false en caso contrario
	 */
	public boolean modificarFilaEnTabla( Statement st ) {
		try {
			String sentSQL = "update RECORDATORIO set " +
					"FECHA_R = '" + dateChooser + "', " +
					"COMENT_R = '" + txtComent +
					"where (COMENT_R = '" + txtComent.getText() + "')";			
			int val = st.executeUpdate( sentSQL );
			if (val!=1) return false;  // Se tiene que modificar 1, error si no
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		
		case "Salir":
			
			this.dispose();

			frmAdministrador admin = new frmAdministrador();
			admin.setVisible(true);
			admin.toFront();
			
			break;
			
		case "Guardar":
			
			break;
			
		case "Borrar":
			break;
			
		}
		
	}
}
