package linked_list.question_12;

import java.util.HashSet;

public class Question12 {

    static int getCount(Node node){
        Node ptr = node;
        if(ptr == null)
            return 0;
        int count = 1;
        while(ptr.next!=null){
            ptr = ptr.next;
            count++;
        }
        return count;
    }

    static Node _getIntersection(Node head1,Node head2,int diff){
        for(int i=1;i<=diff;i++){
            if(head1 == null){
                return null;
            }
            head1 = head1.next;
        }

        while(head1!=null && head2!=null){
            if(head1 == head2){
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    static Node getIntersection1(Node head1,Node head2){
        if(head1 == null || head2 == null)
            return null;

        int count1 = getCount(head1);
        int count2 = getCount(head2);
        int diff;

        if(count1 > count2){
            diff = count1 - count2;
            return _getIntersection(head1,head2,diff);
        }else{
            diff = count2 - count1;
            return _getIntersection(head2,head1,diff);
        }
    }

    static Node getIntersection2(Node head1,Node head2){
        HashSet<Node> hs = new HashSet<>();
        
        while(head1 != null){
            hs.add(head1);
            head1 = head1.next;
        }

        while(head2!=null){
            if(hs.contains(head2)){
                return head2;
            }
            head2 = head2.next;
        }
        return null;
    }

    static Node getIntersection3(Node head1,Node head2){
        Node ptr1 = head1;
        Node ptr2 = head2;
        while(ptr1!=ptr2){
            if(ptr1==null){
                ptr1 = head2;
            }
            if(ptr2==null){
                ptr2 = head1;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();

        ll1.insertAtEnd(1);
        ll1.insertAtEnd(2);
        ll1.insertAtEnd(3);
        ll1.insertAtEnd(4);
        ll1.insertAtEnd(5);
        ll1.insertAtEnd(6);
        ll1.insertAtEnd(7);
        ll1.insertAtEnd(8);


        ll2.insertAtEnd(4);

        ll2.head.next = ll1.head.next.next.next.next;

        // Node intersection = getIntersection1(ll1.head,ll2.head);

        // Node intersection = getIntersection2(ll1.head, ll2.head);

        Node intersection = getIntersection3(ll1.head, ll2.head);

        if(intersection!=null){
            System.out.println(intersection.data);
        }
    }
}
