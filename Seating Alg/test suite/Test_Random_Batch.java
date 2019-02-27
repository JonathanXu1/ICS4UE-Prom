import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Test_Random_Batch {

	static SeatingProblem problem;

	public static void main(String[] args) {
		int[] nn = { 1, 10, 20, 100, 200, 500, 750, 1000 };
		int[] pp = { 1, 2, 3, 5, 10, 15, 20 };
		int[] tt = { 2, 3, 5, 10, 15, 20 };
		double[] bb = { 0, 0.1, 0.5, 0.8, 1 };
		for (double b : bb)
			for (int n : nn)
				for (int p : pp)
					if (p < n - 1)
						for (int t : tt)
							if (n > t) {
								String kkk = String.format("n=%d\np=%d\nt=%d\nb=%f\n", n, p, t, b);
								System.out.println(kkk);
								JOptionPane.showMessageDialog(null, kkk, "", JOptionPane.INFORMATION_MESSAGE);

								ArrayList<Student> r = TestGenerator.generate(n, p, b);

								SeatingAlg alg = new SeatingAlg();

								ArrayList<Table> s = alg.generateTables(r, t);

								try {
									TestEvaluate.eval(s, t, r);
								} catch (Exception e) {
									// TODO: handle exception
								}

								FloorPlan ppp = new FloorPlan();
								ppp.generateFloorPlan(s);
								ppp.displayFloorPlan();
							}
	}

}
