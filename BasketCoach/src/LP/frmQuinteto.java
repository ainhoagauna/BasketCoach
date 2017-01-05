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
	
	private BD db = new BD();
    private Object[][] dtPersona;
	

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
		
		BD base=new BD();
		table=new JTable(){
			public void setValueAt(Object value, int row, int col) {
		        if (DEBUG) {
		        	
		        	
		        	num=table.getValueAt(row, 0).toString();
				    ape=table.getValueAt(row, 1).toString();
				    uno=table.getValueAt(row, 2).toString();
				    dos= table.getValueAt(row, 3).toString();
				   	tres=table.getValueAt(row, 4).toString();
				    cuatro=table.getValueAt(row, 5).toString();			    
				    
		            System.out.println("Poniendo valor en (" + row + "," + col
		                               + ") = " + value + " (instancia de "
		                               + value.getClass() + ")");
		            
		           
		            String modificado=(String)value;
		            base.modificarQuinteto(modificado, num, ape, uno, dos, tres, cuatro, table, row, col);
		            llenar();
		        }
//		        table.get(row).setValor( value, col );
//		        fireTableCellUpdated(row, col);  // Notifica a escuchadores de cambio de celda
		    }
		};
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
		
		//Actualizar_Tabla();
//		table.getColumnModel().getColumn( 1 ).setCellEditor(new MyTableCellEditor(db,"num_j"));//Columna Nombre
//        table.getColumnModel().getColumn( 2 ).setCellEditor(new MyTableCellEditor(db,"apellido_j"));//Columna Apellido
//        table.getColumnModel().getColumn( 3 ).setCellEditor(new MyTableCellEditor(db,"primer_cuarto"));//Columna Edad
//        table.getColumnModel().getColumn( 4 ).setCellEditor(new MyTableCellEditor(db,"segundo_cuarto"));//Columna Edad
//        table.getColumnModel().getColumn( 5 ).setCellEditor(new MyTableCellEditor(db,"tercer_cuarto"));//Columna Edad
//        table.getColumnModel().getColumn( 6 ).setCellEditor(new MyTableCellEditor(db,"cuarto_cuarto"));//Columna Edad
    
	}
	
	private void Actualizar_Tabla(){
        //actualiza los datos de la tabla realizando una consulta a la base de datos
		String[] columnas = {"NUMERO","APELLIDO","PRIMER CUARTO"," SEGUNDO CUARTO","TERCER CUARTO", "CUARTO CUARTO"};
        dtPersona = db.Select_Persona();
        // se colocan los datos en la tabla
        DefaultTableModel datos = new DefaultTableModel(dtPersona,columnas);
        table.setModel(datos);
        
	}
}
