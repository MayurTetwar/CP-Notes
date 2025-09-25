package Stack;

public class StackImplementUseArray {

    public static class Stack{
        int[] arr=new int[5];
        int ind=0;
        void push(int top){
            if(isFull()){
                System.out.println("Stack Overflow.....");
                return;
            }
            arr[ind]=top;
            ind++;
        }
        int pop(){
            if(isEmpty()){
                System.out.println("Stack Underflow.....");
                return 0;
            }
            int top=arr[ind-1];
            arr[ind-1]=0;
            ind--;
            return top;
        }
        void display(){
            for(int i=0;i<ind;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        int peek(){
            if(isEmpty()){
                System.out.println("Stack Empty.....");
                return 0;
            }
            return arr[ind-1];
        }
        int size(){
            return ind;
        }
        boolean isEmpty(){
            if(ind==0){
                return true;
            }
            return false;
        }
        boolean isFull(){
            if(ind==arr.length){
                return true;
            }
            return false;
        }
        int capasity(){
            return arr.length;
        }
    }
    public static void main(String[] args) {
        
        Stack st=new Stack();
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
