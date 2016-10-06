/**
 * Source: https://github.com/Hectorxda/MySettings/blob/master/src/com/android/settings/widget/WidgetSettings.java
 */
private void initWidgetSettings() {
        setContentView(R.layout.widget_settings);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            widgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        }
}
