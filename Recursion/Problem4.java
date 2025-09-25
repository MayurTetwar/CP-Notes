package Recursion;

public class Problem4 {

    /* Given a num and k , print k multiples of num. */
    static void getMultiple(int num,int k){

        if(k==0) return;          // base case
            
        getMultiple(num, k-1);        // recursive case
        System.out.print(num*k+", ");   // self work
    }
    // Time Coplexity = O(k)
    // Space Complexity = O(k)

    /* Given a number n. FInd the sum of natural number till
       n but alternate sign.*/
       static int sum(int n){

           if(n==1) return 1;   // base case

           if(n%2==0){
              return sum(n-1)-n; //recursive case + self work
           }else{
              return sum(n-1)+n;  //recursive case + self work
           }
       }
      // Time Coplexity = O(n)
      // Space Complexity = O(n)

    public static void main(String[] args) {
        
          //getMultiple(2,10);
         System.out.println(sum(5));
    }
}
