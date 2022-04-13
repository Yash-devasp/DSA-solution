package linked_list.question_3;

import java.util.*;

public class Question3 {
    
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

    Question3(){
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

    // Using Hashing
    boolean detectLoop1(Node node){
        HashSet<Node> s = new HashSet<>();
        while(node!=null){
            if(s.contains(node)){
                return true;
            }
            s.add(node);
            node = node.next;
        }
        return false;
    }

    // BY adding a flag in node

    // floyd cycle
    boolean detectLoop2(Node node){
        Node slow = node;
        Node fast = node;

        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    // making nodes point to a dummy node

    // checking the distance

    int distance(Node first,Node last){
        int counter = 1;
        Node curr = first;
        while(curr!=last){
            counter++;
            curr = curr.next;
        }
        return counter;
    }


    boolean detectLoop3(Node node){
        Node first = node;
        Node last = node;
        int currentLength = 0;
        int prevLength = -1;

        while(currentLength > prevLength && last!=null){
            prevLength = currentLength;
            currentLength = distance(first,last);
            last = last.next;
        }
        if(last == null){
            return false;
        }else{
            return true;
        }
    }
}
