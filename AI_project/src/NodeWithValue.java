public class NodeWithValue {
    private Node node;
    private int value;
    
    public NodeWithValue(Node node, int value) {
        this.node = node;
        this.value = value;
    }
    
    public Node getNode() {
        return node;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }


}
