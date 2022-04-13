package linked_list.question_4;

import java.util.*;

public class Question4 {
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

    Question4(){
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

    // counting the number of nodes

    void remove(Node loop,Node node){
        Node ptr1 = loop;
        Node ptr2 = loop;

        int k = 1,i;
        while(ptr1.next!=ptr2){
            k++;
            ptr1 = ptr1.next;
        }

        ptr1 = node;
        ptr2 = node;

        for(i=0;i<k;i++){
            ptr2 = ptr2.next;
        }

        while(ptr1!=ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        while(ptr2.next!=ptr1){
            ptr2 = ptr2.next;
        }
        ptr2.next = null;
    }

    void remove1(Node node){
        Node slow = node;
        Node fast = node;
        Node ptr = null;

        while(slow!=null&&fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                remove(slow,node);
                break;
            }
        }
    }

    // without counting the number of nodes
    void remove2(Node node){
        if(node==null||node.next==null)
            return;
        Node slow = node,fast = node;

        while(slow!=null&&fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                break;
            }
        }

        if(slow==fast){
            slow = node;
            if(slow!=fast){
                while(slow.next!=fast.next){
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
            }else{
                while(fast.next!=slow){
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }

    // using hashing
    void remove3(Node node){
        HashSet<Node> s = new HashSet<>();
        Node prev = null;
        while(node!=null){
            if(s.contains(node)){
                prev.next = null;
                return;
            }else{
                s.add(node);
                prev = node;
                node = node.next;
            }
        }
    }
}
