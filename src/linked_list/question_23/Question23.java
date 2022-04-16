package linked_list.question_23;

public class Question23 {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtEnd(1);
        dll.insertAtEnd(4);
        dll.insertAtEnd(2);
        dll.insertAtEnd(6);
        dll.insertAtEnd(7);
        dll.insertAtEnd(8);
        dll.insertAtEnd(5);
        dll.insertAtEnd(10);

        dll.sortKSortedList(dll.head, 2);
    }
}
