package letrasExtremas;

import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) {
		LetraExtrema le = new LetraExtrema("1");
		try {
			le.obtenerLetraExtrema();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
