package Concepts;

class LCMGCD{
    //LCM and GCD
    public long lcm(long a,long b){
        return a*b/gcd(a,b);
    }
    public long gcd(long a,long b){
        if(a==0)return b;
        return gcd(b%a,a);
    }
    public static void main(String[] args) {
        
    }
}