package linked_list.question_31;

public class Question31 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        int k = 3;
        int n = 4;

        Node[] arr = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        ll.head = ll.mergeLists2(arr,k-1);
        ll.printList(ll.head);
    }
}
