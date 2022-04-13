package linked_list.SinglyLinkedList;

public class LinkedList {

    Node head;
    Node tail;
    int length;

    LinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    int getLength(){
        return this.length;
    }

    void insertAtHead(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.tail = newNode;
        }
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }

    void printList(){
        Node ptr = this.head;

        while(ptr != null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    void insertAtTail(int data){
        Node newNode = new Node(data);
        if (this.tail != null) {
            this.tail.next = newNode;
        }else{
            this.head = newNode;
        }
        this.tail = newNode;
        this.length++;
    }

    void insertAtPosition(int data,int pos){
        if(pos == 1){
            insertAtHead(data);
            return;
        }
        if(pos > this.length){
            insertAtTail(data);
            return;
        }
        int count = 1;
        Node ptr = this.head;
        while(count < pos-1){
            ptr = ptr.next;
            count++;
        }

        Node newNode = new Node(data);
        newNode.next = ptr.next;
        ptr.next = newNode;
        
        this.length++;
    }

    void deleteAtPosition(int pos){

        if(pos == 1){
            this.head = this.head.next;
            if(this.length == 1){
                this.tail = null;
            }
            return;
        }else{

            int count = 1;

            Node prev = this.head;
            while(count < pos-1){
                prev = prev.next;
                count++;
            }

            if(pos == this.length){
                this.tail = prev;
            }

            prev.next = prev.next.next;

        }
        this.length--;
    }
}