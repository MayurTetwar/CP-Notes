package Concepts;

import java.util.Scanner;

public class IntegerToWord {
    
  static Scanner sc=new Scanner(System.in);
  public static void main(String[] args) {
    
    System.out.println("Enter number:");
    int n=sc.nextInt();
    String num[]={""," One"," Two"," Three"," Four"," Five"," Six"," Seven"," Eight"," Nine"};
    String secOne[]={" Ten"," Eleven"," Twelve"," Thirteen"," Fourteen"," Fifteen"," Sixteen"," Seventeen"," Eighteen"," nineteen"};
    String secNum[]={""," Ten"," Twenty"," Thirty"," Fourty"," Fivety"," Sixty"," Seventy"," Eighty"," Ninety"};
    String place[]={"","",""," Hundred"," Thousand",""};

    StringBuilder str=new StringBuilder();
    //System.out.println(n);
    int digit=0;
    int D=0;
    long ten=1;
    int oriN=n;
    if(n==0){
      str.append("Zero");
      return;
    }
    int count=0;
    int count2=0;
    while (n>0) {
      D++;
      digit++;
      if(digit>3){
        digit=digit%3;
      }
      int last=n%10;
      ten=ten*10;
      
      if((D==4 || D==5 || D==6) && last!=0 && count==0){
        count++;
        str.insert(0," Thousand");
      }
      if((D==7 || D==8 || D==9) && last!=0 && count2==0){
        count2++;
        str.insert(0," Million");
      }
      if(D==10){
        str.insert(0," Billion");
      }
      if(last==0 && D!=1){
        n/=10;
        continue;
      } 
      
      if((D==4 || D==7) && last==1){
        if((n/10)%10==0)
          str.insert(0," One");
        else if((n/10)%10==1){
          str.insert(0, secOne[last]);
          n/=10;
          digit++;  
          D++;
        }else{
          str.insert(0, num[last]);
        }  
      }else if(((digit==1) && (oriN/ten)%10!=1)|| D==10){
        str.insert(0, num[last]);
      }else if((digit==1) && (oriN/ten)%10==1){
           str.insert(0, secOne[last]);
           n/=10;
           digit++;  
           ten*=10;
           D++;
      }else if(digit==2){
        str.insert(0, secNum[last]);
      }else if(digit==3){
        str.insert(0, place[digit]);
        str.insert(0, num[last]);
      }
      n/=10;
   }
   System.out.println(str.substring(1,str.length()));
  }    
}
