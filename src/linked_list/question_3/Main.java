package linked_list.question_3;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Question3 sol = new Question3();

        sol.insertAtEnd(20);
        sol.insertAtEnd(4);
        sol.insertAtEnd(15);
        sol.insertAtEnd(10);

        sol.head.next.next.next.next = sol.head;

        if(sol.detectLoop3(sol.head)){
            System.out.println("loop found");
        }else{
            System.out.println("loop not found");
        }
    }

    // by changing the node value
}