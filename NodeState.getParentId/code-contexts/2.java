/**
 * Source: https://github.com/nabils/jackrabbit/blob/master/jackrabbit-core/src/main/java/org/apache/jackrabbit/core/persistence/util/Serializer.java
 */
public static void serialize(NodeState state, OutputStream stream)
            throws Exception {
        DataOutputStream out = new DataOutputStream(stream);

        // primaryType
        out.writeUTF(state.getNodeTypeName().toString());
        // parentUUID
        if (state.getParentId() == null) {
            out.write(NULL_UUID_PLACEHOLDER_BYTES);
        } else {
            out.write(state.getParentId().getRawBytes());
        }
     
        // definitionId
        out.writeUTF("");
        // mixin types
        Collection<Name> c = state.getMixinTypeNames();
        out.writeInt(c.size()); // count
        for (Iterator<Name> iter = c.iterator(); iter.hasNext();) {
            out.writeUTF(iter.next().toString());   // name
        }
        // modCount
        out.writeShort(state.getModCount());
        // properties (names)
        c = state.getPropertyNames();
        out.writeInt(c.size()); // count
        for (Iterator<Name> iter = c.iterator(); iter.hasNext();) {
            Name propName = iter.next();
            out.writeUTF(propName.toString());   // name
        }
        // child nodes (list of name/uuid pairs)
        Collection<ChildNodeEntry> collChildren = state.getChildNodeEntries();
        out.writeInt(collChildren.size()); // count
        for (Iterator<ChildNodeEntry> iter = collChildren.iterator(); iter.hasNext();) {
            ChildNodeEntry entry = iter.next();
            out.writeUTF(entry.getName().toString());   // name
            out.write(entry.getId().getRawBytes());    // uuid
        }
}
