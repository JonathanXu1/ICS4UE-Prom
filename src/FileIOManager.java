// Stores or recalls information into saves folder
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;

public class FileIOManager{
    // Class variables
    private String directory;
    private  JFileChooser chooser;

    private TicketingSystem main;

    // Constructor
    public FileIOManager(TicketingSystem main){
        this.main = main;
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File(System.getProperty("user.dir") + "/saves/"));
        chooser.setDialogTitle("Open a Project");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
    }
    // Creates new project in saves
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
            e.printStackTrace();
        }
    }

    // Loads previous project saved
    public boolean loadProject(){
        boolean selected = true;

        if (chooser.showOpenDialog(main) == JFileChooser.APPROVE_OPTION) {
            //System.out.println("getCurrentDirectory(): " +  chooser.getCurrentDirectory());
            //System.out.println("getSelectedFile() : " +  chooser.getSelectedFile());
            boolean isValid = new File(chooser.getSelectedFile(), "config.txt").exists();
            if(isValid){
                String selection = chooser.getSelectedFile().getAbsolutePath();
                this.directory = selection;
            } else {
                JOptionPane.showMessageDialog(chooser, "Invalid folder. Please select a valid project folder.");
                selected = false;
            }

        }
        else {
            System.out.println("No Selection ");
            selected = false;
        }

        return selected;
    }
    //Returns students and table size from project
    public String[] getProject() {
        // Return project configs
        String[] output = new String[3];
        // Project Name
        output[0] = directory.substring((System.getProperty("user.dir") + "/saves/").length());
        // Table size
        try {
            BufferedReader configReader = new BufferedReader(new FileReader(this.directory + "/config.txt"));
            output[1] = configReader.readLine();
            configReader.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        // Student size
        output[2] = Integer.toString(loadStudents().size());
        // Groups

        return output;
    }
    // Stores groups into file
    public void saveGroups(ArrayList<Table> tables){
        try{
            BufferedWriter bw = new BufferedWriter (new FileWriter (directory + "/groups.txt"));
            for (int i = 0; i < tables.size(); i++){
                bw.write(tables.get(i).getStudents().size() + "\t");
                for (int j = 0; j < tables.get(i).getStudents().size(); j++){
                    bw.write(tables.get(i).getStudents().get(j).getName() + "\t");
                    bw.write(tables.get(i).getStudents().get(j).getStudentNumber() + "\t");
                    bw.write(tables.get(i).getStudents().get(j).getDietaryRestrictions() + "\t");
                    bw.write(tables.get(i).getStudents().get(j).getFriendStudentNumbers()+"\t");
                }
                bw.write("\n");
            }
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // Loads tables out of file
    public ArrayList<Table> loadTablesfromFile() {
        String[] projectInfo = getProject();
        ArrayList<Table> tables = new ArrayList<Table>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(directory + "/groups.txt"));
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                String[] tokens = currentLine.split("\t");
                tables.add(new Table(Integer.parseInt(tokens[0])));
                tables.get(tables.size()-1).setStudents(loadStudentsFromGroup(tokens));
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return tables;
    }
    // Loads students out of a group
    public ArrayList<Student> loadStudentsFromGroup(String[] tableInfo){
        ArrayList <Student> students = new ArrayList<Student>();
        int quantity = Integer.parseInt(tableInfo[0]);
        String name, number;

        for (int i = 1; i < quantity*4; i+=4) {
            name = tableInfo[i];
            number = tableInfo[i + 1];
            String[] dRestrict = tableInfo[i + 2].substring(1, tableInfo[i + 2].length() - 1).split(", ");
            String[] frNumbers = tableInfo[i + 3].substring(1, tableInfo[i + 3].length() - 1).split(", ");
            ArrayList<String> dRestrictions = new ArrayList<String>(Arrays.asList(dRestrict));
            ArrayList<String> friNumbers = new ArrayList<String>(Arrays.asList(frNumbers));
            students.add(new Student(name, number, dRestrictions, friNumbers));
        }
        return students;
    }

    // Stores students into file
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

    // Loads student information from file
    public ArrayList<Student> loadStudents(){
        ArrayList <Student> students = new ArrayList<Student>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(directory + "/students.txt"));
            String currentLine, name, number;

            while ((currentLine = br.readLine()) != null){
                String[] tokens = currentLine.split("\t");
                name = tokens[0];
                number = tokens[1];
                String[] dRestrict = tokens[2].substring(1,tokens[2].length()-1).split(", ");
                String[] frNumbers = tokens[3].substring(1,tokens[3].length()-1).split(", ");
                ArrayList<String> dRestrictions = new ArrayList<String>(Arrays.asList(dRestrict));
                ArrayList<String> friNumbers = new ArrayList<String>(Arrays.asList(frNumbers));
                students.add(new Student(name,number,dRestrictions,friNumbers));
            }

            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return students;
    }
}