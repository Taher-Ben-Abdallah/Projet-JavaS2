package view;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import controller.Messages;



public class AppFrame extends JFrame{	
	
	private ImageIcon icon;
	
	
	
	
	/**
	 * @wbp.parser.constructor
	 */
	public AppFrame(String title,int width,int height, boolean resize)
	{	
		super(title);
		
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(resize);//make the window unresizeable
		//if(resize) {setJMenuBar(createMenuBar());}
		this.setVisible(true);
		
	}
	
	
	
	
	
	public JMenuBar createMenuBar(AppFrame frame) {
		// Creating the Bar
		JMenuBar menuBar= new JMenuBar(); 				
		//Creating the file menu
		JMenu controlMenu= new JMenu("Control");
		JMenu windowMenu= new JMenu("Window");
		JMenu helpMenu = new JMenu("Help");
		
		//Creating menu Items
		/*file*/
		JMenuItem printItem= new JMenuItem("Imprimer");
		JMenuItem disconnectItem= new JMenuItem("Deconnecter");
		JMenuItem exitItem= new JMenuItem("Exit");
		
		/*window*/
		JMenu prefsItem= new JMenu("Preferences...") ;
		JMenuItem theme1= new JMenuItem("Theme Standard");
		JMenuItem theme2= new JMenuItem("Theme Dark");
		JMenuItem theme3= new JMenuItem("Plain theme");
		
		prefsItem.add(theme1);
		prefsItem.add(theme2);
		prefsItem.add(theme3);
				
		
		/*Help*/
		JMenu functionsMenu = new JMenu("Fonctionnalites du programme");
		JMenuItem  i1= new JMenuItem("Comment Effectuer Des Recherches Eleves/Classes/Matieres...");
		JMenuItem  i2= new JMenuItem("Envoi des Mails au Eleves");
		JMenuItem  i3= new JMenuItem("Comment Obtenir des Graphes et Statistiques");
		JMenuItem aboutItem =new JMenuItem("A propos l\'application");
		
		functionsMenu.add(i1);
		functionsMenu.add(i2);
		functionsMenu.add(i3);
		
		
		// Adding menus to the Bar
		menuBar.add(controlMenu); 
		menuBar.add(windowMenu);
		menuBar.add(helpMenu);
		//Adding Items to the menu
		/*File*/
		controlMenu.add(printItem);
		controlMenu.addSeparator();
		controlMenu.add(disconnectItem);
		controlMenu.add(exitItem);
		/*Window*/
		windowMenu.add(prefsItem);
		
		/*Help*/
		helpMenu.add(functionsMenu);
		helpMenu.add(aboutItem);
		
		
		/*prefsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prefsDialog.setVisible(true);
			}
			
		});
		//enable-disable something
		showFormItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JCheckBoxMenuItem menuItem=(JCheckBoxMenuItem)ev.getSource();
				formPanel.setVisible(menuItem.isSelected());
				
			}});
			
		*/
		
		//Setting Mnemonics (shortcuts)	
		controlMenu.setMnemonic(KeyEvent.VK_C);
		windowMenu.setMnemonic(KeyEvent.VK_W);
		helpMenu.setMnemonic(KeyEvent.VK_H);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		printItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		disconnectItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		
		
		
		///Confirming exit
		disconnectItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action= Messages.showConfirm(2,disconnectItem.getName());
				if(action== JOptionPane.OK_OPTION) 
				{frame.dispose();
				new LoginFrame();}
			}
		});
		///Confirming Disconnect
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action= Messages.showConfirm(1,exitItem.getName());
				if(action== JOptionPane.OK_OPTION) 
				{System.exit(0);
				}
			}
		});
		
		//help menu
		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Messages.showMessage(4,aboutItem.getName());
			}});
		
		i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Messages.showMessage(1, i1.getName());
			}});
		i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Messages.showMessage(2, i2.getName());
			}});
		i3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Messages.showMessage(3, i3.getName());
			}});
		
		
		
		
		//Theme setting
		theme1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App.setTheme(1);
				SwingUtilities.updateComponentTreeUI(frame);
			}});
		theme2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App.setTheme(2);
				SwingUtilities.updateComponentTreeUI(frame);
			}});
		theme3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App.setTheme(3);
				SwingUtilities.updateComponentTreeUI(frame);
			}});
		
		//Inputting information:
		//String text=JOptionPane.showInputDialog(MainFrame.this,"Enter the Username","Username Input",JOptionPane.OK_OPTION|JOptionPane.QUESTION_MESSAGE);
		
		
		
		return menuBar;
	}
	
}


/*importDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));

importDataItem.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		if(fileChooser.showOpenDialog(MainFrame.this)== JFileChooser.APPROVE_OPTION) 
		{
			try {
				controller.loadFromFile(fileChooser.getSelectedFile());
				tablePanel.refresh();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(MainFrame.this,"Could not load data from File", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
});*/

/*exportDataItem.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		if(fileChooser.showSaveDialog(MainFrame.this)== JFileChooser.APPROVE_OPTION) 
		{
			try {
				controller.saveToFile(fileChooser.getSelectedFile());
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(MainFrame.this,"Could not save data to File", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
});*/
