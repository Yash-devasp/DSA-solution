package linked_list.question_37;

public class LinkedList {
    Node head;

    LinkedList(){
        head = null;
    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
        }else{
            Node ptr = head;
            while(ptr.next!=null){
                ptr = ptr.next;
            }
            ptr.next = newNode;
        }
    }

    static Node reverse(Node node){
        Node current = node;
        Node prev = null;
        Node forward = null;
        
        while(current!=null){
            forward = current.next;
            current.next = prev;
            prev = current;
            current = forward;
        }
        
        return prev;
    }

    Node reverseBetween(int m, int n)
    {
        //code here
        Node ptrSubStart = head;
        Node ptrSubStartPrev = null;
        while(m > 1 && ptrSubStart!=null){
            ptrSubStartPrev = ptrSubStart;
            ptrSubStart = ptrSubStart.next;
            m--;
            n--;
        }
        
        if(ptrSubStart == null){
            return head;
        }
        
        Node ptrSubEnd = ptrSubStart;
        while(n > 1 && ptrSubEnd!=null){
            ptrSubEnd = ptrSubEnd.next;
            n--;
        }
        
        if(ptrSubEnd == null || ptrSubEnd.next == null){
            ptrSubStart = reverse(ptrSubStart);
            if(ptrSubStartPrev == null)
                return ptrSubStart;
            ptrSubStartPrev.next = ptrSubStart;
        }else{
            Node ptrSubEndNext = ptrSubEnd.next;
            ptrSubEnd.next = null;
            ptrSubStart = reverse(ptrSubStart);
            ptrSubEnd = ptrSubStart;
            while(ptrSubEnd.next!=null){
                ptrSubEnd = ptrSubEnd.next;
            }
            if(ptrSubStartPrev == null){
                ptrSubEnd.next = ptrSubEndNext;
                return ptrSubStart;
            }
            ptrSubStartPrev.next = ptrSubStart;
            ptrSubEnd.next = ptrSubEndNext;
        }
        return head;
    }
}
