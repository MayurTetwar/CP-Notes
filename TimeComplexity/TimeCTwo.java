package TimeComplexity;

public class TimeCTwo {
    
    // Calculate time Complexty of given code
    void f1(int n){
        int val=0;
        for(int i=1;i<=n;i*=2){
           val++;
        }
    }
    // NO.of iteration | i value
    // --------------------------
    //          1      |    1   -> 2^1-1
    //          2      |    2   -> 2^2-1
    //          3      |    4   -> 2^3-1
    //          :      |    :
    //          :      |    :
    //        K+1      |   2^k

    // Hence TC is O(K+1), nut we have to find in terms of inputs that is N
    // Using condition i<=n  ->   2^k<N
    // k=log(N)
    // Time Complexity is O(log(N))  // ignor +1

    void f2(int n){
        int val=0;
        for(int i=1;i<=n;i+=i){
            val++;
        }
    }
    // All Solution is same as Above f1 problem 
    // But one more time
    // NO.of iteration | i value
    // --------------------------
    //          1      |    1   -> 2^1-1
    //          2      |    2   -> 2^2-1
    //          3      |    4   -> 2^3-1
    //          :      |    :
    //          :      |    :
    //        K+1      |   2^k

    // Hence TC is O(K+1), nut we have to find in terms of inputs that is N
    // Using condition i<=n  ->   2^k<N
    // k=log(N)
    // Time Complexity is O(log(N))  // ignor +1

    static void f3(int n){
        int val=0;
        for(int i=1;i<=n;i*=2){
            for(int j=1;j<=i;j++){
                val++;
            }
        }
    }
    //This problem ans is in the notes having f3 mark
    //The outer loop is similar to f1 loop so it has same TimeComplexity 
    // TIme Complexity of above code is O(n)

    static void f4(int n){
        int val=0;
        for(int i=1;i<=n;i*=2){
            for(int j=n;j>i;j--){
                val++;
            }
        }
    }
    // A) O(log(n))         B) O(n)   
    // C) O(nlog(n))        D) None

    // The complete answer in notes having mark F4
    // Time complexity is C)O(nlog(n))

    static void f5(int n){
        int val=0;
        for(int i=n;i>0;i/=2){
            for(int j=0;j<i;j++){
                val++;
            }
        }
    }
    //  A) O(log(n))         B) O(n)   
    //  C) O(nlog(n))        D) None

    // The complete answer in notes having mark F5
    // Time complexity is B)O(n)

    void f6(int n){
        int val=0;
        for(int i=2;i<=n;i*=i){
            val++;
        }
    }
    // The complete answer in notes having mark F6
    // Time complexity is log(log(n))
}
