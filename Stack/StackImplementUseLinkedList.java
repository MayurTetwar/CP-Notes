package Stack;

public class StackImplementUseLinkedList {
    
    public static class Node{
        int val;
        Node next;
        Node(int val){this.val=val;}
    }
    public  static class LLStack{
        private Node head=null;
        private int size=0;
        void push(int val){
            Node temp=new Node(val);
            temp.next=head;
            head=temp;
            size++;
        }
        void displayRev(){
            Node temp=head;
            while (temp!=null) {
                System.out.print(temp.val+" ");
                temp=temp.next;
            }
            System.out.println();
        }
        void helper(Node temp){
            if(temp==null)return;
            helper(temp.next);
            System.out.print(temp.val+" ");
        }  
        void display(){
            Node temp=head;
            helper(temp);       
            System.out.println(); 
        }
        int pop(){
            if(head==null){
                System.out.println("Stack Underflow.....");
                return -1;
            }
            size--;
            int top=head.val;
            head=head.next;
            return top;
        }
        int peek(){
            if(head==null){
                System.out.println("Stack is Empty.......");
                return -1;
            }
            return head.val;
        }
        int size(){
            return size;
        }
        boolean isEmpty(){
            if(size()==0)return true;
            return false;
        }
    }
    public static void main(String[] args) {
        LLStack st=new LLStack();
        st.push(5);
        st.push(3);
        st.push(4);
        System.out.println(st.peek());
        st.display();
        System.out.println("Size : "+st.size());
        st.pop();
        st.pop();
        st.display();
        st.pop();
        st.display();
        st.pop();
    }
}
