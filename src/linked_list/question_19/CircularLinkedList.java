package linked_list.question_19;

public class CircularLinkedList {
    Node head;

    CircularLinkedList(){
        this.head = null;
    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            newNode.next = newNode;
            this.head = newNode;
        }else{
            Node ptr = this.head;
            while(ptr.next!=this.head){
                ptr = ptr.next;
            }
            newNode.next = this.head;
            ptr.next = newNode;
        }
    }

    void printList(){
        Node ptr = this.head;
        if(this.head==null)
            return;
        do{
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }while(ptr!=this.head);
        System.out.println();
    }

    void delete(int key){
        if(this.head == null)
            return;

        if(this.head.data == key){
            if(this.head.next == this.head){
                this.head = null;
            }else{
                Node ptr = this.head;
                while(ptr.next!=this.head){
                    ptr = ptr.next;
                }
                ptr.next = this.head.next;
                this.head = this.head.next;
            }
        }else{
            Node prev = this.head;
            Node current = this.head.next;
            while(current!=head && current.data!=key){
                prev = current;
                current = current.next;
            }
            if(current == head)
                return;
            prev.next = current.next;
        }
    }
}
