package linked_list.question_19;

public class Question19 {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.insertAtEnd(1);
        cll.insertAtEnd(2);
        cll.insertAtEnd(3);
        cll.insertAtEnd(4);
        cll.insertAtEnd(5);
        cll.insertAtEnd(6);

        cll.delete(4);

        cll.printList();
    }
}
