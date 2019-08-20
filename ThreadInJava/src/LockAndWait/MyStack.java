package LockAndWait;

public class MyStack {
	private int index = -1;
	private int max = 26;
	private char[] chararray = new char[max];
	public synchronized void push(char item) throws InterruptedException {
		if(index==max-1) {
			System.out.println("stack overflow");
			System.out.println("producer is waiting");
			index--;
			wait();
		}
		else if(true) {
		chararray[++index]=item;
		System.out.println("item "+item+" is pushed and consumer is notified--"+index);
		notify();
	}
		}
	public synchronized char pop() throws InterruptedException {
		if(index==-1) {
			System.out.println("stack underflow");
			System.out.println("consumer is waiting");
			wait();
		}
		System.out.println("item "+chararray[index]+" is popped and producer is notified");
		notify();
		return chararray[index--];
	}
}
