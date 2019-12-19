package algorithm;

import java.util.ArrayList;
import java.util.List;

public class ALinkedList {

    static Node head;

    static class Node {
        int value;
        Node next = null;
        Node(int value){
            this.value = value;
        }
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.print("End");
    }

    Node reverseList(Node node) {
        Node prep = null;
        Node current = node;
        Node next;

        while (current!=null){
            next = current.next;
            current.next = prep;
            prep = current;
            current = next;
        }

        return prep;
    }

    public static void main(String[] agrs) {
        ALinkedList list = new ALinkedList();
        List a = new ArrayList();
        list.head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        System.out.println("Before reverse");
        list.printList(head);

        head = list.reverseList(head);
        System.out.println("\nAfter reverse");
        list.printList(head);
    }
}
