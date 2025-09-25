package AllArraysList;

import java.util.ArrayList;
import java.util.*;


     // Write a program to reverse a arraylist
public class ArraysListProI {
    public static void main(String[] args) {
        
        ArrayList<Integer> myal = new ArrayList<>();
        myal.add(0);
        myal.add(10);
        myal.add(3);
        myal.add(5);
        myal.add(22);
        myal.add(10);
        
        System.out.println(myal);
        //reversList(myal);
        Collections.reverse(myal);
        System.out.println(myal);
    }  

    static void reversList(ArrayList<Integer> myal){
        int i=0,j=myal.size();

        while(i<j){

          //  Integer temp= myal.get(i);   NOT GOOD WAY
            Integer temp= Integer.valueOf(myal.get(i));
            myal.set(i, myal.get(j-1));
            myal.set(j-1,temp);   

            i++;
            j--;

        }
    }
}

