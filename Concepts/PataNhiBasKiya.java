package Concepts;

import java.util.* ;

public class PataNhiBasKiya {

    static class Pair{
        int index1;
        int index2;
        int value;
        Pair(int index1,int index2){
            this.index1=index1;
            this.index2=index2;
        }
    }
    
    public static void main(String[] args) {  
        
        int[] arr = {1,2,1,2,6,7,5,1};
        int  k = 2;
        int n=arr.length;
        int[] pre=new int[n];
        pre[0]=arr[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+arr[i];
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
        @Override
        public int compare(Pair a, Pair b) {
            //if(a.index1==0)return -1;
            //if(b.index1==0)return 1;
            int sec1=a.index1;
            int val1=0;
            if(sec1>0){
                val1=pre[sec1-1];
            } 
            int sec2=b.index1;
            int val2=0;
            if(sec2>0){
                val2=pre[sec2-1];
            }
            //a.value=pre[a.index2]-val1;
            
            if((pre[a.index2]-val1)>(pre[b.index2]-val2)){
                return -1;
            }
            if((pre[a.index2]-val1)==(pre[b.index2]-val2)){
                if(a.index1>b.index1){
                    System.out.println(a.index1+" "+b.index1);
                    return 1;
                }
                System.out.println(a.index1+" "+a.index2+" "+b.index1+" "+b.index2);
                return -1;
            }
            return 1;
        }
        });
        for(int i=0;i<n-k+1;i++){
            pq.add(new Pair(i,i+k-1));
        }
        System.out.println();
        for(Pair p:pq){
    System.out.println(p.index1+" "+p.index2);
        }
        //List<int[]> list=new ArrayList<>();
        int num1=0,num2=Integer.MAX_VALUE,num3=Integer.MAX_VALUE;
        int sum=-1;
        k=n;
        while(k-->0){
            int left=n,right=-1;
            int[][] let=new int[][]{{Integer.MAX_VALUE,0},{Integer.MAX_VALUE,0},{Integer.MAX_VALUE,0}};
            int i=0;
            for(Pair p:pq){
                if(i>=3)break;
                if((p.index1<left && p.index2<left)||(p.index1>right && p.index2>right)){
                    left=Math.min(left,p.index1);
                    right=Math.max(right,p.index2);
                    let[i][0]=p.index1;
                    System.out.println(let[i][0]+" "+p.index2+" ji");
                    let[i][1]=pre[p.index2]-((p.index1==0)?0:pre[p.index1-1]);
                    i++;
                }
            }
            Arrays.sort(let,(a,b)->Integer.compare(a[0],b[0]));
            int newSum=let[0][1]+let[1][1]+let[2][1];
    System.out.println(let[0][0]+" "+let[1][0]+" "+let[2][0]+" "+sum+" "+newSum);
            if((let[0][0]<=num1 && let[1][0]<=num2 && let[2][0]<=num3)||(sum<newSum)){
                num1=let[0][0];
                num2=let[1][0];
                num3=let[2][0];
                sum=newSum;
            }
            System.out.println();
            //Pair pl=pq.poll();
            pq.poll();
            //pq.add(new Pair(pl.index1, pl.index2));
            // for(Pair p:pq){
            //   System.out.println(p.index1+" "+p.index2);
            // }
            System.out.println();
        }
System.out.println(num1+" "+num2+" "+num3);
    }
}


