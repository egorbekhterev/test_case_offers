package leetcode;

/**
 * @author: Egor Bekhterev
 * @date: 27.04.2023
 * @project: test_cases_offers
 */
public class CircularLinkedList {

    private static class Node {

        Node next;

        String value;

        Node head;

        public Node(String value) {
            this.value = value;
        }

        public Node(Node next, Node head) {
            this.next = next;
            this.head = head;
        }
    }

    private Node last;

    public void add(String value) {

        if (last == null) {
            setFirst(value);
        } else {
            addNew(value);
        }
    }

    private void setFirst(String value) {
        var firstNode = new Node(value);
        last = firstNode;
        last.head = firstNode;
    }

    private void addNew(String value) {
        var newNode = new Node(value);
        last.next = newNode;
        newNode.head = last.head;
        last.head = null;
        last = newNode;
    }
}
