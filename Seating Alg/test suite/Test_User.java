import java.util.ArrayList;
import java.util.Scanner;

public class Test_User {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.print("n?");
			int n = s.nextInt();
			System.out.print("p?");
			int p = s.nextInt();
			System.out.print("t?");
			int t = s.nextInt();
			System.out.print("bi?");
			double b = s.nextDouble();

			System.out.print("genning...");
			ArrayList<Student> r = TestGenerator.generate(n, p, b);
			System.out.println("done");

			SeatingAlg alg = new SeatingAlg();
			System.out.print("calcing...");
			ArrayList<Table> res = alg.generateTables(r, t);
			System.out.println("done");
//			TestEvaluate.eval(res, t, r);

			FloorPlan pp = new FloorPlan();
			pp.generateFloorPlan(res);
			pp.displayFloorPlan();
		}
//		s.close();
	}

}
