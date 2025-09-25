import java.time.LocalDate;

class Customuser extends User{
 
  String email;
  int securitykey;
  String Manager;
 
  Customuser(String name,String password,String mobile,boolean isActive,String gender,LocalDate Date,String email,int securitykey,String Manager){
  super(name,password,mobile,isActive, gender, Date);
  this.email= email;
  this.securitykey= securitykey;
  this.Manager= Manager;
  }
  public void printUser(){

    super.printUserreal();
    System.out.println("Email:"+email);
    System.out.println("security:"+securitykey);
    System.out.println("Manager:"+Manager);

  }
}
