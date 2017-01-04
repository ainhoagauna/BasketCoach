package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
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

import LD.BD;


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

	
	public frmRecordatorios()
	{
//		this.pack();
		this.setVisible(true);
		setResizable(true);
	
		
		createAndShowGUI();
		BD.cargarRecordatorio(dateChooser, txtComent2);
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
		
		txtComent2 = txtComent.getText();
		
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
		lblFechaSeleccionada.setBounds(445, 123, 169, 14);
		getContentPane().add(lblFechaSeleccionada);
		
		lblRecordatorio = new JLabel("Recordatorio");
		lblRecordatorio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRecordatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecordatorio.setBounds(445, 185, 169, 14);
		getContentPane().add(lblRecordatorio);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(400, 148, 248, 30);
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
			if(txtComent==null)
			{
				BD.añadirRecordatorio(dateChooser,txtComent2);
			}
			else
			{
				BD.actualizarRecordatorio(dateChooser, txtComent2);
			}
			
			break;
			
		case "Borrar":
			txtComent.setText(null);
			break;
			
		}
		
	}
}
