package LP;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

import javax.swing.JOptionPane;

import LD.BD;

public class quinteto extends javax.swing.JFrame {
DefaultTableModel model;
Connection Conn;
Statement sent;
private javax.swing.JButton btnCerrar;
private javax.swing.JButton btnEliminar;
private javax.swing.JButton btnGuardar;
private javax.swing.JButton btnModificar;
private javax.swing.JButton btnNuevo;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JLabel jLabel3;
private javax.swing.JLabel jLabel4;
private javax.swing.JPanel jPanel1;
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JTable jTable1;
private javax.swing.JTextField txtCorreo;
private javax.swing.JTextField txtDireccion;
private javax.swing.JTextField txtNombre;
private javax.swing.JTextField txtTelefono;
// End of variables declaration                

public quinteto() {
//        initComponents();
       Conn=BD.dbConnector();
        Deshabilitar();
        Llenar();
    }
void Deshabilitar(){
    txtNombre.setEditable(false);

    txtDireccion.setEditable(false);
    txtCorreo.setEditable(false);
    txtTelefono.setEditable(false);
}
void Limpiar(){
    txtNombre.setText("");
    txtDireccion.setText("");
    txtCorreo.setText("");
    txtTelefono.setText("");
}
void Habilitar(){
    txtNombre.setEditable(true);
    txtCorreo.setEditable(true);
    txtDireccion.setEditable(true);
    txtTelefono.setEditable(true);
    txtNombre.requestFocus();
}
void Llenar(){
    try{
        //Conn=DriveMan.getConnection();
        sent=Conn.createStatement();
        String [] titulos ={"NUMERO","APELLIDO"};
        String sql="select * from QUINTETO";
        model=new DefaultTableModel(null, titulos);
        sent=Conn.createStatement();
        ResultSet rs=sent.executeQuery(sql);

        String fila []= new String [5];

        while(rs.next()){
            fila [0]=rs.getString("num_j");
            fila [1]=rs.getString("apellido_j");
//            fila [2]=rs.getString("direccion");
//            fila [3]=rs.getString("telefono");
//            fila [4]=rs.getString("correo");

            model.addRow(fila);

        }
jTable1.setModel(model);
       
    }catch(Exception e){
e.printStackTrace();
    }
}

private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                           
try{
    int fila=jTable1.getSelectedRow();
    String sql="delete from quinteto where num_j="+jTable1.getValueAt(fila,0);
    sent=Conn.createStatement();
    int n=sent.executeUpdate(sql);
    if(n>0){
        Llenar();
        JOptionPane.showMessageDialog(null, "datos eliminados");
        Limpiar();
    }
}catch(Exception e){
    JOptionPane.showMessageDialog(null, "error"+e.getMessage());
}
  }

  private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                          
try{
    String sql="insert into quinteto ( direccion ,nombre, telefono, correo)" +
           "Values (?,?,?,?) ";
PreparedStatement ps=Conn.prepareCall(sql);
ps.setString(1, txtNombre.getText());
ps.setString(2, txtDireccion.getText());
ps.setString(3, txtTelefono.getText());
ps.setString(4, txtCorreo.getText());


int n=ps.executeUpdate();
if(n>0)
JOptionPane.showMessageDialog(null, "datos guardados");
}catch(Exception e){
    JOptionPane.showMessageDialog(null, "error"+ e.getMessage());
}
Llenar();
Limpiar();
    }                                          

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {                                        
Limpiar();
Habilitar();
        // TODO add your handling code here:
    }
  private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                    
 if(evt.getButton()==1){
   try{
       Habilitar();
        int fila=jTable1.getSelectedRow();
        String sql="select * from quinteto where num_j="+jTable1.getValueAt(fila,0);
        sent=Conn.createStatement();
        ResultSet rs=sent.executeQuery(sql);
        rs.next();
        txtNombre.setText(rs.getString("num_j"));
        txtDireccion.setText(rs.getString("apellido_j"));
//        txtTelefono.setText(rs.getString("telefono"));
//        txtCorreo.setText(rs.getString("correo"));

}catch(Exception e){
    e.printStackTrace();
}
    }
    }        

private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {                                            
try{
    String sql="Update contactos set nombre=?, direccion=?, telefono=?, correo=?"+
            "where id=?";
    int fila=jTable1.getSelectedRow();
    String dao=(String)jTable1.getValueAt(fila,0);
    PreparedStatement ps=Conn.prepareCall(sql);
    ps.setString(1,txtNombre.getText());
    ps.setString(2,txtDireccion.getText());
    ps.setString(3,txtTelefono.getText());
    ps.setString(4,txtCorreo.getText());//valor de campos de texto a pasar a
    //BasedeDatos

   ps.setString(5,dao);//la llamada sql se muestra en la tabla

    int n=ps.executeUpdate();
    if(n>0){
        Limpiar();
        Llenar();
        JOptionPane.showMessageDialog(null, "datos modificados");
       
    }
}catch (Exception e){
    JOptionPane.showMessageDialog(null, "error"+ e.getMessage());
}
        // TODO add your handling code here:
    }             

private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {                                         
System.exit(0);
        // TODO add your handling code here:
    }
}
