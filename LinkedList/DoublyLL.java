package LinkedList;

public class DoublyLL {

      public static class Node{
            int val;
            Node next;
            Node prev;
            Node(int val){
                  this.val=val;
            }
      }

      public static void display(Node head){
            if(head==null) return;
            Node temp=head;
            while(temp!=null){
                  System.out.print(temp.val+" ");
                  temp=temp.next;
            }
            System.out.println();
      }
      public static void displayReverse(Node Tail){
            if(Tail==null) return;
            Node temp=Tail;
            while(temp!=null){
                  System.out.print(temp.val+" ");
                  temp=temp.prev;
            }
            System.out.println();
      }
      public static void displayRandom(Node random){
            Node temp=random;
            while(temp.prev!=null){
                  temp=temp.prev;
            }   
            while(temp!=null){
                  System.out.print(temp.val+" ");
                  temp=temp.next;
            }
            System.out.println();
      }
      public static Node insertAtHead(Node head,int key){
            Node neww=new Node(key);
            if(head==null){
                //  head=neww;
                  return neww;
            }
            neww.next=head;
            head.prev=neww;
            head=neww;
            return head;
      }
      public static void insertAtTail(Node head,int key){
            Node neww=new Node(key);
            // if(head==null){    
            //       return neww;
            // }
            Node temp=head;
            while(temp.next!=null){
                  temp=temp.next;
            }
            temp.next=neww;
            neww.prev=temp;
      }
      public static Node insertAtIndex(Node head,int ind,int key){
            Node neww=new Node(key);
            if(ind==0){
                  neww.next=head;
                  head.prev=neww;
                  head=neww;
                  return head;
            }
            Node temp=head;
            int i=0;
            while(i<ind-1){
                  temp=temp.next;
                  i++;
            }
            neww.next=temp.next;
            if(temp.next!=null)
                  temp.next.prev=neww;
            temp.next=neww;
            neww.prev=temp;
            return head;
      }
      public static Node deleteFromIndex(Node head,int ind){
            if(head==null){
                  return head;
            }else if(ind==0){
                  head=head.next;
                  head.prev=null;
                  return head;
            }
            int i=0;
            Node temp=head;
            while(i<ind-1){
                  temp=temp.next;
                  i++;
            }
            temp.next=temp.next.next;
            if(temp.next!=null){
                  temp.next.prev=temp;
            }
            return head;
      }
      public static void main(String[] args) {
            Node a=new Node(4);
            Node b=new Node(10);
            Node c=new Node(2);
            Node d=new Node(99);
            Node e=new Node(13);
            a.prev=null;
            a.next=b;
            b.prev=a;
            b.next=c;
            c.prev=b;
            c.next=d;
            d.prev=c;
            d.next=e;
            e.prev=d;
            e.next=null;
            display(a);
            //displayReverse(e);
            //displayRandom(d);
            Node newhead=insertAtHead(a, 8);
            display(newhead);
            insertAtTail(newhead, 17);
            display(newhead);
            newhead=insertAtIndex(newhead, 7, -3);
            display(newhead);
            newhead=deleteFromIndex(newhead, 6);
            display(newhead);
            displayRandom(c);
            
      }
}
