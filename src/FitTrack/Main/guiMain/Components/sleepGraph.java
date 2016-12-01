package FitTrack.Main.guiMain.Components;

/**
 * Created by colin on 01/12/16.
 */
import FitTrack.Components.sleep;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.ArrayList;

public class sleepGraph extends JFrame
{
	ArrayList<sleep> sleepData;

	public sleepGraph(String applicationTitle , String chartTitle, ArrayList<sleep> sleepData)
	{
		super(applicationTitle);
		this.sleepData = sleepData;
		JFreeChart lineChart = ChartFactory.createLineChart(
				chartTitle,
				"Date","Hours Slept",
				createDataset(),
				PlotOrientation.VERTICAL,
				true,true,false);

		ChartPanel chartPanel = new ChartPanel( lineChart );
		chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
		setContentPane( chartPanel );
	}

	private DefaultCategoryDataset createDataset( )
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		for (sleep slp : sleepData)
		{
			String[] date = slp.getDf().split("/");
			String dt = date[0] + "-" + date[1];
			dataset.addValue(slp.getHours(), "hours", dt);
		}
		return dataset;
	}
}
