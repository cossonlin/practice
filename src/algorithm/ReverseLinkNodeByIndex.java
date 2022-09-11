package algorithm;

public class ReverseLinkNodeByIndex {

    static class Node {

        int value;
        Node next = null;

        Node(int value) {
            this.value = value;
        }
    }

    private static void printList(Node node) {
        while (node.next != null) {
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.print(node.value);
    }

    public static void main(String[] args) {
        Node head = init();
        Node node = reverseLinkWithIndex(head, 0, 3);
        printList(node);
    }

    private static Node reverseLinkWithIndex(Node head, int begin, int end) {
        if (begin == 0) {
            return reverseLinkFromBeginToEndIndex(head, end);
        }
        boolean findBeginNode = false;
        Node cur = head;
        Node beginNode = null;
        Node prevBeginNode = null;
        for (int i = 0; i < end; i++) {
            if (i == begin) {
                beginNode = cur;
                findBeginNode = true;
            } else if (!findBeginNode) {
                prevBeginNode = cur;
            }
            cur = cur.next;
        }
        Node prev = cur.next;
        Node next;
        // 2 -> 3 -> 4 => 4 -> 3 -> 2
        for (int i = 0; i <= end - begin; i++) {
            next = beginNode.next;
            beginNode.next = prev;
            prev = beginNode;
            beginNode = next;
        }
        prevBeginNode.next = cur;
        return head;
    }

    private static Node reverseLinkFromBeginToEndIndex(Node head, int end) {
        Node cur = head;
        Node prev = null;
        Node next;
        // 1 -> 2 -> 3 => 3 -> 2 -> 1
        for (int i = 0; i <= end; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = cur;
        return prev;
    }

    private static Node init() {
        Node node1 = new ReverseLinkNodeByIndex.Node(1);
        Node node2 = new ReverseLinkNodeByIndex.Node(2);
        Node node3 = new ReverseLinkNodeByIndex.Node(3);
        Node node4 = new ReverseLinkNodeByIndex.Node(4);
        Node node5 = new ReverseLinkNodeByIndex.Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }
}
