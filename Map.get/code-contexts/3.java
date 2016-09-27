/**
 * Source: https://github.com/raymondBourges/esup-commons-import/blob/master/esup-commons/esup-commons-exceptionHandling/src/main/java/org/esupportail/commons/web/controllers/ExceptionController.java
 */

public String restart() {
    Map<String, Object> resettables = BeanUtils.getBeansOfClass(Resettable.class);
    for (String name : resettables.keySet()) {
      if (logger.isDebugEnabled()) {
         logger.debug("trying to reset bean [" + name + "]...");
      }
      
      Object bean = resettables.get(name);
      if (bean == null) {
         throw new ConfigException("bean [" + name + "] is null, " + "application can not be restarted.");
      }

      if (!(bean instanceof Resettable)) {
         throw new ConfigException("bean [" + name + "] does not implement Resettable, " + "application can not be restarted.");
      }
      ((Resettable) bean).reset();
      if (logger.isDebugEnabled()) {
         logger.debug("bean [" + name + "] was reset.");
      }
  }
  ExceptionUtils.unmarkExceptionCaught();
  return "applicationRestarted";
}
