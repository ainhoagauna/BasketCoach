package LP;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import LD.BD;

public class frmMinutos extends JFrame implements ActionListener{

private JTable table=null;
	
private boolean DEBUG = true;
private BD db = new BD();
private Object[][] dtPersona;

String minutos=null;
String partidos=null;
String fecha=null;
String num=null;
String apellido=null;

private DefaultTableModel modelo=null;


public frmMinutos()
{
	
	getContentPane().setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(null, "Tabla minutos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panel.setBounds(10, 11, 620, 239);
	getContentPane().add(panel);
	panel.setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(6, 16, 608, 212);
	panel.add(scrollPane);
	
	table = new JTable(){
		public void setValueAt(Object value, int row, int col) {
	        if (DEBUG) {
	        	
	        	
	        	
	        	num=table.getValueAt(row, 0).toString();
			    apellido=table.getValueAt(row, 1).toString();
			    minutos=table.getValueAt(row, 2).toString();
			    partidos= table.getValueAt(row, 3).toString();
			   	fecha=table.getValueAt(row, 4).toString();
			   
	           
	            String modificado=(String)value;
	            
	            BD base=new BD();
	            base.modificarMinutos(modificado, num, apellido, minutos, partidos, fecha,  table, row, col);
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

	setTitle("Minutos");	
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
	int minutos=0;
	int partidos=0;
	Date fecha=null;
	int num=0;
	String apellido=null;
	
	
	String[] columnas = {"NUMERO","APELLIDO","MINUTOS"," PARTIDOS","FECHA"};
	
	modelo = new DefaultTableModel(null,columnas);		
	table.setModel(modelo);
	
	BD base=new BD();
	base.cargarMinutos(num,apellido,minutos,partidos,fecha,modelo);
	
	modelo.addRow( new Object[] {num,apellido,minutos,partidos,fecha} );
}


	
	
}
