/**
 * Source: https://github.com/stevenlin07/gateway/blob/master/perfsrc/com/weibo/meyou/perf/client/codec/MeyouHttpDecoder.java
 */
public static IMeta mergeMeta(IMetaData<?, ?> metaData1, IMetaData<?, ?> metaData2) {

    Map<String, Object> map1 = ((Map<String, Object>) metaData1);
    Set<Entry<String, Object>> set1 = map1.entrySet();
    Map<String, Object> map2 = ((Map<String, Object>) metaData2);
    Set<Entry<String, Object>> set2 = map2.entrySet();

    
    Map<String, Object> rep = new HashMap<String, Object>();
    //loop to update common elements
    for (Entry<String, Object> entry1 : set1) {
        String key1 = entry1.getKey();
        if (map2.containsKey(key1)) {
            Object value1 = map1.get(key1);
            Object value2 = map2.get(key1);

            if (value1 instanceof Double) {
               if (Double.valueOf(value1.toString()).doubleValue() < Double.valueOf(value2.toString()).doubleValue()) {
                   rep.put(key1, value2);
               }
            } else if (value1 instanceof Integer) {
               if (Integer.valueOf(value1.toString()).intValue() < Integer.valueOf(value2.toString()).intValue()) {
                  rep.put(key1, value2);
               }
            } else if (value1 instanceof Long) {
               if (Long.valueOf(value1.toString()).longValue() < Long.valueOf(value2.toString()).longValue()) {
                  rep.put(key1, value2);
               }
            }

            //check boolean
            if (value1 instanceof Boolean) {
                 if (!Boolean.valueOf(value1.toString()) && Boolean.valueOf(value2.toString())) {
                    rep.put(key1, value2);
                 }
            }
        }
    }
    //remove all changed
    set1.removeAll(rep.entrySet());
    //add the updates
    set1.addAll(rep.entrySet());
    //perform a union / adds all elements missing from set1
    set1.addAll(set2);
    //return the original object with merges
    return metaData1;
}
