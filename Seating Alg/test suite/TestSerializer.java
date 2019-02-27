import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;

public class TestSerializer {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		ArrayList<Student> kek = fromString(
				"rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAKdwQAAAAKc3IAB1N0dWRlbnSF70bxxxoxewIABEwAE2RpZXRhcnlSZXN0cmljdGlvbnN0ABVMamF2YS91dGlsL0FycmF5TGlzdDtMABRmcmllbmRTdHVkZW50TnVtYmVyc3EAfgADTAAEbmFtZXQAEkxqYXZhL2xhbmcvU3RyaW5nO0wADXN0dWRlbnROdW1iZXJxAH4ABHhwc3EAfgAAAAAAAHcEAAAAAHhzcQB+AAAAAAABdwQAAAABdAABMnh0AAFhdAABMHNxAH4AAnNxAH4AAAAAAAB3BAAAAAB4c3EAfgAAAAAAAHcEAAAAAHhxAH4ACXQAATFzcQB+AAJzcQB+AAAAAAAAdwQAAAAAeHNxAH4AAAAAAAB3BAAAAAB4cQB+AAl0AAEyc3EAfgACc3EAfgAAAAAAAHcEAAAAAHhzcQB+AAAAAAAAdwQAAAAAeHEAfgAJdAABM3NxAH4AAnNxAH4AAAAAAAB3BAAAAAB4c3EAfgAAAAAAAHcEAAAAAHhxAH4ACXQAATRzcQB+AAJzcQB+AAAAAAAAdwQAAAAAeHNxAH4AAAAAAAB3BAAAAAB4cQB+AAl0AAE1c3EAfgACc3EAfgAAAAAAAHcEAAAAAHhzcQB+AAAAAAABdwQAAAABdAABOXhxAH4ACXQAATZzcQB+AAJzcQB+AAAAAAAAdwQAAAAAeHNxAH4AAAAAAAB3BAAAAAB4cQB+AAl0AAE3c3EAfgACc3EAfgAAAAAAAHcEAAAAAHhzcQB+AAAAAAABdwQAAAABdAABMHhxAH4ACXQAAThzcQB+AAJzcQB+AAAAAAAAdwQAAAAAeHNxAH4AAAAAAAB3BAAAAAB4cQB+AAl0AAE5eA==");
		SeatingAlg alg = new SeatingAlg();
		ArrayList<Table> t = alg.generateTables(kek, 2);
		TestEvaluate.eval(t, 2, kek);
		FloorPlan p = new FloorPlan();
		p.generateFloorPlan(t);
		p.displayFloorPlan();
	}

	/** Read the object from Base64 string. */
	@SuppressWarnings("unchecked")
	public static ArrayList<Student> fromString(String s) throws IOException, ClassNotFoundException {
		byte[] data = Base64.getDecoder().decode(s);
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
		Object o = ois.readObject();
		ois.close();
		return (ArrayList<Student>) o;
	}

	/** Write the object to a Base64 string. */
	public static String toString(Serializable o) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(o);
		oos.close();
		return Base64.getEncoder().encodeToString(baos.toByteArray());
	}

}
