package linked_list.question_5;

import java.util.*;

public class Question5 {
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

    Question5(){
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

    // using floyd loop detection
    Node firstNode1(Node node){
        Node slow = node;
        Node fast = node;

        while(slow!=null&&fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }

        if(slow!=fast)
            return null;

        slow = node;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // using hashing
    Node firstNode2(Node node){
        HashSet<Node> s = new HashSet<>();
        while(node!=null){
            if(s.contains(node)){
                return node;
            }else{
                s.add(node);
            }
            node = node.next;
        }
        return null;
    }
}
