package linked_list.question_21;

public class DoublyLinkedList {
    Node head;

    DoublyLinkedList(){
        this.head = null;
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
            newNode.prev = ptr;
            ptr.next = newNode;
        }
    }

    void getPairs(int x){
        Node first = this.head;
        Node second = this.head;

        while(second.next!=null){
            second = second.next;
        }

        while(first!=second && second.next!=first){
            if((first.data+second.data) == x){
                System.out.println(first.data+" "+second.data);
                first = first.next;
                second = second.prev;
            }else{
                if((first.data+second.data)<x)
                    first = first.next;
                else
                    second = second.prev;
            }
        }
    }
}
