package Sorting;
import java.util.*;

class BucketSort{

     /* Printing method */
     static void printArr(float arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    static void bucketSort(float arr[]){
        int n=arr.length;
        // buckets
        ArrayList<Float>[] buckets=new ArrayList[n];
        // create empty buckets
        for(int i=0;i<n;i++){
            buckets[i]=new ArrayList<Float>();
        }

        // add element in buckets
        for(int i=0;i<n;i++){
            int bucketIndex= (int)arr[i]*n;
            buckets[bucketIndex].add(arr[i]);   
        }
        // sort each bucket individualy
        for(int i=0;i<buckets.length ;i++){
         Collections.sort(buckets[i]);
        }
        // merge all bucket to get final sorted array
        int index=0;
        for(int i=0;i<buckets.length;i++){
            ArrayList<Float> currBucket = buckets[i];
            for(int j=0;j<currBucket.size();j++){
                arr[index++]=currBucket.get(j);
            }
        }
    }
    public static void main(String[] args) {
        float arr[]={0.5f,0.4f,0.3f,0.2f,0.1f};
        bucketSort(arr);
        printArr(arr);
    }
}