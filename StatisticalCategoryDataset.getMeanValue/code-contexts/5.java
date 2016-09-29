/**
 * Source: https://github.com/ChrisCummins/open-microlabs/blob/master/lib/jfreechart-1.0.14/source/org/jfree/chart/renderer/category/StatisticalBarRenderer.java
 */
protected void drawVerticalItem(Graphics2D g2,
                                    CategoryItemRendererState state,
                                    Rectangle2D dataArea,
                                    CategoryPlot plot,
                                    CategoryAxis domainAxis,
                                    ValueAxis rangeAxis,
                                    StatisticalCategoryDataset dataset,
                                    int visibleRow,
                                    int row,
                                    int column) {

        // BAR X
        double rectX = calculateBarW0(plot, PlotOrientation.VERTICAL, dataArea,
                domainAxis, state, visibleRow, column);

        // BAR Y
        Number meanValue = dataset.getMeanValue(row, column);
        if (meanValue == null) {
            return;
        }

        double value = meanValue.doubleValue();
        double base = 0.0;
        double lclip = getLowerClip();
        double uclip = getUpperClip();
  
        ...
}
