package Recursion;

import java.util.*;

public class CoinTose {

    static void getList(int n,String s){

        if(n==0){
            System.err.println(s);
            return;
        }
        if(s.length()==0){
            getList(n-1, s+"H");
            getList(n-1, s+"T");
            return;
        }
        if(s.charAt(s.length()-1)=='T'){
            getList(n-1, s+"H");
        }
        getList(n-1, s+"T");

    }
    public static void main(String[] args) {
        

     Scanner sc=new Scanner(System.in);
     getList(4, "");

    }
}
