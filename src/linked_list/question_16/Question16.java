package linked_list.question_16;

public class Question16 {

    static boolean checkCircular(Node node){
        if(node == null)
            return true;

        Node ptr = node.next;
        while(ptr!=null && ptr!=node){
            ptr = ptr.next;
        }
        return (ptr == node);
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        CircularLinkedList cll = new CircularLinkedList();

        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);

        cll.insertAtEnd(1);
        cll.insertAtEnd(2);
        cll.insertAtEnd(3);
        cll.insertAtEnd(4);

        if(checkCircular(ll.head)){
            System.out.println("Circular linked list");
        }else{
            System.out.println("linked list");
        }

        if(checkCircular(cll.head)){
            System.out.println("Circular linked list");
        }else{
            System.out.println("linked list");
        }
    }
}
