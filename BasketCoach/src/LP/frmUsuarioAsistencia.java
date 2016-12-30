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

public class frmUsuarioAsistencia extends JFrame implements ActionListener{

private JButton btnSalir;
private JTable tabla = null;
DefaultTableModel modelo = null;
JScrollPane desplazamiento = null;

	public frmUsuarioAsistencia()
	{
		this.pack();
		this.setVisible(true);
		setResizable(true);
	
		
		createAndShowGUI();
		this.setLocationRelativeTo(null); //Para que la ventana salga en el centro de la pantalla
		setBounds(500, 200, 136, 258);
	}

	public void createAndShowGUI()
	{
		getContentPane().setLayout(null);		
		
		JButton btnSalir=new JButton("Salir");
		btnSalir.setBounds(400,210,100,30);
		btnSalir.addActionListener(this);
		getContentPane().setLayout(null);
		btnSalir.setActionCommand("Salir");
		getContentPane().add(btnSalir);
		
		
		
		setTitle("Asistencias");	
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);	
		setBounds(500, 200, 136, 258);
		
		crearTabla();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		
		case "Salir":
			
			this.dispose();
			
		}
		
	}
		
	public void crearTabla()
	{
		  // Nombre de las columnas como apareceran en la tabla
        String[] columnas = {"NÚMERO JUGADOR", "APELLIDO", "BONUS","ASISTENCIA", "MERITOS", "DESCONVOCADO"};
        tabla = new JTable();
        tabla.setColumnSelectionAllowed(true);
        tabla.setCellSelectionEnabled(true);
        modelo = new DefaultTableModel();
        desplazamiento = new JScrollPane(tabla);
        desplazamiento.setBounds(0, 0, 452, 402);
        int numero=0;
        int bonus=0;
        int asistencia=0;
        int meritos=0;
        int desconvocado=0;
        
        String apellido=null;
       
        
        // Parametros de la ventana
        this.setTitle("Tabla quintetos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
        this.getContentPane().add(desplazamiento);    
        this.pack();
        
        // Ponemos los datos en la tabla
        
        BD base=new BD();
        base.cargarAsistencia(numero,apellido,bonus, asistencia, meritos,desconvocado,modelo);
        
        
        modelo.addRow( new Object[] {numero,apellido,bonus, asistencia, meritos,desconvocado} );
	}
		
	
	
	
}
