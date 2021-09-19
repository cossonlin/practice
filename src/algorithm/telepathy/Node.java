package algorithm.telepathy;

import java.util.Arrays;

public class Node {
    static Node rootNode;

    //Initializer block before main, set your ReentrantLockTest data here
    static {
        rootNode = new Node("root");
        Node son1 = new Node("son1");
        Node son2 = new Node("son2");
        Node son3 = new Node("son3");
        Node grandson1 = new Node("grandson1");
        Node grandson2 = new Node("grandson2");
        Node grandson3 = new Node("grandson3");

        rootNode.Children = new Node[]{son1, son2, son3};
        son1.Children = new Node[]{grandson1, grandson2};
        son3.Children = new Node[]{grandson3};
    }

    Node[] Children;
    Node Right;
    String name;

    Node(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Node node = rootNode;
        while (node != null) {
            Node firstChild = null;
            Node last = null;
            //Set Right property for the same generation and find whether they have child
            while (node != null) {
                if (node.Children != null && node.Children.length > 0) {
                    if (firstChild == null) {
                        firstChild = node.Children[0];
                    }
                    for (int i = 0; i < node.Children.length - 1; i++) {
                        node.Children[i].Right = node.Children[i + 1];
                    }
                    if (last != null) {
                        last.Right = node.Children[0];
                    }
                    last = node.Children[node.Children.length - 1];
                }
                //Move to its right sibling
                node = node.Right;
            }
            //Select the first child at next generation and repeat
            node = firstChild;
        }
        //Not require to print the tree.
        //Can either set breakpoint at line 56 and check data structure of rootNode
        //or optimize the toString method to print out
        System.out.println(rootNode);
    }

    @Override
    public String toString() {
        return "telepathy.Node{" +
                "name='" + name + '\'' +
                ", Right=" + Right +
                ", Children=" + Arrays.toString(Children) +
                '}';
    }
}
