package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import LD.sqliteConnection;

public class eliminarEquipo implements ActionListener {


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		{
        	String ObjButtons[] = {"Si","Cancelar"};
	        int PromptResult = JOptionPane.showOptionDialog(null,"¿Quieres eliminar este equipo","BasketCoach - Aviso",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
	        if(PromptResult==JOptionPane.YES_OPTION)
	        {
	        	Connection conn=sqliteConnection.dbConnector();
	      		Statement stmt;
	      		try {
	      			stmt = conn.createStatement();

	     			
	     			String query = "delete * from equipo where nombre_e=";
	    			PreparedStatement pst = conn.prepareStatement(query);
	    			
	    			
	    			pst.close();		
	    				
	      			
	      		} catch (SQLException e) {
	      			// TODO Auto-generated catch block
	      			e.printStackTrace();
	      		}
	     		
	     		finally {
	     			  if (conn != null) {
	    			    try {
	     			      conn.close(); // <-- This is important
	     			    } catch (SQLException e) {
	     			      /* handle exception */
	     			    }
	     			  }
	     			}
	      		}
	        
	       
		}
	  
	
	}                 
        
    
	
}

	
	
	
	

