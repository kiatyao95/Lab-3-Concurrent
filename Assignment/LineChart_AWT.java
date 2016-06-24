import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


public class LineChart_AWT extends ApplicationFrame {
	 public LineChart_AWT( String applicationTitle , String chartTitle, ArrayList<Double> arrayOfMin )
	   {
	      super(applicationTitle);
	      JFreeChart lineChart = ChartFactory.createLineChart(
	         chartTitle,
	         "Generation","Fitness Value",
	         createDataset(arrayOfMin),
	         PlotOrientation.VERTICAL,
	         true,true,false);
	         
	      ChartPanel chartPanel = new ChartPanel( lineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      setContentPane( chartPanel );
	   }

	   private DefaultCategoryDataset createDataset(ArrayList<Double> arrayOfMin)
	   {
	      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	      for(int i=0;i<arrayOfMin.size();i++){
	      dataset.addValue( arrayOfMin.get(i) , "Fitness" , Integer.toString(i) );
	      }

	      return dataset;
	   }
}
