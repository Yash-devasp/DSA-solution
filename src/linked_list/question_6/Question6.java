package linked_list.question_6;

import java.util.*;

public class Question6 {
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

    Question6(){
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

    void removeDuplicates1(){
        Node curr = this.head;
        while(curr!=null){
            Node temp = curr;
            while(temp!=null && temp.data==curr.data){
                temp = temp.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
    }

    // using recursion
    Node removeDuplicates2(Node node){
        Node to_free;
        if(node==null)
            return node;

        if(node.next!=null){
            if(node.data==node.next.data){
                to_free = node.next;
                node.next = node.next.next;
                removeDuplicates2(node);
            }else{
                removeDuplicates2(node.next);
            }
        }
        return node;
    }

    // using pointer to point to every element
    void removeDuplicates3(){
        Node temp = this.head;
        Node prev = this.head;
        while(temp!=null){
            if(temp.data!=prev.data){
                prev.next = temp;
                prev = prev.next;
            }
            temp = temp.next;
        }
        if(temp!=prev){
            prev.next = null;
        }
    }

    // using hashing
    void removeDuplicates4(){
        HashSet<Integer> hs = new HashSet<>();

        Node temp = this.head;
        Node prev = null;

        while(temp!=null){
            if(hs.contains(temp.data)){
                temp = temp.next;
            }else{
                hs.add(temp.data);
                if(prev!=null){
                    prev.next = temp;
                }
                prev = temp;
                temp = temp.next;
            }
        }
    }
}
