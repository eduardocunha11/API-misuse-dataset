/**
 * Source: https://github.com/cozybit/aosp-frameworks-base/blob/master/services/java/com/android/server/BackupManagerService.java
 */
private void initPackageTracking() {
        if (DEBUG) Slog.v(TAG, "Initializing package tracking");

        // Remember our ancestral dataset
        mTokenFile = new File(mBaseStateDir, "ancestral");
        try {
            RandomAccessFile tf = new RandomAccessFile(mTokenFile, "r");
            int version = tf.readInt();
            if (version == CURRENT_ANCESTRAL_RECORD_VERSION) {
                mAncestralToken = tf.readLong();
                mCurrentToken = tf.readLong();

                int numPackages = tf.readInt();
                if (numPackages >= 0) {
                    mAncestralPackages = new HashSet<String>();
                    for (int i = 0; i < numPackages; i++) {
                        String pkgName = tf.readUTF();
                        mAncestralPackages.add(pkgName);
                    }
                }
            }
            tf.close();
        } catch (FileNotFoundException fnf) {
            // Probably innocuous
            Slog.v(TAG, "No ancestral data");
        } catch (IOException e) {
            Slog.w(TAG, "Unable to read token file", e);
            
        ...    
}
