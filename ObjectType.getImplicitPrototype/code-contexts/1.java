/**
 * Source: https://github.com/Dandandan/wikiprogramming/blob/master/jsrepl/tools/closure-compiler/trunk/src/com/google/javascript/jscomp/AmbiguateProperties.java
 */
private void addRelatedInstance(FunctionType constructor, JSTypeBitSet related) {

  if (constructor.hasInstanceType()) {
      ObjectType instanceType = constructor.getInstanceType();
      related.set(getIntForType(instanceType.getImplicitPrototype()));
      computeRelatedTypes(instanceType);
      related.or(relatedBitsets.get(instanceType));
   }
}
