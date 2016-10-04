/**
 * Source: https://github.com/g3tsum/rb_apps_Settings/blob/master/src/com/android/settings/net/UidDetailProvider.java
 */
private UidDetail buildUidDetail(int uid) {
        ... 

        final String[] packageNames = pm.getPackagesForUid(uid);
        final int length = packageNames != null ? packageNames.length : 0;
        try {
            if (length == 1) {
                final ApplicationInfo info = pm.getApplicationInfo(packageNames[0], 0);
                detail.label = info.loadLabel(pm).toString();
                detail.icon = info.loadIcon(pm);
            } else if (length > 1) {
                detail.detailLabels = new CharSequence[length];
                for (int i = 0; i < length; i++) {
                    final String packageName = packageNames[i];
                    final PackageInfo packageInfo = pm.getPackageInfo(packageName, 0);
                    final ApplicationInfo appInfo = pm.getApplicationInfo(packageName, 0);

                    detail.detailLabels[i] = appInfo.loadLabel(pm).toString();
                    if (packageInfo.sharedUserLabel != 0) {
                        detail.label = pm.getText(packageName, packageInfo.sharedUserLabel,
                                packageInfo.applicationInfo).toString();
                        detail.icon = appInfo.loadIcon(pm);
                    }
                }
            }
        } catch (NameNotFoundException e) {}
        ...
  }
