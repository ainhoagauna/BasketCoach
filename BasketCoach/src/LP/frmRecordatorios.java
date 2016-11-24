package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class frmRecordatorios extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnSalir;

	
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
		
		
		JButton btnSalir=new JButton("Salir");
		btnSalir.setBounds(1000,664,100,30);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		getContentPane().add(btnSalir);		
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(106, 208, 439, 267);
		getContentPane().add(calendar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(629, 36, 393, 577);
		getContentPane().add(textArea);
		
		
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
			
		}
		
	}
}
