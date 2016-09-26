/**
 * Source: https://github.com/17up/17Card/blob/master/plugins/org.apache.cordova.file/src/android/DirectoryManager.java
 */
public static long getFreeDiskSpace(boolean checkInternal) {
        String status = Environment.getExternalStorageState();
        long freeSpace = 0;

        // If SD card exists
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            freeSpace = freeSpaceCalculation(Environment.getExternalStorageDirectory().getPath());
        }
        else if (checkInternal) {
            freeSpace = freeSpaceCalculation("/");
        }
        // If no SD card and we haven't been asked to check the internal directory then return -1
        else {
            return -1;
        }

        return freeSpace;
}
