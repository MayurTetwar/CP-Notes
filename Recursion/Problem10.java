

package Recursion;

class Problem10{

    static int getCost(int[] arr,int ind){

        if(arr.length-1==ind) return 0;
        int op1=Math.abs(arr[ind]-arr[ind+1])+getCost(arr, ind+1);
        if(arr.length-2==ind) return op1;
        int op2=Math.abs(arr[ind]-arr[ind+2])+getCost(arr, ind+2);
        
        return Math.min(op1, op2);
    }
    // Total no. of calls is 1+2+4+8+....+2^k // k is number of stack frame
    // calls= ~(2^n)
    // Time Complexity = O(2^n*c) = O(2^n)


    // Given an String containing digits from 2-9 inclusive,return all posible
    // letter combinationthat the number could represent .return the answer in any order.
    static void combination(String dig,String[] kp,String res){

        if(dig.length()==0){
            System.out.println(res);
            return;
        }
        int currNum=dig.charAt(0)-'0';
        String currChoices=kp[currNum];
        for(int i=0;i<currChoices.length();i++){
            combination(dig.substring(1), kp, res+currChoices.charAt(i));
        }
    }
    // Total calls are 1+4+16+64......4^n 
    // Calls=4^n
    // Time taken by each calling fuction is c*((~n for subString method)+ ~n for conactination of String)
    // TC=O(n*4^n)

    public static void main(String[] args) {
        
        // int[] arr={10,30,40,20};
        // int n=arr.length;

        // System.out.println(getCost(arr, 0));

        String s="253";
        String[] kp={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        combination(s, kp, "");
    }
}
