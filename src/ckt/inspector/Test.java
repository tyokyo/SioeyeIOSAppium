package ckt.inspector;

import org.openqa.selenium.By;

import ckt.App.Util.VP4;

public class Test extends VP4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startAppium();
		Thread  thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10000; i++) {
					iosdriver.getPageSource();
					System.out.println("thread-getPageSource");
					Thread.currentThread();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
		
		
		for (int i = 0; i < 1000; i++) {
			waitUntilTextExist("发现", 10);
			clickByName("相机");
			clickByName("发现");
			wait(20);
		}
		stopAppium();
	}

}
