/**
 * Source: https://github.com/broodplank/android_packages_apps_Settings/blob/master/src/com/android/settings/CryptKeeper.java
 */
private void showFactoryReset() {
        // Hide the encryption-bot to make room for the "factory reset" button
        findViewById(R.id.encroid).setVisibility(View.GONE);

        // Show the reset button, failure text, and a divider
        final Button button = (Button) findViewById(R.id.factory_reset);
        button.setVisibility(View.VISIBLE);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Factory reset the device.
                sendBroadcast(new Intent("android.intent.action.MASTER_CLEAR"));
            }
        });

        // Alert the user of the failure.
        ((TextView) findViewById(R.id.title)).setText(R.string.crypt_keeper_failed_title);
        ((TextView) findViewById(R.id.status)).setText(R.string.crypt_keeper_failed_summary);

        final View view = findViewById(R.id.bottom_divider);
        // TODO(viki): Why would the bottom divider be missing in certain layouts? Investigate.
        if (view != null) {
            view.setVisibility(View.VISIBLE);
        }
}
