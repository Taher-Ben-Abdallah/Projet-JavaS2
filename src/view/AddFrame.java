package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import model.DB;

public class AddFrame extends JPanel{
	private AppFrame frame;
	private JButton addBtn;
	//addUser Components
	private JTextField nivField;
	private JTextField filiereField;
	private JTextField prenField;
	private JTextField nameField;
	private JTextField loginField;
	private JTextField mailField;
	private JPasswordField passwordField;
	private JTextField idField;
	
	//addMatiere
	private JLabel libelleLabel;
	private JTextPane libelleText;
	
	//addClasse
	private JLabel nivLabel;
	private JLabel filiereLabel;
	private JLabel libellecLabel;
			
	
	public AddFrame(DB db,String categ) {
		
		frame= new AppFrame("Ajouter "+categ,360,360,false);
		frame.getContentPane().add(this, BorderLayout.CENTER);
		this.setLayout(null);
		
		addBtn = new JButton("Ajouter");
		addBtn.setFont(new Font("Titillium Web SemiBold", Font.BOLD, 12));
		addBtn.setBounds(120, 250, 110, 35);
		add(addBtn);
		if(categ=="Matiere")
		{showMatiere();
		addBtn.setBounds(125, 200, 110, 35);
		}
		else if(categ=="Classe")
		{showClasse();}
		else if (categ=="Etudiant" || categ=="Responsable" || categ=="Enseignant")
		{
			showUser(categ);
		}
	
	}
		/*	
		
		*/
		

		
	
	
	
		
		
		/*ADD
		
		*/
	
	
	
	public void showUser(String categ)
	{	Font fnt= new Font("Titillium Web SemiBold", Font.PLAIN, 12);
		JLabel prenLabel = new JLabel("Prenom :");
		prenLabel.setFont(fnt);
		prenLabel.setBounds(71, 47, 59, 14);
		add(prenLabel);
		
		JLabel nameLabel = new JLabel("Nom :");
		nameLabel.setFont(fnt);
		nameLabel.setBounds(71, 78, 59, 14);
		add(nameLabel);
		
		JLabel loginLabel = new JLabel("Login :");
		loginLabel.setFont(fnt);
		loginLabel.setBounds(71, 111, 59, 14);
		add(loginLabel);
		
		JLabel passLabel = new JLabel("Password :");
		passLabel.setFont(fnt);
		passLabel.setBounds(71, 142, 59, 14);
		add(passLabel);
		
		JLabel mailLabel = new JLabel("E-mail :");
		mailLabel.setFont(fnt);
		mailLabel.setBounds(71, 176, 59, 14);
		add(mailLabel);
		
		prenField = new JTextField();
		prenField.setBounds(140, 44, 143, 20);
		add(prenField);
		prenField.setColumns(25);
		
		nameField = new JTextField();
		nameField.setBounds(140, 75, 143, 20);
		add(nameField);
		nameField.setColumns(25);
		
		loginField = new JTextField();
		loginField.setBounds(140, 108, 143, 20);
		add(loginField);
		loginField.setColumns(15);
		
		mailField = new JTextField();
		mailField.setBounds(140, 170, 143, 20);
		add(mailField);
		mailField.setColumns(64);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(25);
		passwordField.setBounds(140, 139, 143, 20);
		add(passwordField);
		
		if(categ =="Etudiant") {
		JLabel idLabel = new JLabel("ID Classe :");
		idLabel.setFont(new Font("Titillium Web SemiBold", Font.PLAIN, 12));
		idLabel.setBounds(71, 204, 59, 14);
		add(idLabel);
		
		idField = new JTextField();
		idField.setBounds(140, 201, 143, 20);
		add(idField);
		idField.setColumns(10);
		}
		
}
	
	public void showClasse() {
		
		Font fnt= new Font("Titillium Web SemiBold", Font.PLAIN, 12);
		nivLabel= new JLabel("Niveau :");
		nivLabel.setFont(fnt);
		nivLabel.setBounds(71, 38, 70, 14);
		add(nivLabel);
		
		filiereLabel = new JLabel("Filiere :");
		filiereLabel.setFont(fnt);
		filiereLabel.setBounds(71, 63, 70, 14);
		add(filiereLabel);
		
		libellecLabel = new JLabel("Libelle :");
		libellecLabel.setFont(fnt);
		libellecLabel.setBounds(71, 88, 70, 14);
		add(libellecLabel);
		
		nivField = new JTextField();
		nivField.setBounds(151, 35, 132, 20);
		add(nivField);
		nivField.setColumns(10);
		
		filiereField = new JTextField();
		filiereField.setBounds(151, 60, 132, 20);
		add(filiereField);
		filiereField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(71, 113, 212, 117);
		add(textPane);
		
		
	}
	
	public void showMatiere() {
		frame.setSize(360, 300);
		libelleLabel = new JLabel("Libelle :");
		libelleLabel.setFont(new Font("Titillium Web SemiBold", Font.PLAIN, 12));
		libelleLabel.setBounds(70, 30, 92, 22);
		add(libelleLabel);
		
		libelleText = new JTextPane();
		libelleText.setBounds(70, 60, 200, 125);
		add(libelleText);
	}
}

class ChooseAdd extends JPanel{
	private AppFrame frame;
	public ChooseAdd(DB db){
		frame= new AppFrame("Ajouter",360,130,false);
		frame.getContentPane().add(this, BorderLayout.CENTER);
		this.setLayout(null);
		
		JLabel choiceLabel = new JLabel("Je veux Ajouter :");
		choiceLabel.setFont(new Font("Titillium Web SemiBold", Font.PLAIN, 13));
		choiceLabel.setBounds(69, 11, 92, 22);
		add(choiceLabel);
		
		JComboBox choiceCombo = new JComboBox();
		choiceCombo.setFont(new Font("Titillium Web", Font.PLAIN, 12));
		choiceCombo.setModel(new DefaultComboBoxModel(new String[] {"Etudiant","Classe", "Enseignant", "Matiere", "Responsable"}));
		choiceCombo.setBounds(69, 38, 128, 22);
		add(choiceCombo);
		
		JButton okBtn = new JButton("Choix");
		okBtn.setFont(new Font("Titillium Web SemiBold", Font.PLAIN, 13));
		okBtn.setBounds(214, 36, 69, 25);
		add(okBtn);
		
		
		
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ch=(String)choiceCombo.getSelectedItem();
				new AddFrame(db, ch);
				frame.dispose();
		}});
	}
}