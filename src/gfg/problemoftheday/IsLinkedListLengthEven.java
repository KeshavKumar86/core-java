package gfg.problemoftheday;

class IsLinkedListLengthEven {
    public boolean isLengthEven(Node head) {
        // code here
        while (head != null && head.next != null) {
            head = head.next.next;
        }
        return head == null;
    }
}
