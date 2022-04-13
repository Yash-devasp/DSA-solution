package linked_list.question_5;

public class Main {
    public static void main(String[] args) {
        Question5 sol = new Question5();

        sol.insertAtEnd(20);
        sol.insertAtEnd(4);
        sol.insertAtEnd(15);
        sol.insertAtEnd(10);

        sol.head.next.next.next.next = sol.head;

        System.out.println(sol.firstNode2(sol.head).data);
    }
}
