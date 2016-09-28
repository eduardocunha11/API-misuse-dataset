/**
 * Source: https://github.com/integrated/jfreechart/blob/master/source/org/jfree/chart/axis/CategoryAxis.java
 */
protected AxisState drawCategoryLabels(Graphics2D g2,
                                           Rectangle2D plotArea,
                                           Rectangle2D dataArea,
                                           RectangleEdge edge,
                                           AxisState state,
                                           PlotRenderingInfo plotState) {

        if (isTickLabelsVisible()) {
            
           Shape bounds = block.calculateBounds(g2, (float) anchorPoint.getX(), (float) anchorPoint.getY(),
                 position.getLabelAnchor(), (float) anchorPoint.getX(), (float) anchorPoint.getY(), position.getAngle());
                        
           if (plotState != null && plotState.getOwner() != null) {
               EntityCollection entities = plotState.getOwner().getEntityCollection();
               if (entities != null) {
                  String tooltip = getCategoryLabelToolTip(tick.getCategory());
                  entities.add(new CategoryLabelEntity(tick.getCategory(), bounds, tooltip, null));
               }
           }
           categoryIndex++;
      }
      return state;
}

