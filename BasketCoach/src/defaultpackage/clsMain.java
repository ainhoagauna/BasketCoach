package defaultpackage;


import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import LP.frmAdministrador1;


import LP.frmPrincipal;
import LP.frmUsuario;

public class clsMain {

	public static void main(String[] args) {
		
		   
			try {
			    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			        if ("Nimbus".equals(info.getName())) {
			            UIManager.setLookAndFeel(info.getClassName());
			            break;
			        }
			    }
			} catch (Exception e) {
			    // If Nimbus is not available, you can set the GUI to another look and feel.
			}	
		// TODO Auto-generated method stub

		frmPrincipal objPrincipal=new frmPrincipal();
		objPrincipal.setVisible(true);
		
//		frmAdministrador admin=new frmAdministrador();
//		admin.setVisible(true);

	}

}
