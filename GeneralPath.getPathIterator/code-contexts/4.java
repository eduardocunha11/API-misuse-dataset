/**
 * Source: https://github.com/piccolo2d/piccolo2d.java/blob/master/extras/src/main/java/org/piccolo2d/extras/activities/PPositionPathActivity.java
 */
public void setPositions(final GeneralPath path) {
        final PathIterator pi = path.getPathIterator(null, 1);
        final ArrayList points = new ArrayList();
        final float[] point = new float[6];
        float distanceSum = 0;
        float lastMoveToX = 0;
        float lastMoveToY = 0;

        while (!pi.isDone()) {
            final int type = pi.currentSegment(point);

            switch (type) {
                case PathIterator.SEG_MOVETO:
                    points.add(new Point2D.Float(point[0], point[1]));
                    lastMoveToX = point[0];
                    lastMoveToY = point[1];
                    break;

                case PathIterator.SEG_LINETO:
                    points.add(new Point2D.Float(point[0], point[1]));
                    break;

                case PathIterator.SEG_CLOSE:
                    points.add(new Point2D.Float(lastMoveToX, lastMoveToY));
                    break;

                case PathIterator.SEG_QUADTO:
                case PathIterator.SEG_CUBICTO:
                    throw new RuntimeException();
                default:
                    // ok to do nothing it'll just be skipped
            }

            if (points.size() > 1) {
                final Point2D last = (Point2D) points.get(points.size() - 2);
                final Point2D current = (Point2D) points.get(points.size() - 1);
                distanceSum += last.distance(current);
            }

            pi.next();
        }
}
