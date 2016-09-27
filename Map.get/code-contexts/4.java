/**
 * Source: https://github.com/phil-rice/softwareFmUtilities/blob/master/src/main/java/org/softwarefm/utilities/maps/Maps.java
 */
public static <K, V, ColV extends Collection<V>> void addToCollection(Map<K, ColV> map, Class colClass, K key, V value) {
   try {
     ColV existing = map.get(key);
     if (existing == null) {
        existing = (ColV) colClass.getConstructor().newInstance();
        map.put(key, existing);
     }
     existing.add(value);
   } catch (Exception e) {
     throw WrappedException.wrap(e);
   }
}
