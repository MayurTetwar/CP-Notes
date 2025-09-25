package Recursion;
import java.util.*;

public class AllCombinationOfArray {

    static void getCombinationOfArray(int[] arr,int i,String str){
        if(i>=arr.length){
            System.out.println(str);
            return;
        }
        getCombinationOfArray(arr, i+1, str+" "+arr[i]);
        getCombinationOfArray(arr, i+1, str);
    }
    public static void main(String[] args) {
        int[] arr={5,-3,5};
        getCombinationOfArray(arr, 0,"");
    }

    /*
    // For get target value equal to arr combinations 

     static String save="";
    static void getCombinationOfArray(int[] arr,int i,int ans,String str,int target){
        if(i>=arr.length){
            if(ans==target){
                if(save.length()<str.length()){
                    save=str;
                }
            }
            return;
        }
        getCombinationOfArray(arr, i+1, ans&arr[i],str+" "+arr[i],target);
        getCombinationOfArray(arr, i+1, ans,str,target);
    }
    public static void main(String[] args) {
        
        int[] arr={15,10,12,13,14};
        int target =10;
        getCombinationOfArray(arr, 0,arr[0], "",target);
        System.out.println(save);
    }
     */
}
