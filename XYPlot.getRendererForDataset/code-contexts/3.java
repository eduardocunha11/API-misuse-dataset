/**
 * Source: https://github.com/rstjohn/latiz/blob/master/latizrcp/AandRPlotting/src/com/AandR/beans/plotting/LinePlotPanel/LinePlotPanel.java
 */
public void setChartType(XYDataset dataset, int type) {
        if (type == SCATTER_PLOT) {
            isSymbolVisible = true;
            isLineVisible = false;
        } else {
            isSymbolVisible = false;
            isLineVisible = true;
        }
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) chartPanel.getChart().getXYPlot().getRendererForDataset(dataset);
        renderer.setBaseLinesVisible(isLineVisible);
        renderer.setBaseShapesVisible(isSymbolVisible);
}
