package linked_list.question_8;

public class Main {
    public static void main(String[] args) {
        Question8 sol = new Question8();

        sol.insertAtEnd(2);
        sol.insertAtEnd(20);
        sol.insertAtEnd(5);
        sol.insertAtEnd(5);
        sol.insertAtEnd(2);
        sol.insertAtEnd(5);
        

        sol.moveToFirst();

        sol.printList();
    }
}
