package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import LD.BD;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class frmQuinteto extends JFrame implements ActionListener{
		
	private JTable table=null;
	
	private DefaultTableModel modelo=null;


	public frmQuinteto()
	{
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tabla quinteto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 620, 239);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 608, 212);
		panel.add(scrollPane);
		
		table = new JTable();
		
		
		scrollPane.setViewportView(table);
		
		llenar();
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(281, 284, 89, 23);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("SALIR");
		getContentPane().add(btnSalir);

		setTitle("Quintetos");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(300, 100, 644, 408);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			
			
			switch(e.getActionCommand()){
				
			
			case "SALIR":
				
				this.dispose();

				frmAdministrador admin = new frmAdministrador();
				admin.setVisible(true);
				admin.toFront();
				break;
			
		}
	}
	
	void llenar()
	
	{
		int num=0;
		String apellido=null;
		String uno=null;
		String dos=null;
		String tres=null;
		String cuatro=null;
		
		String[] columnas = {"NUMERO","APELLIDO","PRIMER CUARTO"," SEGUNDO CUARTO","TERCER CUARTO", "CUARTO CUARTO"};
		
		modelo = new DefaultTableModel(null,columnas);		
		table.setModel(modelo);
		
		BD base=new BD();
		base.cargarQuintetos(num, apellido, uno, dos, tres, cuatro, modelo);
		
		modelo.addRow( new Object[] {num, apellido, uno, dos, tres, cuatro,} );
	}
}
