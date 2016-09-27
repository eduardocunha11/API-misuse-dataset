/**
 * Source: https://github.com/weitzj/closure-compiler/blob/master/test/com/google/javascript/jscomp/TypedScopeCreatorTest.java
 */
public void testAddMethodsPrototypeTwoWays() throws Exception {

  testSame("/** @constructor */function A() {}" +
    "A.prototype = {m1: 5, m2: true};" +
    "A.prototype.m3 = 'third property!';" +
    "var x = new A();");

    ObjectType instanceType = (ObjectType) findNameType("x", globalScope);
    assertEquals(getNativeObjectType(OBJECT_TYPE).getPropertiesCount() + 3, instanceType.getPropertiesCount());
        
    Asserts.assertTypeEquals(getNativeType(NUMBER_TYPE),
    instanceType.getPropertyType("m1"));
    Asserts.assertTypeEquals(getNativeType(BOOLEAN_TYPE),
    instanceType.getPropertyType("m2"));
    Asserts.assertTypeEquals(getNativeType(STRING_TYPE),
    instanceType.getPropertyType("m3"));
    // Verify the prototype chain.
    // This is a special case where we want the anonymous object to
    // become a prototype.
    assertFalse(instanceType.hasOwnProperty("m1"));
    assertFalse(instanceType.hasOwnProperty("m2"));
    assertFalse(instanceType.hasOwnProperty("m3"));
    ObjectType proto1 = instanceType.getImplicitPrototype();
    assertTrue(proto1.hasOwnProperty("m1"));
    assertTrue(proto1.hasOwnProperty("m2"));
    assertTrue(proto1.hasOwnProperty("m3"));
    ObjectType proto2 = proto1.getImplicitPrototype();
    assertFalse(proto2.hasProperty("m1"));
    assertFalse(proto2.hasProperty("m2"));
    assertFalse(proto2.hasProperty("m3"));
}
