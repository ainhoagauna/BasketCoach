package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import LD.BD;
import javax.swing.JPanel;

public class frmQuinteto extends JFrame implements ActionListener{
		
	private DefaultTableModel modelo=null;
	private JTable table_1=null;
	
	
	public frmQuinteto() {
	
		getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(334, 395, 97, 25);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("SALIR");
		getContentPane().add(btnSalir);
		
		table_1 = new JTable();
		table_1.setBounds(22, 100, 743, 226);
		getContentPane().add(table_1);
		
		llenar();
		
		
		
		setTitle("Quinteto");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(300, 100, 821, 563);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand()){
		case "SALIR":
				
			this.dispose();

			frmAdministrador admin = new frmAdministrador();
			admin.setVisible(true);
			admin.toFront();
			
			break;
			
	}
	}
	
	public void llenar()
	{
		int num_j=0;
		String apellido=null;
		int num_cuarto=0;
		
		String uno=null;
		String dos=null;
		String tres=null;
		String cuatro=null;
		
		String[] columnas = {"NUMERO","NOMBRE", "PRIMER CUARTO", "SEGUNDO CUARTO", "TERCER CUARTO", "CUARTO CUARTO"};
		
		modelo = new DefaultTableModel();	
		modelo.setColumnIdentifiers(columnas);
		table_1.setModel(modelo);
		
		BD base=new BD();
		base.cargarQuintetos(num_j,apellido,uno,dos,tres,cuatro,modelo);
		
		 modelo.addRow( new Object[] {num_j,apellido,uno,dos,tres,cuatro} );
	}
}
