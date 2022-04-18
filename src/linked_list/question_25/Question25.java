package linked_list.question_25;

public class Question25 {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtEnd(1);
        dll.insertAtEnd(2);
        dll.insertAtEnd(3);
        dll.insertAtEnd(4);
        dll.insertAtEnd(5);
        dll.insertAtEnd(6);
        dll.insertAtEnd(7);
        dll.insertAtEnd(8);

        // dll.head = dll.revListInGroupOfGivenSize(3);
        dll.head = dll.reverseByN(dll.head, 3);

        dll.printList();
    }
}
