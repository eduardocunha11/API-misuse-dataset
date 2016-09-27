/**
 * Source: https://github.com/ACSOP/android_packages_apps_calendar/blob/master/src/com/android/calendar/AllInOneActivity.java
 */
private long parseViewAction(final Intent intent) {

      long timeMillis = -1;
      Uri data = intent.getData();
      if (data != null && data.isHierarchical()) {
          List<String> path = data.getPathSegments();
          if (path.size() == 2 && path.get(0).equals("events")) {
          try {
              mViewEventId = Long.valueOf(data.getLastPathSegment());
              if (mViewEventId != -1) {
                  mIntentEventStartMillis = intent.getLongExtra(EXTRA_EVENT_BEGIN_TIME, 0);
                  mIntentEventEndMillis = intent.getLongExtra(EXTRA_EVENT_END_TIME, 0);
                  mIntentAttendeeResponse = intent.getIntExtra(ATTENDEE_STATUS, CalendarController.ATTENDEE_NO_RESPONSE);
                  timeMillis = mIntentEventStartMillis;
              }
           } catch (NumberFormatException e) {
              // Ignore if mViewEventId can't be parsed
           }
        }
    }
    return timeMillis;
}
