package algorithm;

class Node {
    private Node leftChild, rightChild;

    public Node(Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public int height() {
        int height = 0;
        if(getLeftChild()==null && getRightChild()==null){
            return 0;
        } else if (getLeftChild()!=null && getRightChild()==null) {
            return getLeftChild().height() + 1;
        } else if (getLeftChild()==null && getRightChild()!=null) {
            return getRightChild().height() + 1;
        } else {
            return Math.max(getLeftChild().height(), getRightChild().height()) +1;
        }
    }

    public static void main(String[] args) {
        Node leaf1 = new Node(null, null);
        Node leaf2 = new Node(null, null);
        Node node = new Node(leaf1, null);
        Node root = new Node(node, leaf2);

        System.out.println(root.height());
    }
}