/**
 * Source: https://github.com/0827moon/Adaptive-Crawler/blob/master/AdaptiveCrawler_Correlation/src/crawler/DataStorage.java
 */
private static void sqlStore(Status status) throws SQLException{
    long sql_pid = Settings.pid;
    Settings.pid++;
    SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss, z");
    String sqlCreateAt = tempDate.format(new java.util.Date(status.getCreatedAt().getTime()));
    double sqlGeoLocationLat = 0;
    double sqlGeoLocationLong = 0;
    
    if (status.getGeoLocation()!=null) {
        sqlGeoLocationLat = status.getGeoLocation().getLatitude();
        sqlGeoLocationLong = status.getGeoLocation().getLongitude();
    }
    String sqlPlace = (status.getPlace()!= null ? status.getPlace().getFullName(): "");
    long sqlId = status.getId();
    String sqlTweet = status.getText().replace("'", "''");
    String sqlSource = status.getSource().replace("'", "''");
    sqlSource = sqlSource.replace("\\","\\\\");
    String sqlLang = status.getUser().getLang();
    String sqlScreenName = status.getUser().getScreenName();
    String sqlReplyTo = status.getInReplyToScreenName();
    long sqlRtCount = status.getRetweetCount();
    HashtagEntity[] hashs = status.getHashtagEntities();
    String sqlHashtags = "";
    for (HashtagEntity hash: hashs) sqlHashtags+=hash.getText()+" ";
    pstm.setLong(1, sql_pid);
    pstm.setString(2, sqlCreateAt);
    pstm.setDouble(3, sqlGeoLocationLat);
    pstm.setDouble(4, sqlGeoLocationLong);
    pstm.setString(5, sqlPlace);
    pstm.setLong(6, sqlId);
    pstm.setString(7, sqlTweet);
    pstm.setString(8, sqlSource);
    pstm.setString(9, sqlLang);
    pstm.setString(10, sqlScreenName);
    pstm.setString(11, sqlReplyTo);
    pstm.setLong(12, sqlRtCount);
    pstm.setString(13, sqlHashtags);
    pstm.addBatch();
}
