package LP;

import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import LD.BD;

public class frmQuintetos extends JFrame implements ActionListener{
    /**
     * 
     */
    private static final long serialVersionUID = 210601883990408438L;
   
    private JTable tabla = null;
    DefaultTableModel modelo = null;
    JScrollPane desplazamiento = null;
    private JButton salir;
    private BD base=new BD();
    private DefaultTableModel dtQuinteto;
    private DefaultTableModel datos ;
    int numero=0;
    String apellido=null;
    String uno=null;
    String dos=null;
    String tres=null;
    String cuatro=null;
 
  
    public frmQuintetos() {
    	
    	
        // Nombre de las columnas como apareceran en la tabla
        String[] columnas = {"NÚMERO JUGADOR", "APELLIDO", "PRIMER CUARTO","SEGUNDO CUARTO", "TERCER CUARTO", "CUARTO CUARTO"};
        tabla = new JTable();
        modelo = new DefaultTableModel();
        desplazamiento = new JScrollPane(tabla);
        
        
        
        // Parametros de la ventana
        this.setTitle("Tabla quintetos");
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
        
        BD base=new BD();
        base.cargarQuintetos(numero,apellido,uno,dos,tres,cuatro,modelo);
        
        
        modelo.addRow( new Object[] {numero,apellido,uno,dos,tres,cuatro} );
        
        JButton btnSalir = new JButton("ATRAS");
		btnSalir.setBounds(72, 40, 89, 23);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("ATRAS");
		getContentPane().add(btnSalir);
		
		
		//para editar celdas y guardarlas
		 Actualizar_Tabla();
	        //oculta columna ID
	        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
	        tabla.getColumnModel().getColumn(0).setMinWidth(0);
	        tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
	        tabla.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
	        //editor de caldas
	        tabla.getColumnModel().getColumn( 1 ).setCellEditor(new MyTableCellEditor(base,"num_j"));
	        tabla.getColumnModel().getColumn( 2 ).setCellEditor(new MyTableCellEditor(base,"apellido_j"));
	        tabla.getColumnModel().getColumn( 3 ).setCellEditor(new MyTableCellEditor(base,"num_cuarto_q"));
	        tabla.getColumnModel().getColumn( 4 ).setCellEditor(new MyTableCellEditor(base,"primero_cuarto"));
	        tabla.getColumnModel().getColumn( 5 ).setCellEditor(new MyTableCellEditor(base,"segundo_cuarto"));
	        tabla.getColumnModel().getColumn( 6 ).setCellEditor(new MyTableCellEditor(base,"tercer_cuarto"));
	        tabla.getColumnModel().getColumn( 7 ).setCellEditor(new MyTableCellEditor(base,"cuarto_cuarto"));
		
	        datos.addRow(new Object [] {numero,apellido,uno,dos,tres,cuatro});
    }

    
   	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		case "ATRAS":
				
			this.dispose();

			frmAdministrador admin = new frmAdministrador();
			admin.setVisible(true);
			admin.toFront();
			
			break;
			
	}
}
	private void Actualizar_Tabla(){
        //actualiza los datos de la tabla realizando una consulta a la base de datos
        String[] columNames = {"NÚMERO JUGADOR", "APELLIDO", "PRIMER CUARTO","SEGUNDO CUARTO", "TERCER CUARTO", "CUARTO CUARTO"};
        dtQuinteto = base.cargarQuintetos(numero, apellido, uno, dos, tres, cuatro, modelo);
        // se colocan los datos en la tabla
   //     DefaultTableModel datos = new DefaultTableModel(dtQuinteto,columNames);
        datos = new DefaultTableModel();
        
        datos.addRow( new Object[] {dtQuinteto,columNames} );
        tabla.setModel(datos);
}
	
}





