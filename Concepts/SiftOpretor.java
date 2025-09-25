package Concepts;


class SiftOpretor {
    
    public static void main(String[] args) {

        int num= 1<<1;  // Shift binary numbers of x by y 
        // Ex. num= x << y ;
        // i.e 1 => 00001;
        //   1<<1 => 00010; // Shift by 1 
        
        // Below code to convert binary number to dicimal numbers by using each number in binary number
        System.out.println(num);
        num=num | 0;
        System.out.println(num);
        num=num<<1;
        System.out.println(num);
        num=num|1;
        System.out.println(num);
    }
}               
