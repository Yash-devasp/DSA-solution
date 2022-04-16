package linked_list.question_22;

public class Question22 {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.inserAtEnd(1);
        dll.inserAtEnd(2);
        dll.inserAtEnd(4);
        dll.inserAtEnd(5);
        dll.inserAtEnd(6);
        dll.inserAtEnd(8);
        dll.inserAtEnd(9);

        System.out.println(dll.countTriplets3(17));
    }
}
