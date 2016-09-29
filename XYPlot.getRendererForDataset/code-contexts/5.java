/**
 * Source: https://github.com/rstjohn/latiz/blob/master/latizrcp/AandRPlotting/src/com/AandR/beans/plotting/LinePlotPanel/LinePlotPanel.java
 */
public void setChartType(int type) {
        if (type == SCATTER_PLOT) {
            isSymbolVisible = true;
            isLineVisible = false;
        } else {
            isSymbolVisible = false;
            isLineVisible = true;
        }
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) chartPanel.getChart().getXYPlot().getRenderer();
        renderer.setBaseLinesVisible(isLineVisible);
        renderer.setBaseShapesVisible(isSymbolVisible);
}
