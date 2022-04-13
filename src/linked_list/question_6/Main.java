package linked_list.question_6;

public class Main {
    public static void main(String[] args) {
        Question6 sol = new Question6();

        sol.insertAtEnd(2);
        sol.insertAtEnd(2);
        sol.insertAtEnd(5);
        sol.insertAtEnd(5);
        sol.insertAtEnd(5);
        sol.insertAtEnd(20);

        // sol.removeDuplicates1();

        // sol.head = sol.removeDuplicates2(sol.head);

        // sol.removeDuplicates3();

        sol.removeDuplicates4();

        sol.printList();
    }
}
