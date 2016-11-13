package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class frmRecordatorios extends JFrame implements ActionListener {
	
private JButton btnSalir;

	
	public frmRecordatorios()
	{
		this.pack();
		this.setVisible(true);
		setResizable(true);
	
		
		createAndShowGUI();
	}

	public void createAndShowGUI()
	{
		getContentPane().setLayout(null);		
		
		JButton btnSalir=new JButton("Salir");
		btnSalir.setBounds(400,210,100,30);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		getContentPane().add(btnSalir);
		
		
		
		setTitle("Gestión de equipos");	
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);	
		setBounds(500, 200, 600, 300);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		
		case "Salir":
			
			this.dispose();
			frmAdministrador admin=new frmAdministrador();
			admin.setVisible(true);
		}
		
	}

}
