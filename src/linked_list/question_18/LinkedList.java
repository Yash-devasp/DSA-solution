package linked_list.question_18;

import java.util.Stack;

public class LinkedList {
    Node head;
    Node left;

    LinkedList(){
        this.head = null;
    }

    void printList(Node node){
        Node ptr = node;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
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
            ptr.next = newNode;
        }
    }

    boolean checkPalindrome1(){
        Node current = this.head;
        Stack<Node> s = new Stack<Node>();

        while(current!=null){
            s.push(current);
            current = current.next;
        }

        current = this.head;
        while(current!=null){
            Node rev = s.peek();
            if(current.data != rev.data)
                return false;
            s.pop();
            current = current.next;
        }

        return true;
    }

    boolean checkPalindrome2(){
        Node slow_ptr = this.head;
        Node fast_ptr = this.head;
        Node prev = null;
        Node midnode = null;

        if(this.head == null || this.head.next == null){
            return true;
        }

        while(fast_ptr.next!=null && fast_ptr.next.next!=null){
            fast_ptr = fast_ptr.next.next;
            prev = slow_ptr;
            slow_ptr = slow_ptr.next;
        }

        if(fast_ptr.next == null){
            midnode = slow_ptr;
            slow_ptr = slow_ptr.next;
        }else{
            prev = slow_ptr;
            slow_ptr = slow_ptr.next;
        }

        prev.next = null;

        boolean result = checkEquality(this.head,slow_ptr);

        if(midnode != null){
            prev.next = midnode;
            prev = prev.next;
        }
        prev.next = slow_ptr;

        return result;
    }

    Node reverse(Node node){
        Node current = node;
        Node previous = null;
        Node forward = null;

        while(current!=null){
            forward = current.next;
            current.next = previous;
            previous = current;
            current = forward;
        }
        return previous;
    }

    boolean checkEquality(Node list1,Node list2){
        Node ptr1 = list1;
        Node ptr2 = reverse(list2);

        while(ptr1!=null && ptr2!=null){
            if(ptr1.data != ptr2.data){
                return false;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        if(ptr1!=null || ptr2!=null){
            return false;
        }

        return true;
    }

    boolean checkPalindrome3(){
        return isPalindrome(this.head);
    }

    boolean isPalindrome(Node right){
        left = this.head;
        if(right==null){
            return true;
        }

        boolean isp = isPalindrome(right.next);
        if(!isp)
            return false;

        boolean isp1 = (right.data == left.data);
        left = left.next;
        return isp1;
    }
}
