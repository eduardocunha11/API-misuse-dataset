/**
 * Source: https://github.com/nabils/jackrabbit/blob/master/jackrabbit-core/src/test/java/org/apache/jackrabbit/core/CachingHierarchyManagerTest.java
 */
public void moveNode(NodeState child, NodeState newParent, String name)
                throws ItemStateException {

     NodeState oldParent = (NodeState) getItemState(child.getParentId());
     ChildNodeEntry cne = oldParent.getChildNodeEntry(child.getNodeId());
     if (cne == null) {
         throw new ItemStateException(child.getNodeId().toString());
     }
     oldParent.removeChildNodeEntry(cne.getName(), cne.getIndex());
     child.setParentId(newParent.getNodeId());
     newParent.addChildNodeEntry(toName(name), child.getNodeId());
}
