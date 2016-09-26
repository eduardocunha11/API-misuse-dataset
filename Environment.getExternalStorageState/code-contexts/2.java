/**
 * Source: https://github.com/17up/17Card/blob/master/plugins/org.apache.cordova.camera/src/android/CameraLauncher.java
 */
private Uri whichContentStore() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else {
            return android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        }
}
