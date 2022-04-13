package linked_list.question_10;

public class Question10 {
    class Node{

        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    Node head;
    int carry;
    Node result;

    Question10(){
        head = null;
        carry = 0;
        result = null;
    }

    void insertAtTail(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
        }else {
            Node ptr = this.head;
            while(ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = newNode;
        }
    }

    void push(int data){
        Node newNode = new Node(data);
        if(result == null){
            result = newNode;
        }else {
            Node ptr = result;
            while(ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = newNode;
        }
    }

    void printList(Node node){
        Node ptr = node;
        while(ptr!=null){
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    Node reverse(Node node){
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

    Node addList(Node head2){
        Node ptr1 = reverse(this.head);
        Node ptr2 = reverse(head2);

        while(ptr1!=null && ptr2!=null){
            int sum = ptr1.data + ptr2.data + carry;
            carry = sum / 10;
            sum = sum % 10;
            push(sum);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        while(ptr1!=null){
            int sum = ptr1.data + carry;
            carry = sum / 10;
            sum = sum % 10;
            push(sum);
            ptr1 = ptr1.next;
        }

        while(ptr2!=null){
            int sum = ptr2.data + carry;
            carry = sum / 10;
            sum = sum % 10;
            push(sum);
            ptr2 = ptr2.next;
        }

        if(carry > 0){
            while(carry != 0){
                push(carry%10);
                carry = carry / 10;
            }
        }
        return reverse(result);
    }
}
