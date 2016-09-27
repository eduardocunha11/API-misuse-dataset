/**
 * Source: https://github.com/Dandandan/wikiprogramming/blob/master/jsrepl/tools/closure-compiler/trunk/src/com/google/javascript/jscomp/CheckAccessControls.java
 */
private static boolean isPropertyDeclaredConstant(ObjectType objectType, String prop) {

  for (; objectType != null && objectType.hasReferenceName(); objectType = objectType.getImplicitPrototype()) 
  {
      JSDocInfo docInfo = objectType.getOwnPropertyJSDocInfo(prop);
      if (docInfo != null && docInfo.isConstant()) {
         return true;
      }
  }
  return false;
}
