package linked_list.question_9;

public class Main {
    public static void main(String[] args) {
        Question9 sol = new Question9();

        sol.insertAtEnd(9);
        sol.insertAtEnd(9);
        sol.insertAtEnd(9);

        // sol.addOne1();

        // sol.head = sol.addOne2(sol.head);

        sol.head = sol.addOne3();

        sol.printList();
    }
}
