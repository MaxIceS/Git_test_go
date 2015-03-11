import java.util.ArrayList;
import java.util.Random;

public class Worker {

	private ArrayList<Integer> list1 = new ArrayList<Integer>();
	private ArrayList<Integer> list2 = new ArrayList<Integer>();

	private Object obj1 = new Object();
	private Object obj2 = new Object();

	private Random random = new Random();

	private void partOne() {
		synchronized (obj1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			list1.add(random.nextInt(100));
		}

	}

	private void partTwo() {
		synchronized (obj2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			list2.add(random.nextInt(100));
		}

	}

	private void proceed() {
		for (int i = 0; i < 1000; i++) {
			partOne();
			partTwo();
		}
	}

	public Worker() {
		// TODO Auto-generated constructor stub
	}

	public void start() {
		System.out.println("Начинаем...");
		long startTime = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				proceed();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				proceed();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long endTime = System.currentTimeMillis();
		System.out.println("Потраченное время " + (endTime - startTime) + "\n"
				+ "Лист 1: " + list1.size() + "\n" + "Лист 1: " + list1.size());
	}

}
