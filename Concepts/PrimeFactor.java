package Concepts;

import java.util.*;

public class PrimeFactor {


    public static void main(String[] args) {
        
    }   
    public int getPrimeFactor(int num){
        List<Integer> primes=getPrime(num);
        int count=0;
        for(int p:primes){
            if(p*p>num)break;
            if(num%p!=0)continue;
            count++;
            while(num%p==0)num/=p;
        }
        if(num>1)count++;
        return count;
    }
    public List<Integer> getPrime(int num){
        List<Integer> list=new ArrayList<>();
        boolean[] visi=new boolean[num+1];
        for(int i=2;i<=num;i++){
            if(!visi[i]){
                list.add(i);
                for(long j=(long)i*i;j<=num;j+=i){
                    visi[(int)j]=true;
                }
            }
        }   
        return list;
    }
    
}
