package linked_list.question_20;

import java.util.Stack;

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

    void printList(){
        Node ptr = this.head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    void reverse(){
        Node curr = this.head;
        Node temp = null;

        while(curr!=null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        if(temp!=null){
            this.head = temp.prev;
        }
    }

    void reverse1(){
        Stack<Integer> s = new Stack<>();
        Node ptr = this.head;

        while(ptr!=null){
            s.push(ptr.data);
            ptr = ptr.next;
        }

        ptr = this.head;
        while(ptr!=null){
            ptr.data = s.pop();
            ptr = ptr.next;
        }
    }
}
