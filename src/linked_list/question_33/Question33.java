package linked_list.question_33;

public class Question33 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insertAtEnd(12);
        ll.insertAtEnd(15);
        ll.insertAtEnd(10);
        ll.insertAtEnd(11);
        ll.insertAtEnd(5);
        ll.insertAtEnd(6);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.print();

        ll.compute2();

        ll.print();
    }
}
