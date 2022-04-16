package linked_list.question_22;

import java.util.HashMap;

public class DoublyLinkedList {
    Node head;

    DoublyLinkedList(){
        this.head = null;
    }

    void inserAtEnd(int data){
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

    int countTriplets1(int x){
        Node ptr1;
        Node ptr2;
        Node ptr3;
        int count = 0;

        for(ptr1 = head; ptr1!=null; ptr1 = ptr1.next){
            for(ptr2 = ptr1.next; ptr2!= null; ptr2=ptr2.next){
                for(ptr3 = ptr2.next; ptr3!=null;ptr3=ptr3.next){
                    if((ptr1.data+ptr2.data+ptr3.data)==x){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    int countTriplets2(int x){
        HashMap<Integer,Node> hs = new HashMap<>();

        Node ptr;
        Node ptr1;
        Node ptr2;
        int count = 0;

        for(ptr=this.head; ptr!=null; ptr=ptr.next){
            hs.put(ptr.data, ptr);
        }

        for(ptr1=this.head;ptr1!=null;ptr1=ptr1.next){
            for(ptr2=ptr1.next;ptr2!=null;ptr2=ptr2.next){
                int p_sum = ptr1.data + ptr2.data;
                if(hs.containsKey(x-p_sum) && hs.get(x-p_sum)!=ptr1 && hs.get(x-p_sum)!=ptr2){
                    count++;
                }
            }
        }

        return count / 3;
    }

    int getPairs(Node first,Node last,int x){
        int count=0;
        while(first!=null && last!=null && first!=last && last.next!=first){
            if((first.data+last.data)==x){
                count++;
                first = first.next;
                last = last.prev;
            }else if((first.data+last.data) < x){
                first = first.next;
            }else{
                last = last.prev;
            }
        }
        return count;
    }

    int countTriplets3(int x){
        if(this.head == null)
            return 0;

        Node current;
        Node first = this.head;
        Node last = this.head;
        int count = 0;

        while(last.next!=null){
            last = last.next;
        }

        for(current = this.head;current!=null;current = current.next){
            first = current.next;
            count+= getPairs(first,last,x-current.data);
        }

        return count;
    }
}
