package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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


public class frmUsuarioRecordatorios extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnSalir;
	@SuppressWarnings("unused")
	private String txtComent2;
	private JList list;
	 private DefaultListModel modeloLista=new DefaultListModel();
	 private JScrollPane scrollPane;

	
	public frmUsuarioRecordatorios()
	{
//		this.pack();
		this.setVisible(true);
		setResizable(true);
	
		
		createAndShowGUI();
		
		JLabel labelEvento = new JLabel("Eventos programados");
		labelEvento.setHorizontalAlignment(SwingConstants.CENTER);
		labelEvento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelEvento.setBounds(487, 183, 169, 23);
		getContentPane().add(labelEvento);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(312, 242, 535, 260);
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

			frmUsuario usu = new frmUsuario();
			usu.setVisible(true);
			usu.toFront();
			break;
			
		}
		
		
		
	}
	
	
	
	public void llenar()
	{
		BD base=new BD();
		base.cargarEventos(list,modeloLista);
	}
}
