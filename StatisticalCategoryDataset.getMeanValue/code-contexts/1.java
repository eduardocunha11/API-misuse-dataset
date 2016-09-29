/**
 * Source: https://github.com/yquemener/ModelKeynesJamel/blob/master/src/org/jfree/data/general/DatasetUtilities.java
 */ 
public static Range iterateToFindRangeBounds(CategoryDataset dataset,
            List visibleSeriesKeys, boolean includeInterval) {

        if (dataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        if (visibleSeriesKeys == null) {
            throw new IllegalArgumentException(
                    "Null 'visibleSeriesKeys' argument.");
        }

        double minimum = Double.POSITIVE_INFINITY;
        double maximum = Double.NEGATIVE_INFINITY;
        int columnCount = dataset.getColumnCount();
        
        if (includeInterval && dataset instanceof StatisticalCategoryDataset) {
            // handle the special case where the dataset has y-intervals that
            // we want to measure
            StatisticalCategoryDataset scd = (StatisticalCategoryDataset) dataset;
            Iterator iterator = visibleSeriesKeys.iterator();
            while (iterator.hasNext()) {
                Comparable seriesKey = (Comparable) iterator.next();
                int series = dataset.getRowIndex(seriesKey);
                for (int column = 0; column < columnCount; column++) {
                    Number meanN = scd.getMeanValue(series, column);
                    if (meanN != null) {
                        double std = 0.0;
                        Number stdN = scd.getStdDevValue(series, column);
                        if (stdN != null) {
                            std = stdN.doubleValue();
                            if (Double.isNaN(std)) {
                                std = 0.0;
                            }
                        }
                        double mean = meanN.doubleValue();
                        if (!Double.isNaN(mean)) {
                            minimum = Math.min(minimum, mean - std);
                            maximum = Math.max(maximum, mean + std);
                        }
                    }
                }
            }
        }
}
