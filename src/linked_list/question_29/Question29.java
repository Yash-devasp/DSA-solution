package linked_list.question_29;

public class Question29 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insertAtHead(0);
        ll.insertAtHead(1);
        ll.insertAtHead(0);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        ll.insertAtHead(1);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        ll.insertAtHead(2);

        // ll.sort012();
        ll.sortList();

        ll.printList();
    }
}
