/**
 * Source: https://github.com/COMU/homescreen/blob/master/damla/homescreen/src/org/comu/homescreen/CustomShirtcutActivity.java
 */
private IconItemInfo getShortcutInfo() {
    final Intent intent = getIntent();
    if (intent != null && intent.getAction() != null &&
        intent.getAction().equals(Intent.ACTION_EDIT) && 
        intent.hasExtra(EXTRA_APPLICATIONINFO)) {

    long id = intent.getLongExtra(EXTRA_APPLICATIONINFO, 0);
    ItemInfo info = null;
    if (intent.hasExtra(EXTRA_DRAWERINFO))
    {
       btRevert.setVisibility(View.VISIBLE);
       btPickActivity.setVisibility(View.GONE);
       isDrawerInfo = true;
       List<ShortcutInfo> apps = launcherApp.getAppDB().getApps(new long[] {id});
       if (apps.size() == 1)
       {
          info = apps.get(0);
       }
    }
    else
    {
        info = launcherApp.getModel().getItemInfoById(id);
    }
    if (info instanceof IconItemInfo)
        return (IconItemInfo) info;
    }
    return null;
}
