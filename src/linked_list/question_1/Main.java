package linked_list.question_1;

public class Main {
    public static void main(String[] args) {
        ReverseLinkedList rev = new ReverseLinkedList();

        rev.insertAtEnd(1);
        rev.insertAtEnd(2);
        rev.insertAtEnd(3);
        rev.insertAtEnd(4);
        rev.insertAtEnd(5);

        rev.printList();

        rev.reverse1();

        rev.printList();

        rev.head = rev.reverse2(rev.head);

        rev.printList();

        rev.reverse3(rev.head, null);

        rev.printList();

        rev.reverse4();

        rev.printList();
    }
}
