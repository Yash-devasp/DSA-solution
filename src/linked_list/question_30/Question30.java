package linked_list.question_30;

public class Question30 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.head = new Node(1);
        ll.head.next = new Node(2);
        ll.head.next.next = new Node(3);
        ll.head.next.next.next = new Node(4);
        ll.head.next.next.next.next = new Node(5);

        ll.head.random = ll.head.next.next;
        ll.head.next.random = ll.head;

        ll.head.next.next.random = ll.head.next.next.next.next;
        ll.head.next.next.next.random = ll.head.next.next.next.next;

        ll.head.next.next.next.next.random = ll.head.next;

        ll.print(ll.head);

        Node clonedList = ll.cloneLinkedList3();

        ll.print(clonedList);
    }
}
