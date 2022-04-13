package linked_list.question_2;

public class Main {
    public static void main(String[] args) {
        ReverseLLGroup rllg = new ReverseLLGroup();

        rllg.insertAtEnd(1);
        rllg.insertAtEnd(2);
        rllg.insertAtEnd(3);
        rllg.insertAtEnd(4);
        rllg.insertAtEnd(5);

        rllg.printList();

        rllg.head = rllg.reverse1(rllg.head, 2);

        rllg.printList();

        rllg.head = rllg.reverse2(rllg.head, 2);

        rllg.printList();
    }
}
