package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import controller.Messages;

public class StatsFrame extends JPanel{
	
	private AppFrame frame;
	
	public StatsFrame() {
		
		frame= new AppFrame("Consulter les Statiqtiques",300,190,false);
		frame.getContentPane().setLayout(null);
		
		JButton evoBtn = new JButton("Evolution du nombre d'absences");
		evoBtn.setFont(new Font("Titillium Web SemiBold", Font.PLAIN, 12));
		evoBtn.setBounds(30, 35, 230, 44);
		frame.getContentPane().add(evoBtn);
		evoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JButton disBtn = new JButton("Distribution des absences par classes");
		disBtn.setFont(new Font("Titillium Web SemiBold", Font.PLAIN, 12));
		disBtn.setBounds(30, 90, 230, 44);
		frame.getContentPane().add(disBtn);
		
		disBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
	}
}

class AbsChart {
	private AppFrame frame;
	private ChartPanel panel;
	public AbsChart() {
		
		 DefaultPieDataset dataset = new DefaultPieDataset( );
	      
	      /*Control part 
	      while( resultSet.next( ) ) {
	         dataset.setValue( 
	         resultSet.getString() ,
	         Double.parseDouble( resultSet.getString()));
	      }
	      */
	      JFreeChart chart = ChartFactory.createPieChart(
	         "Disposition D\'absences par classe",   // chart title           
	         dataset,          // data           
	         true,             // include legend          
	         true,           
	         false );

	      panel= new ChartPanel(chart);
	      panel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      frame.setContentPane( panel );
	      
		
	}
	
}

class AbsGraph {
	private AppFrame frame;
	private ChartPanel panel;
	public AbsGraph() {
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		 
		 /*CONTROL
		  while( resultSet.next( ) ) {
	         dataset.setValue( 
	         Double.parseDouble( resultSet.getString()),
	         resultSet.getString() ,
	         ResultSet.getString());
	         }
		 
		  */
		
		JFreeChart lineChart = ChartFactory.createLineChart(
		         "Taux d\'absences par jour",
		         "Jour","Absences",
		         dataset,
		         PlotOrientation.VERTICAL,
		         true,true,false);
		         
		      panel = new ChartPanel( lineChart );
		      panel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
		      frame.setContentPane( panel );
		   }

		  
	}
	




/*
 


public class PieChart_DB {
   
      DefaultPieDataset dataset = new DefaultPieDataset( );
      
      //Control part 
      while( resultSet.next( ) ) {
         dataset.setValue( 
         resultSet.getString() ,
         Double.parseDouble( resultSet.getString()));
      }
      //
      JFreeChart chart = ChartFactory.createPieChart(
         "Mobile Sales",   // chart title           
         dataset,          // data           
         true,             // include legend          
         true,           
         false );

      int width = 560;    // Width of the image 
      int height = 370;   // Height of the image 
      File pieChart = new File( "Pie_Chart.jpeg" );
      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
   }
}
*/
