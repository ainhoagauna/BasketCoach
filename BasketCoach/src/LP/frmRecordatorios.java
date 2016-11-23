package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import com.toedter.calendar.JCalendar;

public class frmRecordatorios extends JFrame implements ActionListener {
	
private JButton btnSalir;

	
	public frmRecordatorios()
	{
//		this.pack();
		this.setVisible(true);
		setResizable(true);
		
	
		
		createAndShowGUI();
	}

	public void createAndShowGUI()
	{
		getContentPane().setLayout(null);	
		
		
		JButton btnSalir=new JButton("Salir");
		btnSalir.setBounds(545,334,100,30);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		getContentPane().add(btnSalir);		
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(109, 25, 439, 267);
		getContentPane().add(calendar);
		
		
		setTitle("Recordatorios");	
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);	
		setBounds(500, 200, 671, 414);
		
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
