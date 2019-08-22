package IOBuffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferReadAndWrite {
public void encrpypt(String source, String dest, int shiftSize) throws IOException {
BufferedReader bufferreader;
BufferedWriter bufferwriter;
bufferreader = new BufferedReader(new FileReader(source));
bufferwriter = new BufferedWriter(new FileWriter(dest));
String line = bufferreader.readLine();
int data;
int countvowel=0;
while(line!= null) {
	for(int i=0; i< line.length();i++) {
		if(line.charAt(i)=='a'||line.charAt(i)=='e'||line.charAt(i)=='i'||line.charAt(i)=='o'||line.charAt(i)=='u') {
			 countvowel++;
		}
		data = (int)line.charAt(i)+shiftSize;
		bufferwriter.write(data);
	}
	bufferwriter.write(' ');
	bufferwriter.write(""+countvowel);
	bufferwriter.write('\n');
	countvowel=0;
	line = bufferreader.readLine();
}
bufferreader.close();
bufferwriter.close();
}
public void viewFileContent(String filename) throws IOException {
	BufferedReader reader;
	reader = new BufferedReader(new FileReader(filename));
	String Line = reader.readLine();
	while(Line!=null) {
		System.out.println(Line);
		Line = reader.readLine();
	}
	reader.close();
}

}
