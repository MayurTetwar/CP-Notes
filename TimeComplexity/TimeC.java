package TimeComplexity;

// Calulting time complexity 
// Here we always take wrost case

public class TimeC {

    public static void main(String[] args) {
        f5(21);
    }

    public void f1(int[] arr){
       int n=arr.length;          // 1 opretion
       for(int i=0/* 1 opretion */;i<n;i++){
        System.out.println(arr[i]);      // 3*n opretion
       }
    }
    // Total 3n+2 ~~ n 
    // Time Complexity is O(n)

    public void f2(int arr[],int brr[]){
        int n=arr.length;
        int m=brr.length;          // Egnore small opretions

        for(int i=0;i<n;i++){
            System.out.println(arr[i]);   // n opretions
        }

        for(int i=0;i<m;i++){
            System.out.println(brr[i]);  // m opretions 
        }
    }
    // Total is n+m
    // Time Complexity is O(n+m)

    // Time Complexity for nested loops
    public static void f3(int n){

        for(int i=0;i<n;i++){                    // 1 loop has n itretions
            for(int j=0;j<n;j++){                       // n loops has n*n itretions
              System.out.print("Happy Brithday!   ");
            }
            System.out.println();
        }
    }
    // OverAll n*n opretions are done 
    // Time complexity is O(n^2)

    public static void f4(int n){

        for(int i=0;i<n;i++){                     
            for(int j=0;j<i;j++){                       
              System.out.print("Happy Brithday!  ");
            }
            System.out.println();
        }
    }    
        // i=0
        // i=1 , j=0        // 1 opertion 
        // i=2 , j=0,1      // 2 opretion
        // i=3 , j=0,1,2    // 3 opretion
        // if n=4 So total opretions are 1+2+3+4 (Here 4 for outer loop)
        // OverAll opertions are n(n+1)/2 ~~ n*n
        // Time Conplexity is O(n^2)

        // Now same above problem for j<sqrt(n) { Math.sqrt(n) }
        // Foe each loop sqrt(n) opretion are done
        // OvearAll n*sqrt(n) opretions 
        // Time Complexity is O(n*sqrt(n))

    public static void f5(int N){
        int count=0;
        for(int i=1;i<N;i*=2){
            count++;
        }
    }
    // first find relation between no. of iteration and i
    // here is (k+1) iteration than value of i is 2^k
    // and k<log(N)    
    // Time complexity is O(log(N))
    // In Notes get clear answer

    public static void f6(int N,int k){
        int val=0;
        for(int i=1;i<N;i*=k){
            val++;
        }
    }
    // Using above concepet 
    // first find relation between no. of iteration and i
    // here is (m+1) iteration than value of i is k^m
    // and m<log(N) with base k   
    // Time complexity is O(log(N)) Here we can ignore base k

}
