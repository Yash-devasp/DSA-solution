package linked_list.CircularLinkedList;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtTail(1);
        cll.insertAtTail(2);
        cll.insertAtTail(3);
        cll.insertAtPosition(4, 1);
        cll.insertAtPosition(5, 5);
        cll.insertAtPosition(6, 3);

        cll.printList();

        cll.deleteAtPosition(1);
        cll.deleteAtPosition(5);
        cll.deleteAtPosition(2);

        cll.printList();
    }
}
