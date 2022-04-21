package linked_list.question_32;

public class Question32 {
    public static void main(String[] args) {
        Node head1 = new Node(9);
        head1.next = new Node(4);
        head1.next.next = new Node(6);

        Node head2 = new Node(8);
        head2.next = new Node(4);

        LinkedList ll = new LinkedList();
        System.out.println(ll.multiply(head1, head2));
    }
}
