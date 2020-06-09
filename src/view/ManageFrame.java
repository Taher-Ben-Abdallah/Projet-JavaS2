package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.DB;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JToggleButton;

public class ManageFrame extends JPanel{
	
	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel searchLabel;
	private JScrollPane ResultsTab;
	private JTable table;
	private JComboBox tablesCombo;
	private JLabel tablesLabel;
	private JButton consultBtn;
	private JButton deleteBtn;
	private JComboBox triCombo;
	private JButton btnNewButton_2;
	private JScrollPane ClassTab;
	private JPanel panel_1;
	private JLabel triLabel;
	private JLabel libelleLabel;
	private JTextField libelleField;
	private JLabel nivLabel;
	private JTextField nivField;
	private JTextField filiereField;
	private JLabel filiereLabel;
	private JTextField idClassField;
	private JLabel idClassLabel;
	private JButton deleteClassBtn;
	private JButton editInfoBtn;
	private JButton consultListBtn;
	private JButton saveChangeBtn;
	private JScrollPane UserPane;
	private JPanel panel_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton_4;
	private JLabel lblNewLabel_8;
	private JTextField textField_7;
	
	
	public ManageFrame(DB db,String what) {
		
		frame= new AppFrame("Gerer "+what,700,560,true);
		frame.setSize(700,570);
		frame.getContentPane().setLayout(new BorderLayout());
		
		JPanel tabsPanel = new JPanel();
		frame.getContentPane().add(tabsPanel, BorderLayout.CENTER);
		tabsPanel.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabsPanel.add(tabbedPane);
		
		ResultsTab = new JScrollPane();
		tabbedPane.addTab("Resultats Recherche", null, ResultsTab, null);
		
		table = new JTable();
		ResultsTab.setViewportView(table);
		
		ClassTab = new JScrollPane();
		tabbedPane.addTab("Class name here", null, ClassTab, null);
		
		panel_1 = new JPanel();
		ClassTab.setViewportView(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow][9.00][122.00][25.00][63.00][102.00][154.00][28.00][11.00][14.00][9.00,grow]", "[33.00,grow][3.00][35.00][10.00][35.00][12.00][34.00][12.00][31.00][8.00][30.00][42.00,grow]"));
		
		consultListBtn = new JButton("Voir la liste des eleves");
		panel_1.add(consultListBtn, "cell 2 2,grow");
		
		idClassLabel = new JLabel("ID de classe :");
		panel_1.add(idClassLabel, "cell 5 2");
		
		idClassField = new JTextField();
		panel_1.add(idClassField, "cell 6 2,growx");
		idClassField.setColumns(10);
		
		deleteClassBtn = new JButton("Supprimer Classe");
		panel_1.add(deleteClassBtn, "cell 2 4,grow");
		
		libelleLabel = new JLabel("Libelle :");
		panel_1.add(libelleLabel, "cell 5 4");
		
		libelleField = new JTextField();
		panel_1.add(libelleField, "cell 6 4,growx");
		libelleField.setColumns(10);
		
		editInfoBtn = new JButton("Modifier Informations");
		panel_1.add(editInfoBtn, "cell 2 6,grow");
		
		nivLabel = new JLabel("Niveau :");
		panel_1.add(nivLabel, "cell 5 6");
		
		nivField = new JTextField();
		panel_1.add(nivField, "cell 6 6,growx");
		nivField.setColumns(10);
		
		filiereLabel = new JLabel("Filiere :");
		panel_1.add(filiereLabel, "cell 5 8");
		
		filiereField = new JTextField();
		panel_1.add(filiereField, "cell 6 8,growx");
		filiereField.setColumns(10);
		
		saveChangeBtn = new JButton("Sauvegarder les modifications");
		panel_1.add(saveChangeBtn, "cell 6 10,grow");
		
		UserPane = new JScrollPane();
		tabbedPane.addTab("Type: person name", null, UserPane, null);
		
		panel_2 = new JPanel();
		UserPane.setViewportView(panel_2);
		panel_2.setLayout(new MigLayout("", "[grow][83.00][134.00][18.00][156.00,grow][78.00][grow]", "[44.00,grow][32.00,grow][20.00][][4.00][][4.00][][4.00][][4.00][][4.00][][4.00][][grow]"));
		
		btnNewButton_1 = new JButton("Supprimer Utilisateur");
		panel_2.add(btnNewButton_1, "cell 2 1,growx");
		
		btnNewButton_3 = new JButton("Modifier Utilisateur");
		panel_2.add(btnNewButton_3, "cell 4 1,growx");
		
		lblNewLabel_2 = new JLabel("ID :");
		panel_2.add(lblNewLabel_2, "cell 2 3");
		
		textField_1 = new JTextField();
		panel_2.add(textField_1, "cell 4 3,grow");
		textField_1.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Nom :");
		panel_2.add(lblNewLabel_3, "cell 2 5");
		
		textField_2 = new JTextField();
		panel_2.add(textField_2, "cell 4 5,grow");
		textField_2.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Prenom :");
		panel_2.add(lblNewLabel_4, "cell 2 7");
		
		textField_3 = new JTextField();
		panel_2.add(textField_3, "cell 4 7,grow");
		textField_3.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Login :");
		panel_2.add(lblNewLabel_5, "cell 2 9");
		
		textField_4 = new JTextField();
		panel_2.add(textField_4, "cell 4 9,grow");
		textField_4.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Mot de passe :");
		panel_2.add(lblNewLabel_6, "cell 2 11");
		
		textField_5 = new JTextField();
		panel_2.add(textField_5, "cell 4 11,grow");
		textField_5.setColumns(10);
		
		lblNewLabel_7 = new JLabel("E-mail :");
		panel_2.add(lblNewLabel_7, "cell 2 13");
		
		textField_6 = new JTextField();
		panel_2.add(textField_6, "cell 4 13,grow");
		textField_6.setColumns(10);
		
		lblNewLabel_8 = new JLabel("ID de Classe :");
		panel_2.add(lblNewLabel_8, "cell 2 15");
		
		textField_7 = new JTextField();
		panel_2.add(textField_7, "cell 4 15,growx");
		textField_7.setColumns(10);
		
		btnNewButton_4 = new JButton("Sauvegarder les modifications");
		panel_2.add(btnNewButton_4, "cell 4 16");
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Gestion ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabsPanel.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[69.00][266.00,grow][87.00][78.00,grow][61.00][grow]", "[30.00][]"));
		
		searchLabel = new JLabel("Tapez un nom :");
		panel.add(searchLabel, "cell 0 0");
		
		textField = new JTextField();
		panel.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		tablesLabel = new JLabel("Vous cherchez :");
		panel.add(tablesLabel, "cell 2 0,alignx right");
		
		tablesCombo = new JComboBox();
		tablesCombo.setModel(new DefaultComboBoxModel(new String[] {"Etudiant", "Classe", "Enseignant", "Responsable", "Matiere"}));
		panel.add(tablesCombo, "cell 3 0,growx");
		
		btnNewButton = new JButton("Rechercher");
		panel.add(btnNewButton, "cell 4 0,growx,aligny center");
		
		consultBtn = new JButton("Consulter");
		panel.add(consultBtn, "flowx,cell 1 1");
		
		deleteBtn = new JButton("Supprimer");
		panel.add(deleteBtn, "cell 1 1");
		
		triLabel = new JLabel("Trier resultats :");
		panel.add(triLabel, "cell 2 1,alignx trailing");
		
		triCombo = new JComboBox();
		triCombo.setModel(new DefaultComboBoxModel(new String[] {"Aucun", "De A a Z", "De Z a A"}));
		panel.add(triCombo, "cell 3 1,growx");
		
		btnNewButton_2 = new JButton("Trier");
		panel.add(btnNewButton_2, "cell 4 1,growx");
		
	}

}
