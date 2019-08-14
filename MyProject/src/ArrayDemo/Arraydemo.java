package ArrayDemo;

public class Arraydemo {
public char arr[];
public Arraydemo() {}
public void createArray(int size) {
	arr=new char[size];
	for(int i=0;i<arr.length;i++) {
		arr[i]=(char)('a'+i);
	}
}
public char[] getArray() {
	return arr;
}
 }
