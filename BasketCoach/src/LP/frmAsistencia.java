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
		
		table = new JTable();
		
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
