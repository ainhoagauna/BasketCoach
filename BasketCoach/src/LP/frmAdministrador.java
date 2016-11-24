/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ventanaMenu.java
 *
 * Created on 31-may-2015, 9:50:45
 */
package LP;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.edisoncor.gui.util.Avatar;


/**
 *
 * @author jokin.zulaika
 */
public class frmAdministrador extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** Creates new form ventanaMenu */
    public frmAdministrador() {
        initComponents();
        llenarMenu();
    }
    
    public void llenarMenu(){
        List<Avatar> avatars=new ArrayList<Avatar>();
        avatars.add(new Avatar("Gesti�n de Equipo", loadImage("/Image/gestion.png")));
        avatars.add(new Avatar("Asistencia", loadImage("/Image/assist.png")));
        avatars.add(new Avatar("Quintetos", loadImage("/Image/5.png")));
        avatars.add(new Avatar("Gesti�n de Minutos", loadImage("/Image/minutos.png")));
        avatars.add(new Avatar("Recordatorios", loadImage("/Image/recordatorio.png")));
        menu.setAvatars(avatars);
    }
    
    public static Image loadImage(String fileName){
        try {
            return ImageIO.read(frmAdministrador.class.getResource(fileName));
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public void llamarMenu(){
        if(menu.getSelectedtitulo().equals("Gesti�n de Equipo")){
        	frmGestionEquipo frame=new frmGestionEquipo();
        	frame.setVisible(true);
        	
        	frame.toFront();
        }
        if(menu.getSelectedtitulo().equals("Asistencia")){
        	frmAsistencia frame=new frmAsistencia();
        	frame.setVisible(true);

        	frame.toFront();
        }
        if(menu.getSelectedtitulo().equals("Quintetos")){
        	frmQuintetos frame=new frmQuintetos();
        	frame.setVisible(true);
        	
        	frame.toFront();
        }
        if(menu.getSelectedtitulo().equals("Gesti�n de Minutos")){
        	frmMinutos frame=new frmMinutos();
        	frame.setVisible(true);
        	
        	frame.toFront();
        }
        if(menu.getSelectedtitulo().equals("Recordatorios")){
        	frmRecordatorios frame=new frmRecordatorios();
        	frame.setVisible(true);
        	
        	frame.toFront();
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
//    	// adjust to need.
//        Dimension d = new Dimension(00,40);
////        this.setPreferredSize(d);
//        this.pack();
//        this.setResizable(false);
//        this.setVisible(true);
    	
    	setTitle("BasketCoach - Administrador");	

		setBounds(750, 200, 600, 600);

        menu = new org.edisoncor.gui.panel.PanelAvatarChooser();
        buttonIpod1 = new org.edisoncor.gui.button.ButtonIpod();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        
  
		addWindowListener(new WindowAdapter() 
		{
		    @Override
		    public void windowClosing(WindowEvent we)
		    { 
		        String ObjButtons[] = {"Si","Cancelar"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"�Seguro que deseas salir?","BasketCoach - Aviso",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
		    }
		});

        menu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                menuKeyPressed(evt);
            }
        });

        buttonIpod1.setText(".");
        buttonIpod1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIpod1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap(364, Short.MAX_VALUE)
                .addComponent(buttonIpod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(365, Short.MAX_VALUE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap(237, Short.MAX_VALUE)
                .addComponent(buttonIpod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void buttonIpod1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIpod1ActionPerformed
    llamarMenu();
}//GEN-LAST:event_buttonIpod1ActionPerformed

private void menuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_menuKeyPressed
    if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        llamarMenu();
    }
}//GEN-LAST:event_menuKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmAdministrador().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonIpod buttonIpod1;
    private org.edisoncor.gui.panel.PanelAvatarChooser menu;
    // End of variables declaration//GEN-END:variables
}
