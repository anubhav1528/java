package LockAndWait;

public class ProducerConsumerTester {
	private final static MyStack myStack=new MyStack();

	public static void main(String[] args) throws InterruptedException {
		
		Thread prodThread = new Thread(new StackProducer(myStack), "Producer");
        Thread consThread = new Thread(new StackConsumer(myStack), "Consumer");
        prodThread.start();
       // prodThread.join();
        consThread.start();
	}
}
