package linked_list.CircularLinkedList;

public class CircularLinkedList {
    
    Node tail;
    int length = 0;

    CircularLinkedList(){
        this.tail = null;
        this.length = 0;
    }

    void getLength(){
        System.out.println(this.length);
    }

    void printList(){
        Node ptr = this.tail.next;
        do{
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }while(ptr!=this.tail.next);
        System.out.println();
    }

    void insertAtHead(int data){
        Node newNode = new Node(data);
        if(this.tail == null){
            newNode.next = newNode;
            this.tail = newNode;
        }else{
            newNode.next = this.tail.next;
            this.tail.next = newNode;
        }
        this.length++;
    }

    void insertAtTail(int data){
        Node newNode = new Node(data);
        if(this.tail == null){
            newNode.next = newNode;
            this.tail = newNode;
        }else {
            newNode.next = this.tail.next;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
    }

    void insertAtPosition(int data,int pos){
        System.out.println(this.length);
        if(pos == 1){
            insertAtHead(data);
        }else if(pos > this.length){
            insertAtTail(data);
        }else {
            Node newNode = new Node(data);
            int count = 1;
            Node ptr = this.tail.next;
            while(count < pos - 1){
                ptr = ptr.next;
                count++;
            }
            newNode.next = ptr.next;
            ptr.next = newNode;
            this.length++;
        }
    }

    void deleteAtPosition(int pos){
        // check if the position is present
        if(pos > this.length){
            System.out.println("The position is not present in the list");
            return;
        }
        if(pos == 1){
            if(this.length == 1){
                this.tail = null;
            }else{
                Node delNode = this.tail.next;
                this.tail.next = delNode.next;
            }
        }else if(pos == this.length){
            Node ptr = this.tail.next;
            while(ptr.next!=this.tail){
                ptr = ptr.next;
            }
            ptr.next = this.tail.next;
            this.tail = ptr;
        }else{
            Node ptr = this.tail.next;
            int count = 1;
            while(count < pos-1){
                count++;
                ptr = ptr.next;
            }
            ptr.next = ptr.next.next;
        }
        this.length--;
    }
}
