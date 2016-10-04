/**
 * Source: https://github.com/777rom/777_frameworks_base/blob/master/services/java/com/android/server/am/UsageStatsService.java
 */
private void readStatsFromFile() {
        File newFile = mFile;
        synchronized (mFileLock) {
            try {
                if (newFile.exists()) {
                    readStatsFLOCK(newFile);
                } else {
                    // Check for file limit before creating a new file
                    checkFileLimitFLOCK();
                    newFile.createNewFile();
                }
            } catch (IOException e) {
                Slog.w(TAG,"Error : " + e + " reading data from file:" + newFile);
            }
        }
}
