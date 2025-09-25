package LinkedList;

class Node{
    int data; // My data in current Node
    Node next;  // address of next Node
    Node(int data){
        this.data=data;
    }
}

public class BasicLL {

    static void displayList(Node head){
        while (head!=null) {
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
    static void displayListRec(Node head){
        if(head==null) return;
        System.out.print(head.data+" ");
        displayListRec(head.next);
    }

    static int getLengthList(Node head){
        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }
        return len;
    }
    static int getLengthListrec(Node head){
        int len=0;
        if(head==null) return 0;
        len=getLengthListrec(head.next);
        len++;
        return len;
    }
    public static void main(String[] args) {
        
        Node a=new Node(5);
        Node b=new Node(3);
        Node c=new Node(9);
        Node d=new Node(8);
        Node e=new Node(16);
        a.next=b; // 5 -> 3 9 8 16
        b.next=c; // 5 -> 3 -> 9 8 16
        c.next=d; // 5 -> 3 -> 9 -> 8 16
        d.next=e; // 5 -> 3 -> 9 -> 8 -> 16
        displayListRec(a);
        System.out.println("\n"+getLengthListrec(a));;
    }
}
