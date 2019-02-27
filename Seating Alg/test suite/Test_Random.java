import java.util.ArrayList;

public class Test_Random {

	static SeatingProblem problem;

	static void test() {
//		int trial = 10;
		int n = 205, p = 5, t = 5;

//		double avgsat = 0, avgone = 0, avgt = 0;

		double b = 0;
//		for (int j = 0; j < trial; j++) {
		ArrayList<Student> r = TestGenerator.generate(n, p, b);

		SeatingAlg alg = new SeatingAlg();
		ArrayList<Table> l = alg.generateTables(r, t);
		TestEvaluate.eval(l, t, r);

		FloorPlan pp = new FloorPlan();
		pp.generateFloorPlan(l);
		pp.displayFloorPlan();
//			avgsat += e.satPercent;
//			avgone += e.singlePercent;
//			avgt += e.tableUse;
//		}
//		System.out.println("  sat=" + (int) (avgsat * 100 / trial));
//		System.out.println("  one=" + (int) (avgone * 100 / trial));
//		System.out.println("  tbl=" + (int) (avgt * 100 / trial));
	}

	public static void main(String[] args) {
		test();
	}

}
