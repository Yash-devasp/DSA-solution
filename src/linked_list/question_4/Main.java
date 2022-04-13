package linked_list.question_4;

public class Main {
    public static void main(String[] args) {
        Question4 sol = new Question4();

        sol.insertAtEnd(20);
        sol.insertAtEnd(4);
        sol.insertAtEnd(15);
        sol.insertAtEnd(10);

        sol.head.next.next.next.next = sol.head;

        sol.remove3(sol.head);

        sol.printList();
    }
}
