package algorithm.taiger;

import java.util.ArrayList;
import java.util.List;

public class RoyalRumble {

    Node root;

    List<String> resultList = new ArrayList<>();

    RoyalRumble() {
        root = null;
    }

    public static void main(String[] args) {
        RoyalRumble royalRumble = new RoyalRumble();
        String arr[] = {"Louis  IX", "Louis  XXXV", "Louis  XLIX", "Louis  XXIV", "Louis  XV", "Louis  XXXIX", "Louis  XIX"};

        royalRumble.getSortedList(arr);
    }

    void insert(String name) {
        root = insertRec(root, name);
    }

    Node insertRec(Node root, String name) {

        if (root == null) {
            root = new Node(name);
            return root;
        }

        if (lessThan(name, root.name))
            root.left = insertRec(root.left, name);
        else if (lessThan(root.name, name))
            root.right = insertRec(root.right, name);

        return root;
    }

    boolean lessThan(String a, String b) {
        String[] a1 = a.split("\\s{2}");
        String[] b1 = b.split("\\s{2}");
        int c;
        if ((c = a1[0].compareTo(b1[0])) < 0)
            return true;
        else if (c > 0)
            return false;
        else {
            String a11 = a1[1].replace("IX", "W").replace("L", "Y");
            String b11 = b1[1].replace("IX", "W").replace("L", "Y");
            return a11.compareTo(b11) < 0;
        }
    }

    void createResultList(Node root) {
        if (root != null) {
            createResultList(root.left);
            resultList.add(root.name);
            createResultList(root.right);
        }
    }

    void treeInsertion(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    void getSortedList(String arr[]) {
        treeInsertion(arr);
        createResultList(root);
        resultList.stream().forEach(item -> System.out.println(item));
    }

    class Node {
        String name;
        Node left, right;

        public Node(String item) {
            name = item;
            left = right = null;
        }
    }
}
