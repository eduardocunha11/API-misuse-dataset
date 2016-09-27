/**
 * Source: https://github.com/ACSOP/android_packages_apps_mms/blob/master/src/com/android/mms/ui/DeliveryReportActivity.java
 */
private long getMessageId(Bundle icicle, Intent intent) {
   long msgId = 0L;
   if (icicle != null) {
      msgId = icicle.getLong("message_id");
   }
   if (msgId == 0L) {
      msgId = intent.getLongExtra("message_id", 0L);
   }
   return msgId;
}
