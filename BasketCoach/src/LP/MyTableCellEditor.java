package LP;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

import LD.BD;

public class MyTableCellEditor extends AbstractCellEditor implements TableCellEditor{
	
	
	private BD db;
    private String OldValue=""; //Valor antiguo de la celda
    private String NewValue=""; //valor nuevo de la celda
    private String NameColum="";//nombre de la columna
    private String num_j="";// Llave del registro
    private JComponent component = new JTextField();

    public MyTableCellEditor (BD db, String NameColumn)
    {
            this.db = db;
            this.NameColum = NameColumn;
    }

    @Override
    public Object getCellEditorValue() {
        return ((JTextField)component).getText();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        OldValue = value.toString();//Toma valor de celda antes de cualquier modificaci�n
        num_j = table.getValueAt(row,0).toString();//obtiene el ID unico del registro
        ((JTextField)component).setText(value.toString());//coloca valor de la celda al JTextField
        return component;
    }

    @Override
    public boolean stopCellEditing() {
        NewValue = (String)getCellEditorValue();//Captura nuevo valor de la celda
        //Compara valores, si no son iguales, debe actualizar registro
        if( !NewValue.equals(OldValue))
        {   //Realiza la actualizacion
            if( !db.update( NameColum+"='"+NewValue+"' ", num_j ) )
            {   //Si existe algun error al actualizar, escribe viejo valor en la celda
                JOptionPane.showMessageDialog(null,"Error: No se puede actualizar");
                ((JTextField)component).setText(OldValue);
            }
        }
        return super.stopCellEditing();
    }

	

}