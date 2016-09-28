/**
 * Source: https://github.com/rkipper/AppInventor_RK/blob/master/appinventor/blockslib/src/openblocks/codeblocks/InfixBlockShape.java
 */
private void appendPath(GeneralPath gp1, GeneralPath gp2, boolean reversed)
{
        ArrayList<Number[]> points = new ArrayList<Number[]>();
        // Each element is an array consisting of one Integer and six Floats

        PathIterator i = gp2.getPathIterator(new AffineTransform());

        float[] segment = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};

        float leftmost = Float.POSITIVE_INFINITY;

        while(!i.isDone())
        {
            int type = i.currentSegment(segment);
            i.next();

            points.add(new Number[]
            {
                new Integer(type),
                new Float(segment[0]),
                new Float(segment[1]),
                new Float(segment[2]),
                new Float(segment[3]),
                new Float(segment[4]),
                new Float(segment[5])
            });
        }
}
