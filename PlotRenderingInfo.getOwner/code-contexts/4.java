/**
 * Source: https://github.com/apeeters/JFreeChart/blob/master/source/org/jfree/chart/renderer/category/AbstractCategoryItemRenderer.java
 */
public CategoryItemRendererState initialise(Graphics2D g2,
            Rectangle2D dataArea, CategoryPlot plot, CategoryDataset dataset,
            PlotRenderingInfo info) {

        setPlot(plot);
        if (dataset != null) {
            this.rowCount = dataset.getRowCount();
            this.columnCount = dataset.getColumnCount();
        }
        else {
            this.rowCount = 0;
            this.columnCount = 0;
        }
        CategoryItemRendererState state = createState(info);

        // determine if there is any selection state for the dataset
        CategoryDatasetSelectionState selectionState = null;
        if (dataset instanceof SelectableCategoryDataset) {
            SelectableCategoryDataset scd = (SelectableCategoryDataset) dataset;
            selectionState = scd.getSelectionState();
        }
        // if the selection state is still null, go to the selection source
        // and ask if it has state...
        if (selectionState == null && info != null) {
            ChartRenderingInfo cri = info.getOwner();
            if (cri != null) {
                RenderingSource rs = cri.getRenderingSource();
                selectionState = (CategoryDatasetSelectionState)
                        rs.getSelectionState(dataset);
            }
        }
        state.setSelectionState(selectionState);

        return state;
}
