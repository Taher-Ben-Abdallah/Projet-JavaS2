package view;


import java.sql.SQLException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import model.DB;






public class App{
	
	public static void main(String[] args) 
	{	
		
		try { 
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"/*new SyntheticaPlainLookAndFeel()*/); 
	    } catch(Exception e){e.printStackTrace();}
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LoginFrame();
				try {
					new DB();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}
