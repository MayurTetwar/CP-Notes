package AllArraysList;
import java.util.ArrayList;
import java.util.Collections;

// Write a program to sort an ArrysList of Strings in desending order.
public class ArraysListProII {
    public static void main(String[] args) {
        
      ArrayList<String> StringList= new ArrayList<>();
      StringList.add("Sandhya");
      StringList.add("Siya");
      StringList.add("Neha");
      StringList.add("Kanchan");
      StringList.add("Priya");
      StringList.add("Somya");

      System.out.println("Orignal ArrayList : "+StringList);
       /*   Method-1  */
       Collections.sort(StringList);      // Get In asending order 
       Collections.reverse(StringList);   // Get In desending order 
       System.out.println("Desending Order M1 : "+StringList);

       /*   Method-2  */
      Collections.sort(StringList, Collections.reverseOrder() /* this is comparator */ );
      System.out.println("Desending Order M2 : "+StringList);

    }

    // static void reversListString(ArrayList<String> StringList){
    //     int i=0,j=StringList.size();

    //     while(i<j){

    //         String temp= StringList.get(i);
    //         StringList.set(i, StringList.get(j-1));
    //         StringList.set(j-1,temp);   

    //         i++;
    //         j--;

    //     }
    // }
}