/**
 * Source: https://github.com/0ffffffffh/jyald/blob/master/src/org/jyald/debuglog/Log.java
 */
private static String initLogBuffer(String format, Object...objects) {
    String finalLog;
    String currTime;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date date = new Date();
    currTime = dateFormat.format(date);
    if (objects != null)
       finalLog = String.format("%s : %s%s", currTime, String.format(format, objects), StringHelper.NEW_LINE);
    else
       finalLog = String.format("%s : %s%s", currTime, format, StringHelper.NEW_LINE);

    return finalLog;
}
