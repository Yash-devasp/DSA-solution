package linked_list.question_9;

public class Question9 {
    public class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    Question9(){
        this.head = null;
        this.tail = null;
    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(this.tail == null){
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    void printList(){
        Node ptr = this.head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    Node reverse(Node node){
        Node current = node;
        Node prev = null;
        Node next = null;

        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    Node addOneUtil(Node node){
        Node res = node;
        Node temp = null;
        int carry = 1,sum;
        while(node!=null){
            sum = carry +node.data;
            carry = (sum >= 10) ? 1 : 0;
            node.data = sum % 10;
            temp = node;
            node = node.next;
        }
        if(carry>0)
            temp.next = new Node(carry);

        return res;
    }

    void addOne1(){
        this.head = reverse(this.head);
        this.head = addOneUtil(this.head);
        this.head = reverse(this.head);
    }

    Node addOne2(Node node){
        int carry = addWithCarry(node);
        if(carry > 0){
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode;
        }
        return node;
    }

    int addWithCarry(Node node){
        if(node == null)
            return 1;
        
        int res = node.data + addWithCarry(node.next);
        node.data = res % 10;
        return res / 10;
    }

    Node addOne3(){
        Node ln = this.head;
        if(this.head.next==null){
            this.head.data+=1;
            return head;
        }
        Node t = head;
        int prev;
        while(t.next!=null){
            if(t.data!=9){
                ln = t;
            }
            t = t.next;
        }
        if(t.data==9&&ln!=null){
            t = ln;
            t.data+=1;
            t = t.next;
            while(t!=null){
                t.data = 0;
                t=t.next;
            }
        }else{
            t.data+=1;
        }
        return this.head;
    }
}
