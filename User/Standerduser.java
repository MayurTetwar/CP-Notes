
import java.time.LocalDate;

class Standerduser extends User{
 
  String alias;
  LocalDate Datelog;
  String role;
 
  Standerduser(String name,String password,String mobile,boolean isActive,String gender,LocalDate Date,String alias,LocalDate Datelog,String role){
  super(name,password,mobile,isActive, gender, Date);
  this.alias= alias;
  this.Datelog= Datelog;
  this.role= role;
  }
   public void printUser(){
      
     super.printUserreal();
    System.out.println("alias:"+alias);
    System.out.println("Date of Last LogIn:"+Datelog);
    System.out.println("role:"+role);


   }
 
}


