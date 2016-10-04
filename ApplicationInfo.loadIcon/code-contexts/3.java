/**
 * Source: https://github.com/embest-tech/rowboat-frameworks-base/blob/master/core/java/android/app/ApplicationContext.java
 */
public Drawable getActivityIcon(Intent intent) throws NameNotFoundException {
            if (intent.getComponent() != null) {
                return getActivityIcon(intent.getComponent());
            }

            ResolveInfo info = resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
            if (info != null) {
                return info.activityInfo.loadIcon(this);
            }
            throw new NameNotFoundException(intent.toURI());
}
