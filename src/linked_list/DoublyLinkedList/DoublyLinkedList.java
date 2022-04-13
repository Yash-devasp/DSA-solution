package linked_list.DoublyLinkedList;

public class DoublyLinkedList {

    Node head;
    Node tail;
    int length;
    
    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    void insertAtHead(int data){
        Node newNode = new Node(data);
        newNode.next = this.head;
        if(tail==null){
            this.tail = newNode;
        }else{
            this.head.prev = newNode;
        }
        this.head = newNode;
        this.length++;
    }

    void insertAtTail(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
        }else{
            this.tail.next = newNode;
            newNode.prev = this.tail;
        }
        this.tail = newNode;
        this.length++;
    }

    void insertAtAPosition(int data,int pos){
        if(pos == 1){
            insertAtHead(data);
        }else if(pos > this.length){
            insertAtTail(data);
        }else{
            Node newNode = new Node(data);
            Node ptr = this.head;
            int count = 1;
            while(count < pos - 1){
                ptr = ptr.next;
                count++;
            }
            newNode.next = ptr.next;
            newNode.prev = ptr;
            ptr.next.prev = newNode;
            ptr.next = newNode;
            this.length++;
        }
    }

    void deleteAtPosition(int pos){
        // check if the position exists
        if(pos > this.length){
            System.out.println("No node at this position");
            return;
        }
        
        // deletion at the head node
        if(pos == 1){
            this.head = this.head.next;
            if(head!=null){
                head.prev = null;
            }else{
                this.tail = null;
            }
        }else if(pos == this.length){
            this.tail = this.tail.prev;
            this.tail.next = null;
        }else{
            Node ptr = this.head;
            int count = 1;
            while(count < pos-1){
                ptr = ptr.next;
                count++;
            }
            Node delNode = ptr.next;
            ptr.next = delNode.next;
            delNode.next.prev = ptr;
            delNode.next = null;
            delNode.prev = null;
        }
        this.length--;
    }

    void getLength(){
        System.out.println(this.length);
    }

    void printList(){
        Node ptr = this.head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    void printListReverse(){
        Node ptr = this.tail;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.prev;
        }
        System.out.println();
    }
}
