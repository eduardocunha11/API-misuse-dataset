/**
 * Source: https://github.com/1mobilesuper/1mobile_download/blob/master/src/me/onemobile/android/download/Helpers.java
 */
public static boolean isExternalMediaMounted() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            // No SD card found.
            Log.d(Constants.TAG, "no external storage");
            return false;
        }
        return true;
}
