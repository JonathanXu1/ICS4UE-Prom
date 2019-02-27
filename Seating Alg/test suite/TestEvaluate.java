import java.util.ArrayList;
import java.util.HashSet;

public class TestEvaluate {
	public static TestEvaluation eval(ArrayList<Table> tables, int tableSizeLimit, ArrayList<Student> students) {
		int n = students.size();
		int[] cnt = new int[n + 5];
		HashSet<String> seen = new HashSet<String>();
		int totkust = 0;
		int tot = 0, totsat = 0;
		int k = (n + tableSizeLimit - 1) / tableSizeLimit;
		for (Table t : tables) {
			System.out.println("TBL: ");
			if (t.getSize() > tableSizeLimit) {
				System.err.println("!! fail table size");
			}
			HashSet<String> intbl = new HashSet<String>();
			for (Student s : t.getStudents()) {
				System.out.println("  " + s.getStudentNumber());
				if (seen.contains(s.getStudentNumber())) {
					System.err.println("!! student assigned to two spots/tbls");
				}
				seen.add(s.getStudentNumber());
				intbl.add(s.getStudentNumber());
			}
			for (Student s : t.getStudents()) {
				int sat = 0;
				if (!s.getFriendStudentNumbers().isEmpty())
					totkust++;
				for (String f : s.getFriendStudentNumbers()) {
					if (intbl.contains(f)) {
						sat++;
						totsat++;
					}
					tot++;
				}
				cnt[sat]++;

			}
		}
		for (Student s : students)
			if (!seen.contains(s.getStudentNumber()))
				System.err.println("!! not all students assigned");
		int sum = 0;
		for (int i = cnt.length - 1; i > 0; i--) {
			sum += cnt[i];
			if (cnt[i] > 0) {
				System.out.printf("%d%% above %d\n", sum * 100 / totkust, i);
			}
		}
		System.out.printf("%d / %d = %d%% tables\n", tables.size(), k, tables.size() * 100 / k);
		System.out.printf("%d%% edge use\n", totsat * 100 / tot);
		TestEvaluation ev = new TestEvaluation();
		ev.satPercent = totsat / (double) tot;
		ev.singlePercent = sum / (double) totkust;
		ev.tableUse = tables.size() / (double) k;
		return ev;
	}
}
