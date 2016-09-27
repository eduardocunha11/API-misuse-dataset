/**
 * Source: https://github.com/h2oai/h2o-2/blob/master/src/main/java/water/api/LogView.java
 */
private String getOutputLogStem() {
    String pattern = "yyyyMMdd_hhmmss";
    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    String now = formatter.format(new Date());
    return "h2ologs_" + now;
}
