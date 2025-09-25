// Main Program
import java.time.*;

class UserDemo{

 public static void main(String []args){
    
     LocalDate datefix = LocalDate.of(2000, 1, 1);

 
  User []userarray = {
       new Standerduser("Tejas",
       "abc","123456789",true,"male",LocalDate.of(2005, 10 , 17)
       ,"Teju",LocalDate.of(2022, 4, 11),"Boss"),
       new Standerduser("sayra","def","6756749768",
       false,"female",LocalDate.of(2005, 11 , 7), "kushi",LocalDate.of(2022, 5, 5),"Employee"),
       new Standerduser("Siya","ghi","9876543210",false,"female",LocalDate.of(2006, 10 , 21),
       "Si",LocalDate.of(2022, 1, 1),"Employee"),
       new Customuser("Priya", "jkl","9876567890",true,"female",
       LocalDate.of(1997, 5, 22),"Priya@gmail.com",1997,"Rohan"),
       new Customuser("Mayur", "mno","9876785674",true,"male",LocalDate.of(1999, 11, 5),
       "mayur@gmail.com",2005,"Mayur"),
       new Customuser("Harsh", "pqr","2345263745",true,"male",
       LocalDate.of(2005, 1 , 7) ,"Harsh@gmail.com",2004,"All"),
            };
       
   System.out.println("Standerd User is:");        
   for( User U : userarray){
   if(U instanceof Standerduser && U.gender.equals("female")){
    U.printUser();
    System.out.println();
    }
   }
   System.out.println("Custom User is:");
   for( User U : userarray){
   if(U instanceof Customuser && datefix.isAfter(U.Date) && ((Customuser)U).email.contains("gmail.com")){
    U.printUser();
    System.out.println();
    }
   }
   
 }
}