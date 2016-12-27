package LP;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class frmAsistencia extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnSalir;
	private static MyTableModel datos;
	private boolean DEBUG = false;
	
	public frmAsistencia()
	{
//		this.pack();
		this.setVisible(true);
		setResizable(false);
		
	
		
		createAndShowGUI();
		this.setLocationRelativeTo(null); //Para que la ventana salga en el centro de la pantalla
	}

	public void createAndShowGUI()
	{
		getContentPane().setLayout(null);		
		
		JButton btnSalir=new JButton("Salir");
		btnSalir.setBounds(1019,664,100,30);
		btnSalir.addActionListener(this);
		
		JTable table = new JTable(new MyTableModel());
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		 
		//Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);
		 	     
		//Add the scroll pane to this panel.
		getContentPane().add(scrollPane);
		
		btnSalir.setActionCommand("Salir");
		getContentPane().add(btnSalir);
		
		JLabel lblSelecEquipo = new JLabel("Selecciona equipo:");
		lblSelecEquipo.setBounds(38, 37, 100, 14);
		getContentPane().add(lblSelecEquipo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 62, 1139, 2);
		getContentPane().add(separator);
		
		JComboBox cbSelecEquipo = new JComboBox();
		cbSelecEquipo.setBounds(137, 34, 120, 20);
		getContentPane().add(cbSelecEquipo);
		
		setTitle("Asistencia");	
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);	
		setBounds(500, 200, 1145, 744);
		
		//final frmAsistencia tabla=new frmAsistencia (datos);
		
		
	}
	
	 class MyTableModel extends AbstractTableModel {
	        private String[] columnNames = {"Nº",
	                                        "Nombre",
	                                        "Apellido",
	                                        "Voluntario",
	                                        "Asistencia",
	                                        "Méritos",
	                                        "Desconvocad@"};
	        private Object[][] data = {
		    {"Kathy", "Smith",
		     "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe",
		     "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black",
		     "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White",
		     "Speed reading", new Integer(20), new Boolean(true)},
		    {"Joe", "Brown",
		     "Pool", new Integer(10), new Boolean(false)}
	        };

	        public int getColumnCount() {
	            return columnNames.length;
	        }

	        public int getRowCount() {
	            return data.length;
	        }

	        public String getColumnName(int col) {
	            return columnNames[col];
	        }

	        public Object getValueAt(int row, int col) {
	            return data[row][col];
	        }

	        /*
	         * JTable uses this method to determine the default renderer/
	         * editor for each cell.  If we didn't implement this method,
	         * then the last column would contain text ("true"/"false"),
	         * rather than a check box.
	         */
	        public Class getColumnClass(int c) {
	            return getValueAt(0, c).getClass();
	        }

	        /*
	         * Don't need to implement this method unless your table's
	         * editable.
	         */
	        public boolean isCellEditable(int row, int col) {
	            //Note that the data/cell address is constant,
	            //no matter where the cell appears onscreen.
	            if (col < 2) {
	                return false;
	            } else {
	                return true;
	            }
	        }

	        /*
	         * Don't need to implement this method unless your table's
	         * data can change.
	         */
	        public void setValueAt(Object value, int row, int col) {
	            if (DEBUG) {
	                System.out.println("Setting value at " + row + "," + col
	                                   + " to " + value
	                                   + " (an instance of "
	                                   + value.getClass() + ")");
	            }

	            data[row][col] = value;
	            fireTableCellUpdated(row, col);

	            if (DEBUG) {
	                System.out.println("New value of data:");
	                printDebugData();
	            }
	        }

	        private void printDebugData() {
	            int numRows = getRowCount();
	            int numCols = getColumnCount();

	            for (int i=0; i < numRows; i++) {
	                System.out.print("    row " + i + ":");
	                for (int j=0; j < numCols; j++) {
	                    System.out.print("  " + data[i][j]);
	                }
	                System.out.println();
	            }
	            System.out.println("--------------------------");
	        }
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
