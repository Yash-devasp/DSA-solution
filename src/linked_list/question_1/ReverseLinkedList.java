package linked_list.question_1;

import java.util.Deque;
import java.util.Stack;
public class ReverseLinkedList {
    
    class Node{
        
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    ReverseLinkedList(){
        this.head = null;
        this.tail = null;
    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(this.head == null){
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
            ptr=ptr.next;
        }
        System.out.println();
    }

    Node reverse1(){
        if(this.head == null)
            return this.head;

        Node current = this.head;
        Node next = null;
        Node prev = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.head = prev;

        return this.head;
    }

    Node reverse2(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node rest = reverse2(head.next);
        head.next.next = head;

        head.next = null;

        return rest;
    }

    Node reverse3(Node curr,Node prev){
        if(this.head == null)
            return this.head;

        if(curr.next==null){
            this.head = curr;
            curr.next = prev;
            return this.head;
        }

        Node next1 = curr.next;
        curr.next = prev;
        reverse3(next1, curr);

        return this.head;
    }

    Node reverse4(){
        Stack<Node> s = new Stack<>();
        Node current = this.head;

        while(current.next!=null){
            s.push(current);
            current = current.next;
        }

        this.head = current;

        while(!s.isEmpty()){
            current.next = s.peek();
            s.pop();
            current = current.next;
        }

        current.next = null;
        return this.head;
    }
}
