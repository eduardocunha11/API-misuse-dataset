/**
 * Source: https://github.com/vvasabi/d3-profile-viewer/blob/master/src/main/java/com/bc/d3/web/UTF8ResourceBundleFactory.java
 */
private UTF8ResourceBundle findCachedResourceBundle(String name, Locale locale) {

  if (!resourceBundles.containsKey(name)) {
     return null;
  }

  if (!resourceBundles.get(name).containsKey(locale)) {
     return null;
  }
  
  return resourceBundles.get(name).get(locale);
}
