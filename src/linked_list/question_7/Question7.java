package linked_list.question_7;

import java.util.*;
public class Question7 {
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

    Question7(){
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

    // using 2 loops
    void removeDuplicates1(){
        Node ptr1 = this.head;
        Node ptr2 = null;

        while(ptr1!=null && ptr1.next!=null){
            ptr2 = ptr1;
            while(ptr2.next!=null){
                if(ptr1.data == ptr2.next.data){
                    ptr2.next = ptr2.next.next;
                }else{
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    // using sorting

    // using hashing
    void removeDuplicates2(){
        Node current = this.head;
        Node prev = null;

        HashSet<Integer> hs = new HashSet<>();
        while(current!=null){
            int currval = current.data;
            if(hs.contains(currval)){
                prev.next = current.next;
            }else{
                hs.add(currval);
                prev = current;
            }
            current = current.next;
        }
    }
}
