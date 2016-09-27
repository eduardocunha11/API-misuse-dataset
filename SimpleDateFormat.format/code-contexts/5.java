/**
 * Source: https://github.com/18301551026/oa/blob/master/oa-core/src/main/java/com/lxs/core/common/TimeUtil.java
 */
public String getNextMonthFirst() {
    String str = "";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar lastDate = Calendar.getInstance();
    lastDate.add(Calendar.MONTH, 1);
    lastDate.set(Calendar.DATE, 1);
    str = sdf.format(lastDate.getTime());
    
    return str;
}
