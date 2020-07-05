package view;


import java.sql.SQLException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import controller.Messages;
import model.DB;






public class App{
	
	public static void main(String[] args) 
	{	
		
		
		setTheme(3);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LoginFrame();
				try {
					new DB();
				} catch (SQLException e) {
					Messages.showError(1);
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void  setTheme(int theme) 
	{
		switch (theme)
		{
		case 1 :
			try { 
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
		    } 
			catch (Exception e){e.printStackTrace();}
		    break;
	    case 2 :
	    	try { 
				UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf"); 
		    } catch(Exception e){e.printStackTrace();}
	    	break;
	    case 3 :
	    	try { 
				UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf"); 
		    } catch(Exception e){e.printStackTrace();}
	    	break;
	    }
	    
		}
	
}
