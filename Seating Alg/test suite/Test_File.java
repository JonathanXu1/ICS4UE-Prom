import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test_File {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Student> students = new ArrayList<Student>();
		Scanner in = new Scanner(new File("Kust.txt"));
		while (in.hasNext()) {
			students.add(parse(in.nextLine()));
		}
		in.close();
		SeatingAlg alg = new SeatingAlg();
		ArrayList<Table> t = alg.generateTables(students, 10);
		TestEvaluate.eval(t, 10, students);
//		ArrayList<Table> t = new ArrayList<Table>();
//		Table dd = new Table(10);
//		ArrayList<Student> ss = new ArrayList<Student>();
//		for (int i = 0; i < 10; i++) {
////			students.get(i).setName("s" + i
//			students.add(students.get(i));
//		}
//		dd.setStudents(ss);
//		t.add(dd);

		FloorPlan p = new FloorPlan();
		p.generateFloorPlan(t);
		p.displayFloorPlan();
	}

	private static Student parse(String in) {
		String[] part = in.split(",");
		// String[] diet = part[2].split(" ");
		String[] friends;
		ArrayList<String> cust;
		/*
		 * if (part.length<4||part[3].equals("")) { cust = new ArrayList<String>(); }
		 * else {
		 */
		friends = part[1].split(" ");
		cust = new ArrayList<String>(Arrays.asList(friends));
		ArrayList<String> derp = new ArrayList<String>();
		derp.add("Vegan");

		// }
//			return new Student(part[0], part[1], new ArrayList(Arrays.asList(diet)), cust);
		return new Student("s s" + part[0], part[0], derp, cust);
	}
}
