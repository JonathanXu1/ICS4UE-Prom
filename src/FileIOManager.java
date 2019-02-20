import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class FileIOManager{
    public void createProject(String projectName){
        new File("/path/" + projectName).mkdirs();
    }
  public void saveStudents(ArrayList<Student> students, String projectName){
      try{
        BufferedWriter bw = new BufferedWriter (new FileWriter ("/saves/" + projectName + "students.txt"));
        for (int i = 0; i < students.size(); i++){
          bw.write(students.get(i).getName()+"\t");
          bw.write(students.get(i).getStudentNumber()+"\t");
          bw.write(students.get(i).getDietaryRestrictions()+"\t");
          bw.write(students.get(i).getFriendStudentNumbers()+"\n");
        }
      bw.close();
     }catch(IOException e){
      e.printStackTrace();
     }
  }
  public ArrayList<Student> loadStudents(String projectName){
    ArrayList <Student> students = new ArrayList<Student>();
      try{
        BufferedReader br = new BufferedReader(new FileReader("/saves/" + projectName + "/saves/students.txt"));
        String currentLine, name, number;
        ArrayList<String> dietaryRestrictions = new ArrayList<String>();
        ArrayList<String> friendStudentNumbers = new ArrayList<String>();
        while ((currentLine = br.readLine()) != null){
          String[] tokens = currentLine.split("\t");
          name = tokens[0];
          number = tokens[1];
          String[] dRestrict = tokens[2].substring(1,tokens[2].length()-1).split(", ");
          for (int i = 0; i < dRestrict.length; i++){
           dietaryRestrictions.add(dRestrict[i]); 
          }
          String[] frNumbers = tokens[3].substring(1,tokens[3].length()-1).split(", ");
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