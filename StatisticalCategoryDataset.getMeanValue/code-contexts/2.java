/**
 * Source: https://github.com/yquemener/ModelKeynesJamel/blob/master/src/org/jfree/chart/renderer/category/StatisticalLineAndShapeRenderer.java
 */
public void drawItem(Graphics2D g2,
                     CategoryItemRendererState state,
                     Rectangle2D dataArea,
                     CategoryPlot plot,
                     CategoryAxis domainAxis,
                     ValueAxis rangeAxis,
                     CategoryDataset dataset,
                     int row,
                     int column,
                     int pass) {

        // do nothing if item is not visible
        if (!getItemVisible(row, column)) {
            return;
        }

        // if the dataset is not a StatisticalCategoryDataset then just revert
        // to the superclass (LineAndShapeRenderer) behaviour...
        if (!(dataset instanceof StatisticalCategoryDataset)) {
            super.drawItem(g2, state, dataArea, plot, domainAxis, rangeAxis,
                    dataset, row, column, pass);
            return;
        }

        int visibleRow = state.getVisibleSeriesIndex(row);
        if (visibleRow < 0) {
            return;
        }
        int visibleRowCount = state.getVisibleSeriesCount();

        StatisticalCategoryDataset statDataset = (StatisticalCategoryDataset) dataset;
        Number meanValue = statDataset.getMeanValue(row, column);
        if (meanValue == null) {
            return;
        }
        PlotOrientation orientation = plot.getOrientation();

        // current data point...
        double x1;
        if (getUseSeriesOffset()) {
            x1 = domainAxis.getCategorySeriesMiddle(column,
                    dataset.getColumnCount(),
                    visibleRow, visibleRowCount,
                    getItemMargin(), dataArea, plot.getDomainAxisEdge());
        } else {
            x1 = domainAxis.getCategoryMiddle(column, getColumnCount(),
                    dataArea, plot.getDomainAxisEdge());
        }
        double y1 = rangeAxis.valueToJava2D(meanValue.doubleValue(), dataArea,
                plot.getRangeAxisEdge());

        ...
         
    }
