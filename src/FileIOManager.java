import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIOManager{
  public static void main(String args[]){
      final String temp = "temp.txt";
      ArrayList <Student> arrlis = new ArrayList<Student>();
      //Student test = new Student ("david","34",null,null);
      //arrlis.add(test);
      save(arrlis, temp);
      arrlis = load(temp);
      System.out.println(arrlis);
  }
  
  public static void save(ArrayList<Student> students, String tmp){
      try{
        BufferedWriter bw = new BufferedWriter (new FileWriter (tmp));
        for (int i = 0; i < students.size(); i++){
          bw.write(students.get(i).getName()+" ");
          bw.write(students.get(i).getStudentNumber()+" ");
          bw.write(students.get(i).getDietaryRestrictions()+" ");
          bw.write(students.get(i).getFriendStudentNumbers()+"\n");
        }
      bw.close();
    } catch (IOException e){
      e.printStackTrace();
    }
  }
  
  public static ArrayList<Student> load(String tmp){
    ArrayList <Student> students = new ArrayList<Student>();
    try{
      BufferedReader br = new BufferedReader(new FileReader(tmp));
        String currentLine, name, number;
        ArrayList<String> dietaryRestrictions = new ArrayList<String>();
        ArrayList<String> friendStudentNumbers = new ArrayList<String>();
        while ((currentLine = br.readLine()) != null){
          String[] tokens = currentLine.split(" ");
          name = tokens[0];
          number = tokens[1];
          String[] dRestrict = tokens[3].substring(1,tokens[3].length()).split(",");
          String[] frNumbers = tokens[4].substring(1,tokens[4].length()).split(",");
          for (int i = 0; i < dRestrict.length; i++){
           dietaryRestrictions.add(dRestrict[i]); 
          }
          for (int i = 0; i < frNumbers.length; i++){
           friendStudentNumbers.add(frNumbers[i]); 
          }
          Student temp = new Student(name,number,dietaryRestrictions,friendStudentNumbers);
          students.add(temp);
        }
          br.close();
        }catch (IOException e){
          e.printStackTrace();
        }
           return students;
  }
  
}