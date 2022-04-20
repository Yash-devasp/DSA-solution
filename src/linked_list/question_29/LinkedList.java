package linked_list.question_29;

public class LinkedList {
    Node head;

    LinkedList(){
        head = null;
    }

    void insertAtHead(int data){
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

    // counting the number of occurances
    void sort012(){
        int count[] = {0,0,0};

        Node ptr = head;

        while(ptr!=null){
            count[ptr.data]++;
            ptr = ptr.next;
        }

        ptr = head;
        int i = 0;

        while(i <= 2 && ptr!=null){
            if(count[i] > 0){
                ptr.data = i;
                count[i]--;
                ptr = ptr.next;
            }else{
                i++;
            }
        }
    }

    // by changing the links of the linked list
    void sortList(){
        if(head == null || head.next == null)
            return;

        Node zeroD = new Node(0);
        Node oneD = new Node(0);
        Node twoD = new Node(0);

        Node zero = zeroD, one = oneD, two = twoD;
        Node ptr = head;

        while(ptr!=null){
            if(ptr.data == 0){
                zero.next = ptr;
                zero = zero.next;
            }else if(ptr.data == 1){
                one.next = ptr;
                one = one.next;
            }else{
                two.next = ptr;
                two = two.next;
            }
            ptr = ptr.next;
        }

        zero.next = null;
        one.next = null;
        two.next = null;

        if(oneD.next == null){
            zero.next = twoD.next;
        }else{
            zero.next = oneD.next;
            one.next = twoD.next;
        }

        head = zeroD.next;
    }

    void printList(){
        Node ptr = head;
        while(ptr!=null){
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}
