package Stack;
import java.util.*;

public class BacisStack {

    // reverse stack using recursion
    public static void pushAtBottom(Stack<Integer> stk,int val){
        if(stk.empty()){
            stk.push(val);
            return;
        }
        int top=stk.pop();
        pushAtBottom(stk, val);
        stk.push(top);
    }
    public static void reverseStk(Stack<Integer> stk){
        if(stk.empty())return;
        int top=stk.pop();
        reverseStk(stk);
        pushAtBottom(stk, top);
        // stk.add(0, top); // this also use
    }

    public static void main(String[] args) {
        
        Stack<Integer> st=new Stack<>();
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);
        st.push(5);
        System.out.println(st);
        reverseStk(st);
        System.out.println(st);

        /* For Copy Content of one stack(st) to another stack(gt) */
        // Stack<Integer> st=new Stack<>();
        // st.push(4);
        // st.push(3);
        // st.push(2);
        // st.push(1);
        // st.push(5);
        // System.out.println(st);
        // Stack<Integer> rt=new Stack<>();
        // Stack<Integer> gt=new Stack<>();
        // while(st.size()>0){
        //     rt.push(st.pop());
        // }
        // while(rt.size()>0){
        //     gt.push(rt.pop());
        // }
        // System.out.println(gt);
    }
}
