package linked_list.question_23;

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

    Node sortKSortedList(Node head,int k){
        if(head == null || head.next == null)
            return head;

        for(Node i = head;i!=null;i=i.next){
            Node j = i;

            while(j.prev!=null && j.data < j.prev.data){
                Node temp1 = j.prev.prev;
                Node temp2 = j.prev;
                Node temp3 = j.next;
                j.prev.next = temp3;
                j.prev.prev = j;
                j.prev = temp1;
                j.next = temp2;
                if(temp1!=null){
                    temp1.next = j;
                }
                if(temp3!=null){
                    temp3.prev = temp2;
                }
            }

            if(j.prev == null){
                head = j;
            }
        }
        return head;
    }
}
