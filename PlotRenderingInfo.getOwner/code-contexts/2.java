/**
 * Source: https://github.com/chipster/chipster/blob/master/src/main/java/fi/csc/microarray/client/visualisation/methods/VenndiPlot.java
 */
private void createEntity(Shape shape, PlotRenderingInfo info) {
        
        if (info != null) {
            EntityCollection entities = info.getOwner().getEntityCollection();
            if (entities != null) {
                entities.add(new ChartEntity(shape));
            }
        }
}
