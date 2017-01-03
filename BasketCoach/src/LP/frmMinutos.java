package LP;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import LD.BD;

public class frmMinutos extends JFrame implements ActionListener{

	DefaultTableModel modelo;
	private JButton btnSalir;
	private JTable tabla;
	JScrollPane desplazamiento;
	
	private DefaultTableModel dtMinutos;
	private DefaultTableModel datos ;
	private BD base=new BD();
	
	int minutos;
	int numPartido;
	String fecha;
	int numJugador;
	String apellido;

	
	public frmMinutos()
	{
		// Nombre de las columnas como apareceran en la tabla
        String[] columnas = {"MINUTOS", "NUM PARTIDO", "FECHA PARTIDO","NUMERO JUGADOR", "APELLIDO JUGADOR"};
        tabla = new JTable();
        modelo = new DefaultTableModel();
        desplazamiento = new JScrollPane(tabla);
        int minutos=0;
        int numPartido=0;
        String fecha=null;
        String nombre=null;
        int numJugador=0;
              
        
        // Parametros de la ventana
        this.setTitle("Tabla minutos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout()); 
        
        // Modelo de la tabla
        modelo.setColumnIdentifiers(columnas);
        
        // Barras de desplazamiento
        desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        // Propiedades de la tabla
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setFillsViewportHeight(true);        
        
        tabla.setModel(modelo);
        
        // Agregando elementos a la ventana
        this.getContentPane().add(desplazamiento, BorderLayout.NORTH);    
        this.pack();
        
        // Ponemos los datos en la tabla
        
        
        
        base.cargarMinutos(minutos, numPartido,fecha, numJugador, nombre, modelo);
                
        modelo.addRow( new Object[] {minutos, numPartido, fecha, numJugador, nombre} );
        
		this.setLocationRelativeTo(null); //Para que la ventana salga en el centro de la pantalla
		
		
		JButton btnSalir = new JButton("ATRAS");
		btnSalir.setBounds(72, 40, 89, 23);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("ATRAS");
		getContentPane().add(btnSalir);
		
		//para editar celdas y guardarlas
//		 Actualizar_Tabla();
//	        //oculta columna ID
//	        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
//	        tabla.getColumnModel().getColumn(0).setMinWidth(0);
//	        tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
//	        tabla.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
//	        //editor de caldas
//	        tabla.getColumnModel().getColumn( 1 ).setCellEditor(new MyTableCellEditor(base,"num_j"));
//	        tabla.getColumnModel().getColumn( 2 ).setCellEditor(new MyTableCellEditor(base,"apellido_j"));
//	        tabla.getColumnModel().getColumn( 3 ).setCellEditor(new MyTableCellEditor(base,"num_cuarto_q"));
//	        tabla.getColumnModel().getColumn( 4 ).setCellEditor(new MyTableCellEditor(base,"primero_cuarto"));
//	        tabla.getColumnModel().getColumn( 5 ).setCellEditor(new MyTableCellEditor(base,"segundo_cuarto"));
//	        tabla.getColumnModel().getColumn( 6 ).setCellEditor(new MyTableCellEditor(base,"tercer_cuarto"));
//	        tabla.getColumnModel().getColumn( 7 ).setCellEditor(new MyTableCellEditor(base,"cuarto_cuarto"));
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		
		case "Salir":
			
			this.dispose();

			frmAdministrador admin = new frmAdministrador();
			admin.setVisible(true);
			admin.toFront();
			
			break;
		
		}
		
	}
	
	private void Actualizar_Tabla()
	{
        //actualiza los datos de la tabla realizando una consulta a la base de datos
		String[] columnas = {"MINUTOS", "NUM PARTIDO", "FECHA PARTIDO","NUMERO JUGADOR", "NOMBRE JUGADOR"};
        
		dtMinutos=base.cargarMinutos(minutos, numPartido, fecha, numJugador, apellido, modelo);
        // se colocan los datos en la tabla
   //     DefaultTableModel datos = new DefaultTableModel(dtQuinteto,columNames);
        datos = new DefaultTableModel();
        
        datos.addRow( new Object[] {dtMinutos,columnas} );
        tabla.setModel(datos);
	}
}
