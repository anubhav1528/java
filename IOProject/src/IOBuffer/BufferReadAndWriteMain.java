package IOBuffer;

import java.io.IOException;

public abstract class BufferReadAndWriteMain {
static BufferReadAndWrite obj = new BufferReadAndWrite();
public static String source="source.txt";
public static String dest="dest.txt";
public static int shiftSize=4;
public static void main(String[] args) throws IOException {
	obj.encrpypt(source, dest, shiftSize);
	obj.viewFileContent(dest);
	
	
}
}
