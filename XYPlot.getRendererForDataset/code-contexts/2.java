/**
 * Source: https://github.com/mkausal/cakeCuttingOnACloud/blob/master/FairAllocation/src/LineChart.java
 */
public static void generateChart(double Y[],double x[],String label,Color c) {
        XYSeries series = new XYSeries(label);
        for(int i=0;i<Y.length;i++)
        {	
           series.add(x[i], Y[i]);
        }
        XYDataset xyDataset = new XYSeriesCollection(series);
        XYSplineRenderer xYSplineRenderer=new XYSplineRenderer ();
        if(chart==null)
        {   
          chart = ChartFactory.createXYLineChart(
            "BER vs SNR", "SNR(DB)", "BER",
            xyDataset, PlotOrientation.VERTICAL, true, true, false);
        }
        
        XYPlot plot = chart.getXYPlot();
        plot.setDataset(count, xyDataset);
        plot.setRenderer(count, new XYSplineRenderer());
       
        new XYCrosshairState().getAnchorY(); 
              
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
       
        plot.getRendererForDataset(plot.getDataset(count)).setSeriesPaint(count, c);
       
        if(frame1==null)
        {	
        	frame1 = new ChartFrame("XYLine Chart", chart);
        }		
        frame1.setVisible(true);
        frame1.setSize(400, 400);
        count++;
}
