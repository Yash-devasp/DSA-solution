package linked_list.question_10;

public class Main {
    public static void main(String[] args) {
        Question10 ll1 = new Question10();
        Question10 ll2 = new Question10();

        ll1.insertAtTail(1);
        ll1.insertAtTail(2);
        ll1.insertAtTail(3);

        ll2.insertAtTail(7);
        ll2.insertAtTail(8);
        ll2.insertAtTail(9);

        ll1.printList(ll1.addList(ll2.head));
    }
}
