/**
 * Source: https://github.com/Sophnion/Temperature/blob/master/Temperature/lib/jfreechart-1.0.14/source/org/jfree/chart/renderer/category/StatisticalBarRenderer.java
 */
protected void drawHorizontalItem(Graphics2D g2,
                                      CategoryItemRendererState state,
                                      Rectangle2D dataArea,
                                      CategoryPlot plot,
                                      CategoryAxis domainAxis,
                                      ValueAxis rangeAxis,
                                      StatisticalCategoryDataset dataset,
                                      int visibleRow,
                                      int row,
                                      int column) {

        // BAR Y
        double rectY = calculateBarW0(plot, PlotOrientation.HORIZONTAL, 
                dataArea, domainAxis, state, visibleRow, column);

        // BAR X
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
