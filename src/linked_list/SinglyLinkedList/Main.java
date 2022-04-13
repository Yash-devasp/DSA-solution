package linked_list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtHead(5);
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtHead(4);
        list.insertAtPosition(6, 3);
        list.deleteAtPosition(3);
        list.deleteAtPosition(1);
        list.deleteAtPosition(4);
        list.printList();
    }
}
