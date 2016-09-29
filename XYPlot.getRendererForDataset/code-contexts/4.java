/**
 * Source: https://github.com/brendankehoe/SummerRetailProject/blob/master/TeamProject/src/Sprint2_Day6/GUI_StockControlScreen.java
 */
public void makeChart() {
		 
		String chartTitle="";
		
		//Build a string buffer - detects if the selection contains numbers
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<selctedProductText.length(); i++)
		{
			if(Character.isDigit(selctedProductText.charAt(i))){
				sb.append(selctedProductText.charAt(i));
			}
			else{
				break;
			}
		}
		if (orderInvoiceSelection.equals("Sales")) {
			if (sb.length()!=0){ //then a product must be selected
				//Find the product corresponding to the selected ID in the item
				Product product = NewUI.db.getProducts().get(Integer.parseInt(sb.toString())-1);
				chartTitle=product.getName()+ " - Weekly Sales";
			}
			else if (productSelectionComboBox.getSelectedIndex()==0){
				chartTitle="Total Weekly Sales";
			}
		}
		else if (orderInvoiceSelection.equals("Purchases")) {
			if (sb.length() != 0) { // then a product must be selected
				// Find the product corresponding to the selected ID in the item
				Product product = NewUI.db.getProducts().get(
						Integer.parseInt(sb.toString()) - 1);
				chartTitle = product.getName() + " - Weekly Purchases";
			} else if (productSelectionComboBox.getSelectedIndex() == 0) {
				chartTitle = "Total Weekly Purchases";
			}
		}

		
		JFreeChart chart = ChartFactory.createTimeSeriesChart(chartTitle, "Time", "", null,true,false,false);
		XYPlot xyplot = (XYPlot)chart.getPlot();
		XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Color.white);
		
		plot.setDataset(0,dataFromTable());
		XYLineAndShapeRenderer renderer0 = new XYLineAndShapeRenderer(); 
		plot.setRenderer(0,renderer0); 
		plot.getRendererForDataset(plot.getDataset(0)).setSeriesItemLabelsVisible(0, false); 
		plot.getRendererForDataset(plot.getDataset(0)).setBaseItemLabelsVisible(false); 
		plot.getRendererForDataset(plot.getDataset(0)).setBaseItemLabelsVisible(false); 
		plot.getRendererForDataset(plot.getDataset(0)).setSeriesPaint(0, Color.blue); 


		//If prediction combo box is selected, then add prediction values to chart
		if (predictionCheckBox.isSelected()){			
			plot.setDataset(1, predictionDataFromTable());
			XYLineAndShapeRenderer renderer1 = new XYLineAndShapeRenderer();
			plot.setRenderer(1, renderer1); 
			plot.getRendererForDataset(plot.getDataset(1)).setSeriesPaint(0, Color.red);
		}

		DateAxis dateaxis = (DateAxis) plot.getDomainAxis();
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(700, 470));
		botJP.add(chartPanel);
}
