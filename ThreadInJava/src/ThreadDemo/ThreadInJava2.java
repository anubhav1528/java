package ThreadDemo;

public class ThreadInJava2 implements Runnable {
    public static void main(String[] args) {
		
	}
	@Override
	public void run() {
		for(int j=0;j<=20;j++) {
			System.out.println("j==>"+j);
		}
		
	}

}
