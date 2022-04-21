package linked_list.question_33;

public class LinkedList {
    Node head;

    LinkedList(){
        head =null;
    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
        }else{
            Node ptr = head;
            while(ptr.next!=null){
                ptr= ptr.next;
            }
            ptr.next = newNode;
        }
    }

    void print(){
        Node ptr = head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    Node delete(Node head,int data){
        if(head == null)
            return head;
            
        if(head.data == data){
            head = head.next;
            return head;
        }
        
        Node prev = head;
        Node current = head.next;
        while(current!=null){
            if(current.data == data){
                prev.next = current.next;
                return head;
            }
            prev = current;
            current = current.next;
        }
        return head;
    }

    void compute(){
        Node current = head;
        while(current.next != null){
            Node ptr = current.next;
            boolean shouldDelete = false;
            while(ptr!=null){
                if(current.data < ptr.data){
                    shouldDelete = true;
                }
                ptr = ptr.next;
            }
            if(shouldDelete)
                head = delete(head,current.data);
            current = current.next;
        }
    }

    void reverse(){
        Node current = head;
        Node prev = null;
        Node next = null;

        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    void compute2(){
        reverse();
        Node current = head;
        Node temp;
        Node maxNode = head;

        while(current!=null && current.next!=null){
            if(current.next.data < maxNode.data){
                temp = current.next;
                current.next = temp.next;
                temp = null;
            }else{
                current = current.next;
                maxNode = current;
            }
        }
        reverse();
    }

    Node compute3(Node head){
        if(head==null || head.next==null) return head;
        Node nextNode = compute3(head.next);
        if(nextNode.data > head.data) return nextNode;
        head.next = nextNode;

        return head;
    }
}
