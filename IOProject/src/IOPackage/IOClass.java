package IOPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOClass {
	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream(new File("sample.txt"));
		FileOutputStream out = new FileOutputStream(new File("sampleoutput.txt"));
		int c;
		while ((c = in.read()) != -1) {
			System.out.println(c);
			out.write(c);
		}
		in.close();
		out.close();
	}
}
