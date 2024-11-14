package gfg.problemoftheday;

public class Intersect {

    public static void main(String[] args) {

        LinkedList linkedList1 = new LinkedList();
        linkedList1.head = new Node(4);
        linkedList1.head.next = new Node(1);
        linkedList1.head.next.next = new Node(8);
        linkedList1.head.next.next.next = new Node(4);
        linkedList1.head.next.next.next.next = new Node(5);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.head = new Node(5);
        linkedList2.head.next = new Node(6);
        linkedList2.head.next.next = new Node(1);
        linkedList2.head.next.next.next = linkedList1.head.next.next;
        linkedList2.head.next.next.next.next = linkedList1.head.next.next.next;
        linkedList2.head.next.next.next.next.next = linkedList1.head.next.next.next.next;

        int result = intersectPoint(linkedList1.head, linkedList2.head);
        System.out.println("Intersection Point: " + result);
    }

    // Function to find intersection point in Y shaped Linked Lists.
    private static int intersectPoint(Node head1, Node head2) {

        int length1 = length(head1);
        int length2 = length(head2);
        int diff;

        if (length1 > length2) {
            diff = length1 - length2;
            for (int i = 0; i < diff; i++) {
                head1 = head1.next;
            }
        } else {
            diff = length2 - length1;
            for (int i = 0; i < diff; i++) {
                head2 = head2.next;
            }
        }

        while (head1 != null) {
            if (head1 == head2) {
                return head1.data;
            }
            head1 = head1.next;
            head2 = head2.next;

        }
        return -1;

    }

    private static int length(Node head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count++;
    }
}

// Node of a linked list
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

// Linked List class
class LinkedList {
    Node head;  // head of list
}