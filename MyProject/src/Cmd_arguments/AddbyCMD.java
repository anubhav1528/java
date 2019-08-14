package Cmd_arguments;

public class AddbyCMD {
public static void main(String[] args) { 
int sum=0;
for(String a:args) {
	try {
		
	}catch(NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
	}
sum=Integer.parseInt(args[0])+Integer.parseInt(args[1]);       
}
System.out.println(sum);
}
}
