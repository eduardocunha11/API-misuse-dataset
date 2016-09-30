/**
 * Source: https://github.com/AlbanDeAlmeida/GeekTic/blob/master/hsqldb-2.2.9/hsqldb/src/org/hsqldb/jdbc/JDBCBlobFile.java
 */
public void truncate(long len) throws SQLException {

        if (len < 0) {
            throw Util.invalidArgument("len: " + len);
        }

        checkClosed();

        RandomAccessFile randomAccessFile = null;

        try {
            randomAccessFile = new RandomAccessFile(m_file, "rw");

            randomAccessFile.setLength(len);
        } catch (Exception ex) {
            throw Util.sqlException(ex);
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception ex) {}
            }
        }
}
