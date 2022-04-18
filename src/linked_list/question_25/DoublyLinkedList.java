package linked_list.question_25;

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
    // recursive solution
    Node reverseByN(Node head,int k){
        if(head==null)
            return null;

        head.prev = null;
        Node temp;
        Node curr = head;
        Node newHead = null;
        int count = 0;

        while(curr!=null && count < k){
            newHead = curr;
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
            count++;
        }

        if(count >= k){
            Node rest = reverseByN(curr, k);
            head.next = rest;
            if(rest!=null){
                rest.prev = head;
            }
        }
        return newHead;
    }

    // iterative solution
    Node revListInGroupOfGivenSize(int k){
        if(this.head == null)
            return this.head;

        Node st = this.head;
        Node globprev = null;
        Node ans = null;
        while(st!=null){
            int count = 1;
            Node curr = st;
            Node prev = null;
            Node next = null;
            while(curr!=null && count <= k){
                next = curr.next;
                curr.prev = next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if(ans==null)
                ans = prev;
            if(globprev == null){
                globprev = st;
            }else{
                globprev.next = prev;
                prev.prev = globprev;
                globprev = st;
            }
            st = curr;
        }
        return ans;
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
