/**
 * Source: https://github.com/JoosepHint/Gallery3D_EVO_3D/blob/master/tests/src/com/android/gallery3d/common/BlobCacheTest.java
 */
public void testDataIntegrity() throws IOException {
        String name = TEST_FILE_NAME;
        File idxFile = new File(name + ".idx");
        File data0File = new File(name + ".0");
        File data1File = new File(name + ".1");
        RandomAccessFile f;

        Log.v(TAG, "It should be readable if the content is not changed.");
        prepareNewCache();
        f = new RandomAccessFile(data0File, "rw");
        f.seek(1);
        byte b = f.readByte();
        f.seek(1);
        f.write(b);
        f.close();
        assertReadable();
        ...
}
