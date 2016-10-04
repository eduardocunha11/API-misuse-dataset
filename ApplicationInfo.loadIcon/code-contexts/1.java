/**
 * Source: https://github.com/777rom/777_packages_apps_Settings/blob/master/src/com/android/settings/fuelgauge/PowerUsageDetail.java
 */
private void createDetails() {
        final Bundle args = getArguments();
        mTitle = args.getString(EXTRA_TITLE);
        final int percentage = args.getInt(EXTRA_PERCENT, 1);
        final int gaugeValue = args.getInt(EXTRA_GAUGE, 1);
        mUsageSince = args.getInt(EXTRA_USAGE_SINCE, USAGE_SINCE_UNPLUGGED);
        mUid = args.getInt(EXTRA_UID, 0);
        mDrainType = (DrainType) args.getSerializable(EXTRA_DRAIN_TYPE);
        mNoCoverage = args.getDouble(EXTRA_NO_COVERAGE, 0);
        String iconPackage = args.getString(EXTRA_ICON_PACKAGE);
        int iconId = args.getInt(EXTRA_ICON_ID, 0);
        if (!TextUtils.isEmpty(iconPackage)) {
            try {
                final PackageManager pm = getActivity().getPackageManager();
                ApplicationInfo ai = pm.getPackageInfo(iconPackage, 0).applicationInfo;
                if (ai != null) {
                    mAppIcon = ai.loadIcon(pm);
                }
            } catch (NameNotFoundException nnfe) {
                // Use default icon
            }
        } else if (iconId != 0) {
            mAppIcon = getActivity().getResources().getDrawable(iconId);
        }
        if (mAppIcon == null) {
            mAppIcon = getActivity().getPackageManager().getDefaultActivityIcon();
        }
        
        ...
        
}
