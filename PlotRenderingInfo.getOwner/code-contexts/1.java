/**
 * Source: https://github.com/AEDsoftware/arcadia_chart_test/blob/master/chart_test_jfree/jfreechart-1.0.14/source/org/jfree/chart/axis/Axis.java
 */
protected void createAndAddEntity(double cursor, AxisState state,
            Rectangle2D dataArea, RectangleEdge edge,
            PlotRenderingInfo plotState) {

        if (plotState == null || plotState.getOwner() == null) {
            return;  // no need to create entity if we can´t save it anyways...
        }
        Rectangle2D hotspot = null;
        if (edge.equals(RectangleEdge.TOP)) {
            hotspot = new Rectangle2D.Double(dataArea.getX(),
                    state.getCursor(), dataArea.getWidth(),
                    cursor - state.getCursor());
        }
        else if (edge.equals(RectangleEdge.BOTTOM)) {
            hotspot = new Rectangle2D.Double(dataArea.getX(), cursor,
                    dataArea.getWidth(), state.getCursor() - cursor);
        }
        else if (edge.equals(RectangleEdge.LEFT)) {
            hotspot = new Rectangle2D.Double(state.getCursor(),
                    dataArea.getY(), cursor - state.getCursor(),
                    dataArea.getHeight());
        }
        else if (edge.equals(RectangleEdge.RIGHT)) {
            hotspot = new Rectangle2D.Double(cursor, dataArea.getY(),
                    state.getCursor() - cursor, dataArea.getHeight());
        }
        EntityCollection e = plotState.getOwner().getEntityCollection();
        if (e != null) {
            e.add(new AxisEntity(hotspot, this));
        }
}
