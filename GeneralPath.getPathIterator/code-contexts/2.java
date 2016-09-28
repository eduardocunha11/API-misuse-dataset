/**
 * Source: https://github.com/DongheonKim/android_frameworks_base/blob/master/tools/layoutlib/bridge/src/android/graphics/Path_Delegate.java
 */
public void offset(float dx, float dy, Path_Delegate dst) {
        GeneralPath newPath = new GeneralPath();

        PathIterator iterator = mPath.getPathIterator(new AffineTransform(0, 0, dx, 0, 0, dy));

        newPath.append(iterator, false /*connect*/);

        if (dst != null) {
            dst.mPath = newPath;
        } else {
            mPath = newPath;
        }
}
