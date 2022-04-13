package linked_list.question_2;

import java.util.Stack;

public class ReverseLLGroup {

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
    ReverseLLGroup(){
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
            ptr = ptr.next;
        }
        System.out.println();
    }

    Node reverse1(Node head,int k){
        if(head == null){
            return head;
        }

        Node current = head;
        Node prev = null;
        Node next = null;

        int count = 0;
        while(count < k && current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if(next!=null)
            head.next = reverse1(next,k);

        return prev;
    }

    Node reverse2(Node head,int k){

        Stack<Node> s = new Stack<>();

        Node current = head;
        Node prev = null;

        if(current==null)
            return head;

        while(current!=null){
            int count = 0;
            while(current!=null && count < k){
                s.push(current);
                current = current.next;
                count++;
            }
            while(s.size() > 0){
                if(prev==null){
                    prev = s.peek();
                    head = prev;
                    s.pop();
                }else{
                    prev.next = s.peek();
                    prev = prev.next;
                    s.pop();
                }
            }
        }
        prev.next = null;
        return head;
    }
}
