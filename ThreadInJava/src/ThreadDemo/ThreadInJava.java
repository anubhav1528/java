package ThreadDemo;

public class ThreadInJava implements Runnable {
	public static void main(String[] args) {
		ThreadInJava classobj = new ThreadInJava();
		ThreadInJava2 Threadobj2 = new ThreadInJava2();
		Thread threadobj1 = new Thread(classobj);
		Thread threadobj2 = new Thread(Threadobj2);
		threadobj1.start();
		try {
			threadobj1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadobj2.start();
	}

	@Override
	public void run() { 
		for (int i = 0; i < 20; i++) {
			System.out.println("i==>" + i);
		}

	}

}
