package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import LD.BD;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class frmQuinteto extends JFrame implements ActionListener{
		
	private JTable table=null;	
	private DefaultTableModel modelo=null;
	
	private boolean DEBUG = true;
	String num=null;
	String ape=null;
	String uno=null;
	String dos=null;
	String tres=null;
	String cuatro=null;
	

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
		
		
		table=new JTable();
		scrollPane.setViewportView(table);
		
		
			
			   
		   
			   
			    
			    
			    
			    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			    	
			    	
			    @Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					
					System.out.println("ok");
					
					int fila=table.getSelectedRow();
					int columna=table.getSelectedColumn();
					
					
					 
					
					
					BD base=new BD();
					base.modificarQuinteto(table.getValueAt(fila, 0).toString(),table.getValueAt(fila, 1).toString(),table.getValueAt(fila, 2).toString(),table.getValueAt(fila, 3).toString(),table.getValueAt(fila, 4).toString(),table.getValueAt(fila, 5).toString(),table,fila,columna);
					llenar();
					JOptionPane.showMessageDialog(null, "¡Modificado!");
					
				}
			});
			
			   
				
			
				
		
		
		
		
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
