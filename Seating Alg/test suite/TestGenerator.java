import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestGenerator {
	public static ArrayList<Student> generate(int n, int p, double bidir) {
		ArrayList<Student> a = new ArrayList<Student>();
		ArrayList<HashSet<Integer>> c = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Student k = new Student("a a", "B b", new ArrayList<String>(), new ArrayList<String>());
			k.setStudentNumber(i + "");
			ArrayList<String> fk = new ArrayList<String>();
			k.setFriendStudentNumbers(fk);
			a.add(k);
			c.add(new HashSet<Integer>());
		}

		Random rg = ThreadLocalRandom.current();

		for (int i = 0; i < n; i++) {
			int kk = rg.nextInt(p + 1);
			HashSet<Integer> kusty = c.get(i);
			for (int j = 0; j < kk; j++) {
				int nxt;
				do {
					nxt = rg.nextInt(n);
				} while (nxt == i || kusty.contains(nxt));
				kusty.add(nxt);
				if (rg.nextDouble() < bidir)
					c.get(nxt).add(i);
			}
		}

		int ii = 0;
		for (HashSet<Integer> ss : c) {
			for (Integer sk : ss) {
				a.get(ii).getFriendStudentNumbers().add(sk + "");
			}
			ii++;
		}

		return a;
	}
}
