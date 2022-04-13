package linked_list.question_14;

public class LinkedList {
    Node head;

    LinkedList(){
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
            ptr.next = newNode;
        }
    }

    void sort(Node start,Node end){
        if(start == null || end == null || start == end.next)
            return;

        Node pivot_prev = partitionLast(start,end);
        sort(start,pivot_prev);
        if(pivot_prev!=null && pivot_prev==start){
            sort(pivot_prev.next,end);
        }else if(pivot_prev!=null && pivot_prev.next!=null){
            sort(pivot_prev.next.next,end);
        }
    }

    Node partitionLast(Node start,Node end){
        if(start==end || start==null || end==null)
            return start;

        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.data;
        while(start!=end){
            if(start.data < pivot){
                pivot_prev = curr;
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;
            }
            start = start.next;
        }
        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;
        return pivot_prev;
    }

    void printList(){
        Node ptr = this.head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}
