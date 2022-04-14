package linked_list.question_20;

public class Question20 {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtEnd(1);
        dll.insertAtEnd(2);
        dll.insertAtEnd(3);
        dll.insertAtEnd(4);

        dll.printList();

        dll.reverse();

        dll.printList();
    }
}
