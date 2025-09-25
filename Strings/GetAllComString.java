package Strings;
import java.util.*;

public class GetAllComString {

    static Scanner sc=new Scanner(System.in);

    static void getCombination(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }   
        getCombination(str.substring(1),ans+str.charAt(0));
        getCombination(str.substring(1), ans);
    }
    public static void main(String[] args) {
        
        String s=sc.nextLine();
        getCombination(s,"");
        System.out.println();
    }
}
