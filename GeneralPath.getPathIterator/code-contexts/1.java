/**
 * Source: https://github.com/AppScale/sample-apps/blob/master/java/appinventor2/appinventor/blockslib/src/openblocks/codeblocks/rendering/BlockShapeUtil.java
 */
public static void printPath(GeneralPath gp)
{
        if(gp == null) {
            System.out.println("(null path)");

            return;
        }

        int type;
        float[] segment = new float[6];

        PathIterator i = gp.getPathIterator(new AffineTransform());

        while(!i.isDone()) {
            type = i.currentSegment(segment);

            if(type == PathIterator.SEG_MOVETO)
                System.out.println("m: (" + segment[0] + ", " + segment[1] + ")");
            else if(type == PathIterator.SEG_LINETO)
                System.out.println("l: (" + segment[0] + ", " + segment[1] + ")");
            else if(type == PathIterator.SEG_QUADTO)
                System.out.println("q: (" + segment[0] + ", " + segment[1] + "), (" + segment[2] + ", " + segment[3] + ")");
            else if(type == PathIterator.SEG_CUBICTO)
                System.out.println("c: (" + segment[0] + ", " + segment[1] + "), (" + segment[2] + ", " + segment[3] + "), (" + segment[4] + ", " + segment[5] + ")");

            i.next();
        }
}
