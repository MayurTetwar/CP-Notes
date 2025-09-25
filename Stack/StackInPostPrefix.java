package Stack;
import java.util.*;

public class StackInPostPrefix{

    /* 1. To find next greater element in array */
    static int[] getNextGreaterEle(int []arr){
        int n=arr.length;
        int res[]=new int[n];
        Stack<Integer> stk=new Stack<>();
        stk.push(arr[n-1]); 
        res[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            while(!stk.empty() && arr[i]>stk.peek()) 
                stk.pop();
            if(stk.empty()) res[i]=-1;
            else res[i]=stk.peek();
            stk.push(arr[i]);
        }
        return res;
    }

    /* 2. Solve Infix Expression */
    static int infixSolve(String s){
        Stack<Integer> value=new Stack<>();
        Stack<Character> ope=new Stack<>();

        for(char ch:s.toCharArray()){
            if(ch>='0' && ch<='9') value.push(ch-'0');
            else if(ope.empty() || ch=='(' || ope.peek()=='('){
                ope.push(ch);
            }else if(ch==')'){
                while(ope.peek()!='('){
                    int val1=value.pop();
                    int val2=value.pop();
                    if(ope.peek()=='+')value.push(val2+val1);
                    else if(ope.peek()=='-')value.push(val2-val1);
                    else if(ope.peek()=='*')value.push(val2*val1);
                    else value.push(val2/val1);
                    ope.pop();
                }
                ope.pop();
            }else{
                if(ch=='+'||ch=='-'){
                    int val1=value.pop();
                    int val2=value.pop();
                    if(ope.peek()=='+')value.push(val2+val1);
                    else if(ope.peek()=='-')value.push(val2-val1);
                    else if(ope.peek()=='*')value.push(val2*val1);
                    else value.push(val2/val1);
                    ope.pop();
                    ope.push(ch);
                }else if(ope.peek()=='+'||ope.peek()=='-'){
                    ope.push(ch);
                }else{
                    int val1=value.pop();
                    int val2=value.pop();
                    if(ope.peek()=='*')value.push(val2*val1);
                    else value.push(val2/val1);
                    ope.pop();
                    ope.push(ch);
                }
            }
        }
        while(value.size()>1){
            int val1=value.pop();
            int val2=value.pop();
            if(ope.peek()=='+')value.push(val2+val1);
            else if(ope.peek()=='-')value.push(val2-val1);
            else if(ope.peek()=='*')value.push(val2*val1);
            else value.push(val2/val1);                
            ope.pop();
        }
        return value.pop();
    }

    /* 3. Convert Infix to Postfix Expression */
    static String infixtoPost(String s){
        Stack<Character> stk=new Stack<>();
        StringBuilder str = new StringBuilder();
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('^',3);
        map.put('%',2);
        map.put('*',2);
        map.put('/',2);
        map.put('+',1);
        map.put('-',1);
        for(char ch:s.toCharArray()){
            if(ch>='A' && ch<='Z')str.append(ch);
            else if(ch=='(')stk.push('(');
            else if(ch==')'){
                while(stk.size()>0 && stk.peek()!='('){
                    str.append(stk.pop());
                }
                stk.pop();
            }else{
                if(stk.size()>0 && stk.peek()=='(')stk.push(ch);
                else{
                    while(stk.size()>0 && stk.peek()!='(' && map.get(ch)<=map.get(stk.peek())){
                        str.append(stk.pop());
                    }
                    stk.push(ch);
                }
            }
        }
        while(!stk.isEmpty()){
            str.append(stk.pop());
        }
        System.out.println(str);
        return str.toString();
    }
    
    /* 4. Convert Infix to prefix Expresion */
    static String infixtoPre(String s){
        Stack<Character> stk=new Stack<>();
        StringBuilder str=new StringBuilder();
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('^',3);
        map.put('%',2);
        map.put('*',2);
        map.put('/',2);
        map.put('+',1);
        map.put('-',1);

        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch>='A' && ch<='Z')str.append(ch);
            else if(ch==')')stk.push(ch);
            else if(ch=='('){
                while(stk.size()>0 && stk.peek()!=')'){
                    str.append(stk.pop());
                }
                stk.pop();
            }else{
                if(stk.size()>0 && stk.peek()==')')stk.push(ch);
                else{
                    while(stk.size()>0 && stk.peek()!=')'&& (map.get(ch)<map.get(stk.peek()))){
                        str.append(stk.pop());
                    }
                    stk.push(ch);
                }
            }
        }
        while(stk.size()>0){
            str.append(stk.pop());
        }
        System.out.println(str.reverse());

        return str.toString();
    }

    /* 5. Solve Postfix Expresion */
    static void postfixSolve(String s){
        Stack<Integer> stk=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch>='0' && ch<='9')stk.push(ch-'0');
            else{
                int val2=stk.pop();
                int val1=stk.pop();
                if(ch=='^')stk.push((int)Math.pow(val1, val2));
                else if(ch=='%')stk.push(val1%val2);
                else if(ch=='/')stk.push(val1/val2);
                else if(ch=='*')stk.push(val1*val2);
                else if(ch=='+')stk.push(val1+val2);
                else stk.push(val1-val2);
            }
            System.out.println(stk);
        }
        System.out.println(stk.peek());
    }

    /* 6. Solve Prefix Expresions */
    static void prefixSolve(String s){
        Stack<Integer> stk=new Stack<>();
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch>='0' && ch<='9')stk.push(ch-'0');
            else{
                int val1=stk.pop();
                int val2=stk.pop();
                if(ch=='^')stk.push((int)Math.pow(val1, val2));
                else if(ch=='%')stk.push(val1%val2);
                else if(ch=='/')stk.push(val1/val2);
                else if(ch=='*')stk.push(val1*val2);
                else if(ch=='+')stk.push(val1+val2);
                else stk.push(val1-val2);
            }
            System.err.println(stk);
        }
        System.out.println(stk.peek());
    }

    /* 7.Prefix to postfix Expresions */
    static String prefixToPost(String s){
        Stack<String> stk=new Stack<>();
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch>='0' && ch<='9')stk.push(ch+"");
            else{
                StringBuilder str=new StringBuilder();
                str.append(stk.pop());
                str.append(stk.pop());
                str.append(ch+"");
                stk.push(str.toString());
            }
        }
        return stk.peek();
    }

    /* 8.Postfix to infix Expresions */
    static String postToInfix(String s){
        Stack<String> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>='0' && ch<='9')stk.push(ch+"");
            else{
                StringBuilder str=new StringBuilder();
                String op2=stk.pop();
                String op1=stk.pop();
                str.append("(");
                str.append(op1);
                str.append(ch+"");
                str.append(op2);
                str.append(")");
                stk.push(str.toString());
            }
        }
        return stk.peek();
    }
    public static void main(String[] args) {

        // 1.
        // int[] arr={1,5,3,2,1,6,3,4};
        // int n=arr.length;
        // int res[]=getNextGreaterEle(arr);
        // for(int i=0;i<n;i++){
        //     System.out.print(res[i]+" ");
        // }

        // 2.
        //System.out.println(infixSolve("8*2/(2+1)-4+3*2"));
        
        // 3.
        //String str=infixtoPost("(A-W*(B-C)/D*E)+F");

        // 5.
        //postfixSolve(str);

        // 4.
        //String s=infixtoPre("A+B-(C-D/F*(G-K))");
         
        // 6.
        //prefixSolve(s);
    
        // 7.
        //System.out.println(prefixToPost("-9/*+5346"));

        //8.
        //System.out.println(postToInfix("953+4*6/-"));
    }
}
