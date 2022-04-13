package linked_list.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtTail(4);
        dll.insertAtHead(3);
        dll.insertAtHead(2);
        dll.insertAtHead(1);
        dll.insertAtAPosition(5, 4);
        dll.deleteAtPosition(2);
        dll.printList();
        dll.printListReverse();
    }
}
