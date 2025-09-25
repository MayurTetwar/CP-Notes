package LinkedList;

import java.util.ArrayList;

public class Implimentation {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public static class LinkedList{

        Node head=null;
        Node tail=null;
        int size=0;

        LinkedList(){}
        
        int get(int ind){
            if(ind<0 || ind>=size) return -99;
            Node temp=head;
            for(int i=0;i<ind;i++){
                temp=temp.next;
            }
            return temp.data;
        }
        void insertAtEnd(int data){
            Node temp=new Node(data);
            if(head==null)
                head=temp;
            else
                tail.next=temp;
            tail=temp;
            size++;
        }
        void insertAtHead(int data){
            Node temp=new Node(data);
            if(head==null)
                tail=temp;
            else
                temp.next=head;
            head=temp;
            size++;
        }   
        void insertAt(int ind,int data){
            if(ind<0 || ind>=size)return;
            Node temp=new Node(data);
            if(ind==0) insertAtHead(data);
            else if(ind==size-1) insertAtEnd(data);
            else{
                Node dummy=head;
                int i=1;
                while (i<ind) {
                    dummy=dummy.next;
                    i++;
                }
                temp.next=dummy.next;
                dummy.next=temp;
                size++;
            }
        }
        void deleteAt(int ind){
            if(ind<0 || ind>=size)return;
            if(ind==0){
                head=head.next;
                size--;
                return;
            }
            Node temp=head;
            for(int i=0;i<ind-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
            size--;
        }
        void displayList(){
            Node temp=head;
            while(temp!=null) {
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }
        int size(){
            Node temp=head;
            int len=0;
            while (temp!=null) {
                len++;
                temp=temp.next;
            }
            return len;
        }
        Node reverse(Node temp){
            if(temp.next==null)return temp;
            Node rev=reverse(temp.next);
            temp.next.next=temp;
            temp.next=null;
            return rev;
        }
        void rotaesByK(int k){
            k=k%size;
            if(k==0 || head==null){
                return;
            }
            Node temp=head;
            Node tail=head;
            int i=0;
            while (temp.next!=null) {
                if(i==size-k-1)
                    tail=temp;
                temp=temp.next;
                i++;
            }
            temp.next=head;
            head=tail.next;
            tail.next=null;
        }
        
    }
    
    public static void main(String[] args) {
        
        LinkedList list=new LinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtEnd(7);
        list.insertAtEnd(8);
        list.displayList();
    }
}
