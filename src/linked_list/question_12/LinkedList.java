package linked_list.question_12;

public class LinkedList {
    Node head;

    LinkedList(){
        this.head = null;
    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
        }else{
            Node ptr = this.head;
            while(ptr.next!=null){
                ptr = ptr.next;
            }
            ptr.next = newNode;
        }
    }
}
