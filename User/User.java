import java.time.LocalDate;
class User{

 String name,password;
 String mobile;
 boolean isActive;
 String gender;
 LocalDate Date;
 
 User(String name,String password,String mobile,boolean isActive,String gender,LocalDate Date){
  this.name= name;
  this.password=password;
  this.mobile= mobile;
  this.isActive=isActive;
  this.gender = gender;
  this.Date = Date;
 }
 public void printUser(){} 
 final void printUserreal(){
 System.out.println("Name:"+name+"  Password:"+password+
                  "\nMobileNo.:"+mobile+"  Is Active : "+isActive+
                  "\ngender:"+gender+"  Date:"+Date);
 }
 
}