package linked_list.question_34;

public class LinkedList {
    Node head;

    LinkedList(){
        head = null;
    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node ptr = head;
            while(ptr.next!=null){
                ptr = ptr.next;
            }
            ptr.next = newNode;
        }
    }

    // method 1
    void segregateEvenOdd(){
        Node end = head;
        Node prev = null;
        Node curr = head;
        while(end.next!=null){
            end= end.next;
        }
        Node newEnd = end;
        while(curr.data%2!=0 && curr!=end){
            newEnd.next = curr;
            curr = curr.next;
            newEnd.next.next = null;
            newEnd = newEnd.next;
        }
        if(curr.data%2==0){
            head = curr;
            while(curr!=end){
                if(curr.data%2==0){
                    prev = curr;
                    curr = curr.next;
                }else{
                    prev.next = curr.next;
                    curr.next = null;
                    newEnd.next = curr;
                    newEnd = curr;
                    curr = prev.next;
                }
            }
        }
        else prev = curr;
        if(newEnd!=end && end.data%2!=0){
            prev.next = end.next;
            end.next = null;
            newEnd.next = end;
        }
    }

    // method 2
    void segregateEvenOdd2(){
        Node even = new Node(0);
        Node odd = new Node(0);
        
        Node ptr = head;
        Node evenPtr = even;
        Node oddPtr = odd;
        while(ptr!=null){
            if(ptr.data % 2 == 0){
                evenPtr.next = ptr;
                evenPtr = evenPtr.next;
            }else{
                oddPtr.next = ptr;
                oddPtr = oddPtr.next;
            }
            ptr = ptr.next;
        }
        evenPtr.next = odd.next;
        oddPtr.next = null;
        head = even.next;
    }
}
