package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class frmUsuarioMinutos extends JFrame implements ActionListener {
	private JButton btnSalir;

	
	public frmUsuarioMinutos()
	{
		this.pack();
		this.setVisible(true);
		setResizable(true);
	
		
		createAndShowGUI();
		this.setLocationRelativeTo(null); //Para que la ventana salga en el centro de la pantalla
	}

	public void createAndShowGUI()
	{
		getContentPane().setLayout(null);		
		
		JButton btnSalir=new JButton("Salir");
		btnSalir.setBounds(400,210,100,30);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		getContentPane().add(btnSalir);
		
		
		
		setTitle("Gestión de minutos");	
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);	
		setBounds(500, 200, 600, 300);
		
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
