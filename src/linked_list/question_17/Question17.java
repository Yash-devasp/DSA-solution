package linked_list.question_17;

public class Question17 {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.insertAtEnd(1);
        cll.insertAtEnd(2);
        cll.insertAtEnd(3);
        cll.insertAtEnd(4);

        cll.printList(cll.head);

        cll.splitTheList();

        cll.printList(cll.head1);
        cll.printList(cll.head2);
    }
}
