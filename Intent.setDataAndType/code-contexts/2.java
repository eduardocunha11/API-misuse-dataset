/**
 * Source: https://github.com/JoosepHint/Gallery3D_EVO_3D/blob/master/src/com/android/camera/VideoModule.java
 */
private void startPlayVideoActivity() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(mCurrentVideoUri, convertOutputFormatToMimeType(mProfile.fileFormat));
        try {
            mActivity.startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            Log.e(TAG, "Couldn't view video " + mCurrentVideoUri, ex);
        }
}
