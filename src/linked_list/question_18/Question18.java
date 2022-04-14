package linked_list.question_18;

public class Question18 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(3);
        ll.insertAtEnd(2);
        ll.insertAtEnd(0);

        if(ll.checkPalindrome3()){
            System.out.println("Palindrome!!!");
        }else{
            System.out.println("Not Palindrome!!!");
        }

    }
}
