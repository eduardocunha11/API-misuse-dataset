/**
 * Source: https://github.com/1028tkd/Oekaki/blob/master/src/jp/co/oekaki/util/DataUtil.java
 */
public static String getSystemDate(){
    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
    return sd.format(new Date());
}
