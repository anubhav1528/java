package ArrayDemo;

public class Tester {
public static void main(String[] args) {
	Arraydemo arraydemoobj = new Arraydemo();
	arraydemoobj.createArray(26);
	//System.out.println(arraydemoobj.getArray());
	char[] arr=arraydemoobj.getArray();
	for(int i=0;i<arr.length;i++) {
	System.out.print(arr[i]+" ");
	}
}
}
