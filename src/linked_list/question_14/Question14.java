package linked_list.question_14;

public class Question14 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insertAtEnd(30);
        ll.insertAtEnd(2);
        ll.insertAtEnd(29);
        ll.insertAtEnd(10);
        ll.insertAtEnd(1);
        ll.insertAtEnd(0);

        Node ptr = ll.head;
        while(ptr.next!=null){
            ptr =ptr.next;
        }

        ll.sort(ll.head, ptr);

        ll.printList();
    }
}
