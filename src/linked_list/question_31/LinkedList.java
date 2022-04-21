package linked_list.question_31;

public class LinkedList {
    Node head;

    LinkedList(){
        head = null;
    }

    void printList(Node ptr){
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    Node mergeLists(Node[] arr,int last){
        for(int i=1;i<=last;i++){
            while(true){
                Node head_0 = arr[0];
                Node head_i = arr[i];

                if(head_i == null)
                    break;

                if(head_0.data > head_i.data){
                    arr[i] = head_i.next;
                    head_i.next = head_0;
                    arr[0] = head_i;
                }else{
                    while(head_0.next!=null){
                        if(head_0.next.data >= head_i.data){
                            arr[i] = head_i.next;
                            head_i.next = head_0.next;
                            head_0.next = head_i;
                            break;
                        }
                        head_0 = head_0.next;
                        if(head_0.next==null){
                            arr[i] = head_i.next;
                            head_i.next = null;
                            head_0.next = head_i;
                            head_0.next.next = null;
                            break;
                        }
                    }
                }
            }
        }
        return arr[0];
    }

    Node mergeSorted(Node a,Node b){
        if(a == null) return b;
        if(b == null) return a;

        Node result;
        if(a.data < b.data){
            result = a;
            result.next = mergeSorted(a.next, b);
        }else{
            result = b;
            result.next = mergeSorted(a, b.next);
        }
        return result;
    }

    Node mergeLists2(Node[] arr,int last){
        while(last!=0){
            int i = 0, j = last;
            while(i<j){
                arr[i] = mergeSorted(arr[i],arr[j]);
                i++;
                j--;
                if(i>=j){
                    last = j;
                }
            }
        }
        return arr[0];
    }
}
