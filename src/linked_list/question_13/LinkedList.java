package linked_list.question_13;

public class LinkedList {
    
    Node head;

    LinkedList(){
        this.head = null;
    }

    void addAtEnd(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
        }else{
            Node ptr = head;
            while(ptr.next!=null){
                ptr = ptr.next;
            }
            ptr.next = newNode;
        }
    }

    void printList(){
        Node ptr = this.head;
        while(ptr!=null){
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    Node getMiddle(Node node){

        if(node==null)
            return node;

        Node slow_ptr = node;
        Node fast_ptr = node;

        while(fast_ptr.next!=null && fast_ptr.next.next!=null){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        return slow_ptr;
    }

    Node merge(Node a,Node b){
        Node result = null;
        if(a == null)
            return b;
        if(b==null)
            return a;
        if(a.data <= b.data){
            result = a;
            result.next = merge(a.next,b);
        }else{
            result = b;
            result.next = merge(a,b.next);
        }
        return result;
    }

    Node mergeSort(Node h){
        if(h == null || h.next == null)
            return h;

        Node middle = getMiddle(h);
        Node middleNext = middle.next;
        middle.next = null;

        Node left = mergeSort(h);
        Node right = mergeSort(middleNext);

        return merge(left,right);
    }
}
