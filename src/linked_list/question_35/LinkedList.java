package linked_list.question_35;

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

    int getNthFromLast(Node head, int n)
    {
    	// Your code here
    	Node ptr = head;
    	int count = 1;
    	while(ptr!=null && count < n){
    	    count++;
    	    ptr = ptr.next;
    	}
    	if(ptr == null){
    	    return -1;
    	}
    	Node res = head;
    	while(ptr.next!=null){
    	    ptr = ptr.next;
    	    res = res.next;
    	}
    	return res.data;
    }
}
