import javax.swing.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class FileIOManager{
    private String directory;
    private  JFileChooser chooser;

    private TicketingSystem main;

    public FileIOManager(TicketingSystem main){
        this.main = main;
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File(System.getProperty("user.dir") + "/saves/"));
        chooser.setDialogTitle("Open a Project");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
    }

    public void createProject(String projectName, String tableSize){
        try {
            //Creates project folder
            this.directory = System.getProperty("user.dir") + "/saves/" + projectName;
            new File(this.directory).mkdirs();

            // Initializes storage files
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.directory + "/config.txt"));
            writer.write(tableSize);
            new File(this.directory + "/students.txt").createNewFile();
            new File(this.directory + "/groups.txt").createNewFile();

            writer.close();
        } catch (IOException e){
            System.out.println("Error creating project");
        }
    }

    public boolean loadProject(){
        boolean selected = true;

        if (chooser.showOpenDialog(main) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " +  chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : " +  chooser.getSelectedFile());

            String selection = chooser.getSelectedFile().getAbsolutePath();
            this.directory = selection;
        }
        else {
            System.out.println("No Selection ");
            selected = false;
        }

        return selected;
    }

    public String[] getProject() {
        // Return project configs
        String[] output = new String[2];
        // Project Name
        output[0] = directory.substring((System.getProperty("user.dir") + "/saves/").length());
        // Table size
        try {
            BufferedReader configReader = new BufferedReader(new FileReader(this.directory + "/config.txt"));
            output[1] = configReader.readLine();
            configReader.close();
        } catch(IOException e){
            System.out.println("Can't open readers");
        }

        return output;
    }

  public void saveStudents(ArrayList<Student> students){
      try{
        BufferedWriter bw = new BufferedWriter (new FileWriter (directory + "/students.txt"));
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
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/saves/" + projectName + "/saves/students.txt"));
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