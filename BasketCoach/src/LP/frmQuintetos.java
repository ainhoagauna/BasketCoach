package LP;

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
    
 
  
    public frmQuintetos() {
    	
    	
        // Nombre de las columnas como apareceran en la tabla
        String[] columnas = {"NÚMERO JUGADOR", "NOMBRE", "PRIMER CUARTO","SEGUNDO CUARTO", "TERCER CUARTO", "CUARTO CUARTO"};
        tabla = new JTable();
        modelo = new DefaultTableModel();
        desplazamiento = new JScrollPane(tabla);
        int numero=0;
        String nombre=null;
        String uno=null;
        String dos=null;
        String tres=null;
        String cuatro=null;
        
        
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
        base.cargarQuintetos(numero,nombre,uno,dos,tres,cuatro,modelo);
        
        
        modelo.addRow( new Object[] {numero,nombre,uno,dos,tres,cuatro} );
        
        JButton btnSalir = new JButton("ATRAS");
		btnSalir.setBounds(72, 40, 89, 23);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("ATRAS");
		getContentPane().add(btnSalir);
		
		
		
		
       
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
}





