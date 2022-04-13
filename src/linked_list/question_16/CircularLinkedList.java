package linked_list.question_16;

public class CircularLinkedList {
    Node head;

    CircularLinkedList(){
        this.head = null;
    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
            newNode.next = this.head;
        }else{
            Node ptr = this.head;
            while(ptr.next!=this.head){
                ptr = ptr.next;
            }

            ptr.next = newNode;
            newNode.next = this.head;
        }
    }
}
