/**
 * Source: https://github.com/JoosepHint/Gallery3D_EVO_3D/blob/master/src/com/android/photos/MultiChoiceManager.java
 */
private void singleItemAction(Object item, int actionItemId) {
        Intent intent = new Intent();
        String mime = getItemMimetype(item);
        Uri uri = mDelegate.getItemUri(item);
        switch (actionItemId) {
            case R.id.menu_edit:
                intent.setDataAndType(uri, mime)
                      .setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                      .setAction(Intent.ACTION_EDIT);
                mContext.startActivity(Intent.createChooser(intent, null));
                return;
            case R.id.menu_crop:
                intent.setDataAndType(uri, mime)
                      .setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                      .setAction(FilterShowActivity.CROP_ACTION)
                      .setClass(mContext, FilterShowActivity.class);
                mContext.startActivity(intent);
                return;
            case R.id.menu_trim:
                intent.setData(uri)
                      .setClass(mContext, TrimVideo.class);
                mContext.startActivity(intent);
                return;
            case R.id.menu_mute:
                /* TODO need a way to get the file path of an item
                MuteVideo muteVideo = new MuteVideo(filePath,
                        uri, (Activity) mContext);
                muteVideo.muteInBackground();
                */
                return;
            case R.id.menu_set_as:
                intent.setDataAndType(uri, mime)
                      .setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                      .setAction(Intent.ACTION_ATTACH_DATA)
                      .putExtra("mimeType", mime);
                mContext.startActivity(Intent.createChooser(
                        intent, mContext.getString(R.string.set_as)));
                return;
            default:
                return;
        }
}
