package Bit_Manipulation;

public class Tricks {
    public static void main(String[] args) {
        
        
    }
    // 1. Check if a number is Even or Odd
    public boolean isEven(int x){
        return (x & 1) == 0;
    }
    
    // 2. Check where ith bit is set
    public boolean isSet(int n,int i){
        return (n & (1 << i)) != 0;
    }
    
    // 3. Set ith bit 
    public int set(int n,int i){
        return n | (1 << i);
    }
    
    // 4. Unset ith bit 
    public int unSet(int n,int i){
        return n & (~(1 << i));
    }
    
    // 5. Set ith bit 
    public int togglebit(int n,int i){
        return n ^ (1 << i);
    }
    
    // 6. is power of 2 
    public boolean isTwoPow(int n){
        return (n>0) && ((n & (n-1)) == 0);
    }
    
    // 7. Brian Kernighan's Algorithm
    public int countSetBit(int n){
        int count = 0;
        while (n > 0) {
            n = n & (n - 1); // This clears the least significant bit
            count++;
        }
        return count;
        // OR
        // int count = Integer.bitCount(n);
    }
    
    // 8. XOR Tricks
    /*  // Swaping 2 numbers
        a = a ^ b;
        b = a ^ b; // b = (a^b)^b = a
        a = a ^ b; // a = (a^b)^a = b
    */
    
    // 9. Get MSB index
    public int getMSB(int n) {
        return 31-Integer.numberOfLeadingZeros(n);
    }

    // 10. Get LSB index
    public int getLSB(int n) {
        return Integer.numberOfTrailingZeros(n);
    }

    // 11. Differnt type of bit set 
    /*
    If you want the actual bit value (0/1) → use (num >> i) & 1.
    (Best for trie navigation where you need index 0 or 1.)
    If you just want to test if the bit is set → use num & (1 << i) and check if it’s != 0.
    (Best for boolean conditions.)
     */
}
