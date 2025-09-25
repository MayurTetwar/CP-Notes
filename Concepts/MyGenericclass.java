package Concepts;

public class MyGenericclass {
    public static void main(String args[]) throws Exception{
     
        Integer arr1[]={1,2,3,4,5};
        Integer arr2[]={1,2,3,4,5};
        
        Mygeneric<Integer> obj1=new  Mygeneric<Integer>(arr1);  
        int sum1=obj1.addArrayint();   
        Mygeneric<Integer> obj2 =new Mygeneric<Integer>(arr2);
        int sum2=obj2.addArrayint();
        obj1.isEqual(sum1,sum2);     
        System.out.println("**************");
        Double arr3[]={1.1,2.2,3.3,4.4,5.5};
        Double arr4[]={1.2,2.1,3.3,4.4,5.5};
        
        Mygeneric<Double> obj3 =new Mygeneric<Double>(arr3);
        double sum3=obj3.addArraydouble();
        Mygeneric<Double> obj4 =new Mygeneric<Double>(arr4);
        double sum4=obj4.addArraydouble();
        obj3.isEqual(sum3,sum4);
    }
}
   
   class Unmatched extends Exception{
    
      Unmatched(String msg){
      super(msg);
      }
   }
   class Mygeneric <T extends Number>{
    
    T[] arr;
    int sumInt;
    double sumDouble;
   
    Mygeneric(T arr[]){
      this.arr=arr;
      }
      
    public int addArrayint(){
      System.out.print("Array :");
       for(int i=0; i< this.arr.length ; i++){
            System.out.print(arr[i]+" ");
            sumInt +=arr[i].doubleValue();
        }
     System.out.println(" Sum is: "+sumInt);
     return sumInt;
    } 
     
    public double addArraydouble(){
        System.out.print("Array :");
        for(int i=0; i< this.arr.length ; i++){
            System.out.print(arr[i]+" ");
            sumDouble += (double)arr[i];
        }
      System.out.println(" Sum is: "+ sumDouble);  
      return sumDouble;
    }
   
   public void isEqual(T sum1,T sum2) throws Exception{
     try{
       if(!sum1.equals(sum2)){
        throw new Unmatched("Your Sum of Array is Not Same!");
       }
       System.out.println("Your Sum of Array is Same");      
      }
     catch(Unmatched U){
     System.out.println(U);
     }
   }  
}

