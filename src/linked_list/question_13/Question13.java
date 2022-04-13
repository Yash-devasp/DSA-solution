package linked_list.question_13;

public class Question13 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addAtEnd(10);
        ll.addAtEnd(2);
        ll.addAtEnd(44);
        ll.addAtEnd(4);
        ll.addAtEnd(8);
        ll.addAtEnd(1);

        ll.head = ll.mergeSort(ll.head);

        ll.printList();
    }
}
