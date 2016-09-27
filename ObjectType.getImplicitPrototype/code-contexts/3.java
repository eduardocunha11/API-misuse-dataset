/**
 * Source: https://github.com/Dandandan/wikiprogramming/blob/master/jsrepl/tools/closure-compiler/trunk/src/com/google/javascript/jscomp/TypeValidator.java
 */
void expectSuperType(NodeTraversal t, Node n, ObjectType superObject, ObjectType subObject) {

  FunctionType subCtor = subObject.getConstructor();
  ObjectType declaredSuper = subObject.getImplicitPrototype().getImplicitPrototype();
  
    if (!declaredSuper.equals(superObject)) {
      if (declaredSuper.equals(getNativeType(OBJECT_TYPE))) {
          registerMismatch(superObject, declaredSuper, report(
          t.makeError(n, MISSING_EXTENDS_TAG_WARNING, subObject.toString())));
       } else {
          mismatch(t.getSourceName(), n, "mismatch in declaration of superclass type", superObject, declaredSuper);
       }
       // Correct the super type.
       if (!subCtor.hasCachedValues()) {
          subCtor.setPrototypeBasedOn(superObject);
       }
    }
}
