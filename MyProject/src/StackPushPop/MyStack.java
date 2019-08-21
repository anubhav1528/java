package StackPushPop;

public class MyStack {
	public char[] arr= new char[10];
	public int flag=0;
	public int temp;
	public MyStack() {
		
	}
	public void push(char value) {
	if(arr[9]!='\u0000') {
		System.out.println("Stack Overflow");
	}
	else if(flag==0) {
		arr[0]=value;
		flag++;
	}
	else {
		for(int i =flag-1;i>=0;i--) {
			arr[i+1]=arr[i];
		}
		arr[0]=value;
		flag++;
	}
	}
	public void pop() {
		
		
	}
	
	
}
