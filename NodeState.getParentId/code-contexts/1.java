/**
 * Source: https://github.com/nabils/jackrabbit/blob/master/jackrabbit-core/src/main/java/org/apache/jackrabbit/core/observation/EventStateCollection.java
 */
public void createEventStates(NodeId rootNodeId, ChangeLog changes, ItemStateManager stateMgr) throws ItemStateException {
        
        ChangeLogBasedHierarchyMgr hmgr = new ChangeLogBasedHierarchyMgr(rootNodeId, stateMgr, changes);

        for (ItemState state : changes.modifiedStates()) {
            if (state.isNode()) {
                NodeState n = (NodeState) state;
                if (n.hasOverlayedState()) {
                    NodeId oldParentId = n.getOverlayedState().getParentId();
                    NodeId newParentId = n.getParentId();
                    if (newParentId != null && !oldParentId.equals(newParentId) && !n.isShareable()) 
                    {
                        Path oldPath = getZombiePath(n.getNodeId(), hmgr);
                        NodeState oldParent;
                        try {
                            oldParent = (NodeState) changes.get(oldParentId);
                        } catch (NoSuchItemStateException e) { 
                            oldParent = (NodeState) stateMgr.getItemState(oldParentId);
                        }
                        
                    } else {
                        NodeState parent = null;
                        try {
                            if (state.getParentId() != null) {
                                parent = (NodeState) changes.get(state.getParentId());
                            }
                        } catch (NoSuchItemStateException e) {
                            String msg = "Parent of node " + state.getId() + " is deleted.";
                            log.error(msg);
                            throw new ItemStateException(msg, e);
                        }
                   }
                }
             }     
        }
    }
