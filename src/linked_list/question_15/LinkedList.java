package linked_list.question_15;

public class LinkedList {
    
    Node head;
    Node end;

    LinkedList(){
        this.head = null;
        this.end = null;
    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(this.end == null){
            this.head = newNode;
            this.end = newNode;
        }else{
            this.end.next = newNode;
            this.end = newNode;
        }
    }

    Node middleNode(){
        Node slow_ptr = this.head;
        Node fast_ptr = this.head;

        while(fast_ptr!=null && fast_ptr.next!=null){
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }

        return slow_ptr;
    }
}
