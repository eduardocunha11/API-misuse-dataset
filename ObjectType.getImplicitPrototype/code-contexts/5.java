/**
 * Source: https://github.com/weitzj/closure-compiler/blob/master/test/com/google/javascript/jscomp/ConcreteTypeTest.java
 */
public StaticScope<ConcreteType> createInstanceScope(ObjectType instanceType) {
    FakeScope parentScope = null;
    if (instanceType.getImplicitPrototype() != null) {
        ConcreteInstanceType prototype = createConcreteInstance(instanceType.getImplicitPrototype());
        parentScope = (FakeScope) prototype.getScope();
    }
    FakeScope scope = new FakeScope(parentScope);
    for (String propName : instanceType.getOwnPropertyNames()) {
        scope.addSlot(propName);
    }
    return scope;
  }
}
