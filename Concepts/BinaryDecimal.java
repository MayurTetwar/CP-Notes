package Concepts;

import java.util.*;

 class BinaryDecimal
 {
  long decimalNum=0,sb, twopow=1,sd, dn;
  long binaryNum=0 ,tenpow=1;
   public static void main(String args[])
   {
     Scanner sc= new Scanner(System.in);
     BinaryDecimal obj=new BinaryDecimal();
     /*
     System.out.println("Enter binary number :" );
     int bn=sc.nextInt();     
     obj.binaryTodecimal(bn);
     */
      
     System.out.println("Enter decimal number :" );
     long dn=sc.nextLong();
     obj.decimalTobinary(dn);
     sc.close();
   }  
    
    public void binaryTodecimal(long bn){
     
       while(bn>0){
       sb=bn%10;
       if(sb==1)
       decimalNum=decimalNum+twopow;     
     
       twopow=twopow*2;
       bn=bn/10;    
      }
     System.out.println("Decimal number is :"+decimalNum); 
   }
   public void decimalTobinary(long dn){
     
    while(dn>0){         
     sd = dn % 2;            // 1 % 2 = 1 , 3 % 5 = 5
     binaryNum = binaryNum+(sd*tenpow);    
     tenpow=tenpow*10;
     dn = dn /2;        
     }
     System.out.println(binaryNum);
   }
 }