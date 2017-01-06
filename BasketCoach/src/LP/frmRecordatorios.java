package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import LD.BD;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class frmRecordatorios extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnSalir;
	private JTextArea txtComent;
	@SuppressWarnings("unused")
	private String txtComent2;
	private	JButton btnGuardar;
	private JButton btnBorrar;
	private JLabel lblFechaSeleccionada;
	private JLabel lblRecordatorio;
	private JDateChooser dateChooser;
	private JList list;
	 private DefaultListModel modeloLista=new DefaultListModel();
	 private JScrollPane scrollPane;

	
	public frmRecordatorios()
	{
//		this.pack();
		this.setVisible(true);
		setResizable(true);
	
		
		createAndShowGUI();
		
		JLabel labelEvento = new JLabel("Eventos programados");
		labelEvento.setHorizontalAlignment(SwingConstants.CENTER);
		labelEvento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelEvento.setBounds(39, 181, 169, 23);
		getContentPane().add(labelEvento);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 214, 361, 263);
		getContentPane().add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		this.setLocationRelativeTo(null); //Para que la ventana salga en el centro de la pantalla
		
		llenar();
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
		txtComent.setBounds(521, 210, 393, 267);
		getContentPane().add(txtComent);
		
		txtComent2 = txtComent.getText();
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(641, 504, 89, 23);
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("Guardar");
		getContentPane().add(btnGuardar);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.setBounds(772, 504, 89, 23);
		btnBorrar.addActionListener(this);
		btnBorrar.setActionCommand("Borrar");
		getContentPane().add(btnBorrar);
		
		lblFechaSeleccionada = new JLabel("Fecha seleccionada");
		lblFechaSeleccionada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblFechaSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaSeleccionada.setBounds(619, 119, 169, 14);
		getContentPane().add(lblFechaSeleccionada);
		
		lblRecordatorio = new JLabel("Recordatorio");
		lblRecordatorio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRecordatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecordatorio.setBounds(619, 185, 169, 14);
		getContentPane().add(lblRecordatorio);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(578, 144, 248, 30);
		getContentPane().add(dateChooser);
		
		
		setTitle("Recordatorios");	
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);	
		setBounds(500, 200, 1145, 744);
		
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
			
			this.guardar();
			
			break;
			
		case "Borrar":
			txtComent.setText(null);
			break;
			
		}
		
		
		
	}
	
	public void guardar()
	{
		
				txtComent2=txtComent.getText();
				BD.añadirRecordatorio(dateChooser.getDate().toString(),txtComent2, list,modeloLista);
				txtComent.setText(null);
				llenar();
				

			
	}
	
	public void llenar()
	{
		BD base=new BD();
		base.cargarEventos(list,modeloLista);
	}
}
