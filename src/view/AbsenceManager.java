package view;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class AbsenceManager extends JPanel{
	
	private AppFrame frame;
	private JTable classTable;
	private JTable absTable;
	
	
	public AbsenceManager() {
		
		frame=new AppFrame("Gerer les absences des classes",650,500,true);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel choicePanel = new JPanel();
		choicePanel.setBorder(new TitledBorder(null, "Mes Classes ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(choicePanel, BorderLayout.NORTH);
		choicePanel.setLayout(new MigLayout("", "[grow][][79.00,grow][197.00,grow][11.00][][][10.00][grow]", "[]"));
		
		JLabel classLabel = new JLabel("Classe :");
		choicePanel.add(classLabel, "cell 2 0,alignx right");
		
		JComboBox classCombo = new JComboBox();
		choicePanel.add(classCombo, "cell 3 0,growx");
		
		JButton importBtn = new JButton("Importer");
		choicePanel.add(importBtn, "cell 5 0,growx");
		
		JPanel actionsPanel = new JPanel();
		frame.getContentPane().add(actionsPanel, BorderLayout.CENTER);
		actionsPanel.setLayout(new MigLayout("", "[273.00,grow][5.00][grow]", "[grow]"));
		
		JPanel classPanel = new JPanel();
		actionsPanel.add(classPanel, "cell 0 0,grow");
		classPanel.setLayout(new BorderLayout(0, 0));
		
		JButton absBtn = new JButton("Marquer Absent");
		absBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		classPanel.add(absBtn, BorderLayout.NORTH);
		
		
		classTable = new JTable();
		classPanel.add(classTable, BorderLayout.CENTER);
		
		JSeparator separator = new JSeparator();
		actionsPanel.add(separator, "cell 1 0");
		
		JPanel absPanel = new JPanel();
		actionsPanel.add(absPanel, "cell 2 0,grow");
		absPanel.setLayout(new BorderLayout(0, 0));
		
		JButton saveBtn = new JButton("Sauvegarder");
		absPanel.add(saveBtn, BorderLayout.SOUTH);
		
		
		
		JButton unAbsBtn = new JButton("Retirer de la liste d'absences");
		unAbsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		absPanel.add(unAbsBtn, BorderLayout.NORTH);
		
		absTable = new JTable();
		absPanel.add(absTable, BorderLayout.CENTER);
		
		
	}
}
