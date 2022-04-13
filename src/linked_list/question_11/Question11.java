package linked_list.question_11;

public class Question11 {

    static LinkedList result = new LinkedList();

    static void sortedIntersection1(Node head1,Node head2){
        Node ptr1 = head1;
        Node ptr2 = head2;

        while(ptr1!=null && ptr2!=null){
            if(ptr1.data == ptr2.data){
                result.addAtEnd(ptr1.data);
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }else if(ptr1.data < ptr2.data){
                ptr1 = ptr1.next;
            }else {
                ptr2 = ptr2.next;
            }
        }

    }

    static Node sortedIntersection2(Node a,Node b){
        if(a == null || b == null)
            return null;
        if(a.data < b.data){
            return sortedIntersection2(a.next, b);
        }else if(a.data > b.data){
            return sortedIntersection2(a, b.next);
        }
        Node temp = new Node(a.data);
        temp.next = sortedIntersection2(a.next, b.next);
        return temp;
    }
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();

        ll1.addAtEnd(1);
        ll1.addAtEnd(2);
        ll1.addAtEnd(3);
        ll1.addAtEnd(4);
        ll1.addAtEnd(5);
        ll1.addAtEnd(6);
        ll1.addAtEnd(7);
        ll1.addAtEnd(8);

        ll2.addAtEnd(2);
        ll2.addAtEnd(4);
        ll2.addAtEnd(6);
        ll2.addAtEnd(8);
        ll2.addAtEnd(10);

        ll1.printList();
        ll2.printList();

        // sortedIntersection1(ll1.head, ll2.head);

        result.head = sortedIntersection2(ll1.head, ll2.head);

        result.printList();
    }
}
