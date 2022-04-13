package linked_list.question_8;

public class Question8 {
    public class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    Question8(){
        this.head = null;
        this.tail = null;
    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(this.tail == null){
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    void printList(){
        Node ptr = this.head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    void moveToFirst(){
        Node last = head;
        Node secondLast = null;
        while(last.next!=null){
            secondLast = last;
            last = last.next;
        }
        secondLast.next = null;
        last.next = this.head;
        this.head = last;
    }
}
