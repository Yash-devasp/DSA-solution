package linked_list.question_24;

public class DoublyLinkedList {
    Node head;

    DoublyLinkedList(){
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
            newNode.prev = ptr;
            ptr.next = newNode; 
        }
    }

    // creating a circular list and moving the head node to the nth node
    void rotateByNnodes(int n){
        if(this.head == null || this.head.next==null)
            return;

        // finding the nth node
        Node ptr = this.head;
        int count = 0;
        while(count<n && ptr!=null){
            ptr = ptr.next;
            count++;
        }

        if(ptr == null)
            return;

        // finding the last node
        Node nthNode = ptr;

        while(ptr.next!=null){
            ptr = ptr.next;
        }

        // creating a circular doubly linked list
        ptr.next = this.head;

        this.head.prev = ptr;

        // move the head to nth node and breaking the circular loop
        this.head = nthNode.next;

        this.head.prev = null;
        nthNode.next = null;
    }

    void printList(){
        Node ptr = this.head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}
