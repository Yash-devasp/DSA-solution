package linked_list.question_7;

public class Main {
    public static void main(String[] args) {
        Question7 sol = new Question7();

        sol.insertAtEnd(2);
        sol.insertAtEnd(20);
        sol.insertAtEnd(5);
        sol.insertAtEnd(5);
        sol.insertAtEnd(2);
        sol.insertAtEnd(5);
        

        // sol.removeDuplicates1();

        sol.removeDuplicates2();

        sol.printList();
    }
}
