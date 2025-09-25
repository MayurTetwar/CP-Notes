package Concepts;

import java.util.*;

  class MyProject{
   static Scanner sc ;
   static ArrayList<Product> menu;
   
   public static void main(String args[]){ 
     
    sc = new Scanner(System.in);
    menu = new ArrayList<>();
    
    menu.add(new Product(1,"Rasgulla    ",50));
    menu.add(new Product(2,"Masala Tea  ",15));
    menu.add(new Product(3,"Kulfi       ",25));
    menu.add(new Product(4,"Lassi Yogurt",30));
    menu.add(new Product(5,"Pani Puri   ",25));
    menu.add(new Product(6,"Chana Masala",60));
    menu.add(new Product(7,"Samosa      ",30));
    menu.add(new Product(8,"Biriyani    ",90));
    menu.add(new Product(9,"Dosa        ",40));
    menu.add(new Product(10,"Veg Thali   ",120));
   
    Product pro=new Product();   
    pro.dispalyInfo(menu);
    System.out.println( );
    
     while(true){
     System.out.println("1. Show by price");
     System.out.println("2. Show by name");
     System.out.println("3. Buy dishes");
     System.out.println("4. Exit");
     int num_sel=sc.nextInt();
     System.out.println( );
   
     switch(num_sel){
        case 1:
          Collections.sort(menu, new Sortbyprice());
          pro.dispalyInfo(menu);
          break;
        case 2:
          Collections.sort(menu, new Sortbyname());
          pro.dispalyInfo(menu);
          break;
        case 3:
          pro.BuyDish(menu);
          break;
        case 4:
          System.out.println("Thank you! ");
          System.exit(0);
         default:
          System.out.println("Invalid option. Please try again.");
          break; 
         }
         System.out.println( );
        }
      }
   }

class Product{
  String name;
  double price;
  int nopro;
  Scanner sc = new Scanner(System.in);
     
  
  Product(){}
  Product(int nopro, String name, double price){
    this.nopro=nopro;
    this.name=name;
    this.price=price;
  }
  
  @Override
  public String toString() {
        return name+"  "+price;
    }
  
  public void dispalyInfo(ArrayList<Product> menu){
   int i=1;
     System.out.println( "**************************");
     System.out.println("Menu:");
     for(Product x : menu){
       System.out.println(i+". "+x);
       i++;
      }
     System.out.println( "**************************");
   }
     
  public void BuyDish(ArrayList<Product>menu) 
  {
   
    System.out.println("Enter the number of dishes you want to buy:");
      while(true){
        try{
        System.out.println("Or Enter 0 To Exit! ");
        int numdish = sc.nextInt();
        if(numdish!=0){ 
          if (numdish > 0 && numdish <= menu.size()) {
              System.out.println("Enter the numbers of the dishes (1-" + menu.size() + ") with space between them:");
              int[] chosenDishes = new int[numdish];

              for (int i = 0; i < numdish; i++) {
                    chosenDishes[i] = sc.nextInt();
                 }

               double totalPrice = 0;
               System.out.println("You choose the following dishes:");

              for (int dishIndex : chosenDishes) {
                  if (dishIndex >= 1 && dishIndex <= menu.size()) {
                       Product chosenDish = menu.get(dishIndex - 1); 
                       System.out.println(chosenDish);
                      totalPrice += chosenDish.price;  
                    } else {
                  System.out.println("Invalid dish number: " + dishIndex);
                   }
                }
              System.out.println( );
              System.out.println("Total price: " + totalPrice);
              System.out.println("Enter Above Total Amount: ");
         
              while(true){
                  int userTotal= sc.nextInt();
                    if(userTotal<totalPrice){
                         System.out.println("Enter More Amount equal to "+totalPrice);
                    }else if(userTotal>totalPrice){
                         System.out.println("Enter Less Amount equal to "+totalPrice);
                    }else{
                         System.out.println("Thanks For Buying!");
                     break;
                    }  
                }
            }else 
            System.out.println("Invalid Number Of dishes. Please enter a number between 1 and " + menu.size());
        }else
          EndProgram();  
        }catch(Exception e){
          System.out.printf("Enter Only Number");
        }
      }
   }
   public static void EndProgram(){
       System.out.println( "Thank You For Visit!!");
       System.exit(0);
   }
}

class Sortbyprice implements Comparator<Product>{
    public int compare(Product a, Product b){
     return (int)a.price- (int)b.price;
    }
}
 
class Sortbyname implements Comparator<Product>{
    public int compare(Product a, Product b){
     return a.name.compareTo(b.name);
    }
}  