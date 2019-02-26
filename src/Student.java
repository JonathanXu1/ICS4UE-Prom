/**
 * Student.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 18, 2019
 * Student class following UML standards
 **/
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
  }// End of constructor

  /**------------------------------------GETTERS------------------------------**/
  /**
   * getName
   * Returns the name of the student
   * @return String, name of the student
   */
  public String getName(){
    return this.name;
  }

  /**
   * getStudentNumber
   * Returns the student number
   * @return String, student's number
   */
  public String getStudentNumber(){
    return this.studentNumber;
  }

  /**
   * getDietaryRestrictions
   * Returns the student's dietary needs
   * @return ArrayList</String>, the student's dietary needs
   */
  public ArrayList<String> getDietaryRestrictions(){
    return this.dietaryRestrictions;
  }

  /**
   * getFriendStudentNumbers
   * Returns the student's friends
   * @return ArrayList</String>, the friends of the students
   */
  public ArrayList<String> getFriendStudentNumbers(){
    return this.friendStudentNumbers = friendStudentNumbers;
  }

  /**-----------------------------SETTERS------------------------------**/
  /**
   * setName
   * Sets the name of the student
   * @param name, String representing changed name
   * @return void, nothing to return
   */
  public void setName(String name){
    this.name = name;
  }

  /**
   * setStudentNumber
   * Sets the name of the student
   * @param studentNumber, String representing changed student number
   * @return void, nothing to return
   */
  public void setStudentNumber(String studentNumber){
    this.studentNumber = studentNumber;
  }

  /**
   * setDietaryRestrictions
   * Sets the name of the student
   * @param dietaryRestrictions, ArrayList of Strings for various diets
   * @return void, nothing to return
   */
  public void setDietaryRestrictions(ArrayList<String> dietaryRestrictions){
    this.dietaryRestrictions = dietaryRestrictions;
  }
  /**
   * setFriendStudentNumbers
   * Sets the name of the student
   * @param friendStudentNumbers, ArrayList of String for friends
   * @return void, nothing to return
   */
  public void setFriendStudentNumbers(ArrayList<String> friendStudentNumbers){
    this.friendStudentNumbers = friendStudentNumbers;
  }
}