package linked_list.question_17;

public class CircularLinkedList {

    Node head;
    Node head1;
    Node head2;

    CircularLinkedList(){
        this.head = null;
        this.head1 = null;
        this.head2 = null;
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
            newNode.next = this.head;
            ptr.next = newNode;
        }
    }

    void printList(Node node){
        System.out.print(node.data+" ");
        Node ptr = node.next;
        while(ptr!=node){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    void splitTheList(){
        // check if list is empty
        if(this.head == null)
            return;

        Node slow_ptr = this.head;
        Node fast_ptr = this.head;

        while(fast_ptr.next!=this.head && fast_ptr.next.next!=this.head){
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }

        // move to the last node
        if(fast_ptr.next.next==this.head){
            fast_ptr = fast_ptr.next;
        }

        head1 = head;

        // check the case for a single node in the linked list
        if(this.head.next != this.head){
            head2 = slow_ptr.next;
        }

        fast_ptr.next = slow_ptr.next;
        slow_ptr.next = head;
    }
}
