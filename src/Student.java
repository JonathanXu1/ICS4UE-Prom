// Student class according to class UML standards
import java.util.ArrayList;
class Student {
  // Class variables
  private String name;
  private String studentNumber;
  private ArrayList<String> dietaryRestrictions;
  private ArrayList<String> friendStudentNumbers;
  // Constructor
  Student(String name, String studentNumber, ArrayList<String> dietaryRestrictions, ArrayList<String> friendStudentNumbers){
    this.name = name;
    this.studentNumber = studentNumber;
    this.dietaryRestrictions = dietaryRestrictions;
    this.friendStudentNumbers = friendStudentNumbers;
  }
  // Getters for information
  public String getName(){
    return this.name;
  }
  public void setName(String name){
    this.name = name;
  }
  public String getStudentNumber(){
    return this.studentNumber;
  }
  public void setStudentNumber(){
    this.studentNumber = studentNumber;
  }
  public ArrayList<String> getDietaryRestrictions(){
    return this.dietaryRestrictions;
  }
  public ArrayList<String> getFriendStudentNumbers(){
    return this.friendStudentNumbers = friendStudentNumbers;
  }
}