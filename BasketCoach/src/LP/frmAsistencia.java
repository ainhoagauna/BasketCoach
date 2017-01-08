package LP;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import LD.BD;

public class frmAsistencia extends JFrame implements ActionListener{
private JTable table=null;
private boolean DEBUG = true;
private BD db = new BD();
private Object[][] dtPersona;


String bonus=null;
String asistencia=null;
String meritos=null;
String desconv=null;
String num=null;
String apellido=null;

	
	private DefaultTableModel modelo=null;


	public frmAsistencia()
	{
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tabla asistencia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 620, 239);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 608, 212);
		panel.add(scrollPane);
		
		//Detecta si se ha modificado alguna celda y modifica, guarda y  actualiza el valor correspondiente tanto en la tabla como en la base de datos
		table = new JTable(){
			public void setValueAt(Object value, int row, int col) {
		        if (DEBUG) {
		        	
		        	
		        	
		        	num=table.getValueAt(row, 0).toString();
				    apellido=table.getValueAt(row, 1).toString();
				    bonus=table.getValueAt(row, 2).toString();
				    asistencia= table.getValueAt(row, 3).toString();
				   	meritos=table.getValueAt(row, 4).toString();
					desconv=table.getValueAt(row, 5).toString();
				   
		           
		            String modificado=(String)value;
		            
		            BD base=new BD();
		            base.modificarAsistencia(modificado, num, apellido, bonus, asistencia, meritos, desconv,  table, row, col);
		            llenar();
		        }
	        
		    			
			
	        
		    
		}
		
		public boolean isCellEditable(int rowIndex, int colIndex) {
			
			boolean retorno=true;
			if(colIndex==0 || colIndex==1)
			{
				retorno=false; //Las celdas no son editables.
			}
			
				return retorno;
			 
			}
			};
		
		scrollPane.setViewportView(table);
		
		llenar();
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(281, 284, 89, 23);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("SALIR");
		getContentPane().add(btnSalir);

		setTitle("Asistencia");	
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
	
	//Metodo que llama a la base de datos para cargar la tabla
	void llenar()
	
	{
		int bonus=0;
		int asistencia=0;
		int meritos=0;
		int desconv=0;
		int num=0;
		String apellido=null;
		
		String[] columnas = {"NUMERO","APELLIDO","BONUS"," ASISTENCIA","MERITOS", "DESCONVOCADO"};
		
		modelo = new DefaultTableModel(null,columnas);		
		table.setModel(modelo);
		
		BD base=new BD();
		base.cargarAsistencia(num,apellido,bonus,asistencia,meritos,desconv,modelo);
		
		modelo.addRow( new Object[] {num,apellido,bonus,asistencia,meritos,desconv} );
	}
}
