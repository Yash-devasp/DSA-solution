package linked_list.question_30;

import java.util.HashMap;

public class LinkedList {
    Node head;

    LinkedList(){
        this.head = null;
    }

    // simple method O(n^2)
    Node cloneLinkedList1(){
        if(head == null)
            return head;

        Node ptr1 = head.next;
        Node head2 = new Node(head.data);
        Node ptr2 = head2;
        while(ptr1!=null){
            ptr2.next = new Node(ptr1.data);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ptr1 = head;
        ptr2 = head;
        while(ptr1!=null){
            if(ptr1.random!=null){
                Node trv1 = head;
                Node trv2 = head2;
                while(trv1!=ptr1.random){
                    trv1 = trv1.next;
                    trv2 = trv2.next;
                }
                ptr2.random = trv2;
            }else{
                ptr2.random = null;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return head2;
    }

    // using hashmap O(n) time and O(n) space
    Node cloneLinkedList2(){
        Node ptr1 = head.next;
        Node head2 = new Node(head.data);
        Node ptr2 = head2;
        while(ptr1!=null){
            ptr2.next = new Node(ptr1.data);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        HashMap<Node,Node> hm = new HashMap<>();
        ptr1 = head;
        ptr2 = head2;
        while(ptr1!=null){
            hm.put(ptr1, ptr2);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ptr1 = head;
        ptr2 = head2;
        while(ptr1!=null){
            ptr2.random = hm.get(ptr1.random);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return head2;
    }

    // by changing links
    Node cloneLinkedList3(){
        Node ptr1 = head.next;
        Node head2 = new Node(head.data);
        Node ptr2 = head2;
        while(ptr1!=null){
            ptr2.next = new Node(ptr1.data);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // create links
        ptr1 = head;
        ptr2 = head2;
        while(ptr1!=null && ptr2!=null){
            Node temp = ptr1.next;
            ptr1.next = ptr2;
            ptr1 = temp;

            temp = ptr2.next;
            ptr2.next = ptr1;
            ptr2 = temp;
        }

        // clone random points
        Node temp = head;
        while(temp!=null){
            if(temp.next!=null)
                temp.next.random = (temp.random!=null) ? temp.random.next : null;

            temp = temp.next.next;
        }

        ptr1 = head;
        ptr2 = head2;
        while(ptr1!=null && ptr2!=null){
            ptr1.next = ptr2.next;
            ptr1 = ptr1.next;

            if(ptr1!=null)
                ptr2.next = ptr1.next;
            ptr2 = ptr2.next;
        }

        return head2;
    }

    void print(Node ptr){
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}
