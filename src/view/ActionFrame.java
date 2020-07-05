package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.DB;
import model.User;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ActionFrame extends JPanel{
	
	private AppFrame frame; 
	private JButton changePassBtn;
	
	private DB dbl;
	
	public ActionFrame(User user) 
	{
		
		switch(user.categ) {
		case("Etudiant"):
			studentFrame(user.name,user.getClasse(dbl));
			break;
		case("Enseignant"):
			profsFrame(user.name);
			break;
		case("Responsable"):
			respFrame(user.name);
			break;
		}
		changePassBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {new ChangePass(user);}
		});
	
	}
	
	
		/*
		 *  **Resp Frame**
		 * 
		 *
		 */
		public void respFrame(String name) {
		
			frame= new AppFrame("Options",360,360,false); 
			frame.setJMenuBar(frame.createMenuBar(frame));
			frame.getContentPane().add(this, BorderLayout.CENTER);
			this.setLayout(null);
			
			changePassBtn = new JButton("Changer mot de passe");
			changePassBtn.setFont(new Font("Titillium Web SemiBold", Font.BOLD, 14));
				
			JLabel labelResp = new JLabel("Administrateur :");
			labelResp.setFont(new Font("Titillium Web SemiBold", Font.BOLD, 20));
			labelResp.setBounds(10, 23, 146, 25);
			add(labelResp);
			
			JLabel nameResp = new JLabel(name);
			nameResp.setFont(new Font("Titillium Web Light", Font.PLAIN, 20));
			nameResp.setBounds(166, 23, 188, 25);
			add(nameResp);
			
			JButton mngBtn = new JButton("Gerer les Donnees");
			mngBtn.setFont(new Font("Titillium Web SemiBold", Font.BOLD, 14));
			mngBtn.setBounds(65, 100, 220, 50);
			add(mngBtn);
			mngBtn.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					new ManageFrame(dbl,"Etudiants");
				}
				
			});
			
			JButton statsBtn = new JButton("Voir Statistiques");
			statsBtn.setFont(new Font("Titillium Web SemiBold", Font.BOLD, 14));
			statsBtn.setBounds(65, 165, 220, 50);
			add(statsBtn);
			
			changePassBtn.setBounds(65, 230, 220, 50);
			add(changePassBtn);
			
	}
		
		
		
		
		
		
		
		/*
		 * 
		 * **Profs Frame**
		 *
		 */
		 public void profsFrame (String name)
		 {
			frame= new AppFrame("Options",360,250,false); 
			frame.setJMenuBar(frame.createMenuBar(frame));
			frame.getContentPane().add(this, BorderLayout.CENTER);
			this.setLayout(null);
			
			changePassBtn = new JButton("Changer mot de passe");
			changePassBtn.setFont(new Font("Titillium Web SemiBold", Font.BOLD, 14)); 
			 
			JLabel labelEns = new JLabel("Enseignant :");
			labelEns.setFont(new Font("Titillium Web SemiBold", Font.BOLD, 20));
			labelEns.setBounds(10, 17, 118, 28);
			add(labelEns);
			
			JLabel nameEns = new JLabel(name);
			nameEns.setFont(new Font("Titillium Web Light", Font.PLAIN, 20));
			nameEns.setBounds(130, 17, 156, 28);
			add(nameEns);
			
			JButton classesBtn = new JButton("Mes Classes");
			classesBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AbsenceManager();
				}
			});
			classesBtn.setFont(new Font("Titillium Web SemiBold", Font.PLAIN, 14));
			classesBtn.setBounds(87, 60, 191, 33);
			add(classesBtn);
			
			JButton matBtn = new JButton("Mes Matieres");
			matBtn.setFont(new Font("Titillium Web SemiBold", Font.PLAIN, 14));
			matBtn.setBounds(87, 103, 191, 33);
			add(matBtn);
			
			changePassBtn.setBounds(87, 146, 191, 33);
			add(changePassBtn);
		 }
		

		
		
		/*
		 * **Student Frame**
		 * 
		 * 
		 */
		 public void studentFrame(String name,String classe)
		 {
			
			frame= new AppFrame("Options",360,250,false); 
			frame.setJMenuBar(frame.createMenuBar(frame));
			frame.getContentPane().add(this, BorderLayout.CENTER);
			this.setLayout(null);
			
			changePassBtn = new JButton("Changer mot de passe");
			changePassBtn.setFont(new Font("Titillium Web SemiBold", Font.BOLD, 14)); 
			 
			 
			JButton consultAbsBtn = new JButton("Consulter mes absences");
			consultAbsBtn.setFont(new Font("Titillium Web SemiBold", Font.PLAIN, 14));
			consultAbsBtn.setBounds(87, 90, 181, 43);
			this.add(consultAbsBtn);
			
			JLabel labelStu = new JLabel("Etudiant : ");
			labelStu.setFont(new Font("Titillium Web SemiBold", Font.BOLD, 20));
			labelStu.setBounds(10, 22, 94, 23);
			this.add(labelStu); 
			
			JLabel nameStu = new JLabel(name);
			nameStu.setFont(new Font("Titillium Web Light", Font.PLAIN, 20));
			nameStu.setBounds(114, 22, 245, 22);
			this.add(nameStu);
			
			JLabel classLabel = new JLabel("Classe : ");
			classLabel.setFont(new Font("Titillium Web SemiBold", Font.BOLD, 20));
			classLabel.setBounds(10, 56, 94, 23);
			this.add(classLabel);
			
			JLabel classStu = new JLabel(classe);
			classStu.setFont(new Font("Titillium Web Light", Font.PLAIN, 20));
			classStu.setBounds(114, 56, 245, 22);
			this.add(classStu);
			
			
			changePassBtn.setBounds(87, 138, 181, 43);
			this.add(changePassBtn);
		 }
		
		 
		 /*passbtnAction
		 public void actionPerformed(ActionEvent e) {
				new ChangePass(dbl,user);
				frame.dispose();
				
			}*/
}
