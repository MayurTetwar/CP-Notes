package Strings;
import java.time.LocalDate;

public class StringMethods {
       public static void main(String args[])
   { 
    StringBuilder s=new StringBuilder();
        s.append("dj");
        s.insert(0, "Hi "); 
        // Insert at First

   String name="MayurTetwar";
  System.out.println(name.toUpperCase());
   //MAYURTETWAR
  System.out.println(name.toLowerCase());
   //mayurtetwar
  System.out.println(name.indexOf("a"));
   //1
  System.out.println(name.charAt(5));
   //T
  System.out.println(name.substring(0,2));
   //Ma
  System.out.println(name.contains("Tetwar"));
   //True
  System.out.println(name.equals("MayuTetwar"));
   //False
   LocalDate date=LocalDate.of(2023,12,22);
   System.out.println(date);
   //2023-12-22
  }
}
