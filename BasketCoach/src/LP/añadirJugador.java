package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;

public class añadirJugador extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApe1;
	private JTextField textFieldApe2;
	private JTextField textFieldEquipo;
	private JTextField textFieldLicen_j;
	private JTextField textFieldAsistencia;
	private JTextField textFieldNum_j;
	private JTextField textFieldContraseina;
	private JTextField textFieldNum_licen_e;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					añadirJugador frame = new añadirJugador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public añadirJugador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNombre = new JLabel("Nombre jugador");
		lblNombre.setBounds(30, 19, 86, 23);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(30, 50, 86, 30);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel ape1 = new JLabel("Apellido");
		ape1.setBounds(166, 19, 71, 23);
		getContentPane().add(ape1);
		
		textFieldEquipo = new JTextField();
		textFieldEquipo.setBounds(166, 50, 86, 30);
		getContentPane().add(textFieldEquipo);
		textFieldEquipo.setColumns(10);
		
		JLabel lblLicen_j = new JLabel("Licencia jugador");
		lblLicen_j.setBounds(30, 91, 86, 24);
		getContentPane().add(lblLicen_j);
		
		textFieldLicen_j = new JTextField();
		textFieldLicen_j.setBounds(30, 126, 86, 30);
		getContentPane().add(textFieldLicen_j);
		textFieldLicen_j.setColumns(10);
		
		
		
//		
//		JButton btnAñadir = new JButton("A\u00D1ADIR");
//		btnAñadir.setBounds(120, 329, 89, 23);
//		btnAñadir.addActionListener(this);
//		btnAñadir.setActionCommand("AÑADIR");		
//		getContentPane().add(btnAñadir);
//		
//		JButton btnSalir = new JButton("ATRAS");
//		btnSalir.setBounds(5, 5, 536, 373);
//		btnSalir.addActionListener(this);
//		btnSalir.setActionCommand("ATRAS");
//		getContentPane().add(btnSalir);
	}

	public void actionPerformed(ActionEvent arg0) {
	}
}
