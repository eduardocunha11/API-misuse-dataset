/**
 * Source: https://github.com/nabils/jackrabbit/blob/master/jackrabbit-core/src/main/java/org/apache/jackrabbit/core/query/lucene/AggregateRuleImpl.java
 */
NodeState matches(NodeState nodeState) throws ItemStateException, RepositoryException {
            
            if (nodeTypeName == null || nodeState.getNodeTypeName().equals(nodeTypeName)) {
           
                Path.Element[] elements = pattern.getElements();
                for (int e = elements.length - 1; e >= 0; e--) {
                    NodeId parentId = nodeState.getParentId();
                    if (parentId == null) {
                        return null;
                    }
                    NodeState parent = (NodeState) ism.getItemState(parentId);
                    if (elements[e].getName().getLocalName().equals("*")) {
                        // match any parent
                        nodeState = parent;
                    } else {
                        // check name
                        Name name = hmgr.getName(nodeState.getId());
                        if (elements[e].getName().equals(name)) {
                            nodeState = parent;
                        } else {
                            return null;
                        }
                    }
                }
                return nodeState;
            }
            return null;
        }
