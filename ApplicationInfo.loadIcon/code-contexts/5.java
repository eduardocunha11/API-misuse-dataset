/**
 * Source: https://github.com/tarosay/TestSource/blob/master/android/java/com/android/internal/app/HeavyWeightSwitcherActivity.java
 */
void setIconAndText(int iconId, int actionId, int descriptionId,
            String packageName, int actionStr, int descriptionStr) {
        CharSequence appName = "";
        Drawable appIcon = null;
        if (mCurApp != null) {
            try {
                ApplicationInfo info = getPackageManager().getApplicationInfo(
                        packageName, 0);
                appName = info.loadLabel(getPackageManager());
                appIcon = info.loadIcon(getPackageManager());
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        
        setDrawable(iconId, appIcon);
        setText(actionId, getString(actionStr, appName));
        setText(descriptionId, getText(descriptionStr));
}
