package linked_list.question_32;

public class LinkedList {
    Node head;

    LinkedList(){
        head = null;
    }

    long multiply(Node ll1,Node ll2){
        long num1 = 0,num2 = 0,N = 1000000007;

        Node ptr1 = ll1;
        Node ptr2 = ll2;
        while(ptr1!=null || ptr2!=null){
            if(ptr1!=null){
                num1 = (num1*10)%N + ptr1.data;
                ptr1 = ptr1.next;
            }
            if(ptr2!=null){
                num2 = (num2*10)%N + ptr2.data;
                ptr2 = ptr2.next;
            }
        }

        return (num1%N * num2%N)%N;
    }
}
