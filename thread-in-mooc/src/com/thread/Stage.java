package com.thread;

public class Stage extends Thread {

	public void run(){
		
		System.out.println("Start of war");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		
		System.out.println("*******");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		
		System.out.println("start....");
		
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
		
		Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"SuiDynasty");
		Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"Revolt");
		
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
//		armyTaskOfSuiDynasty.keepRuning = false;
//		armyTaskOfRevolt.keepRuning = false;
//		
//		try {
//			armyOfRevolt.join();
//		} catch (InterruptedException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
		System.out.println("*******KeyPerson**********");
		
		Thread mrCheng = new keyPersonThread();
		mrCheng.setName("Cheng");
		
		System.out.println(" Dream of Cheng end ");
		
		armyTaskOfSuiDynasty.keepRuning = false;
		armyTaskOfRevolt.keepRuning = false;
		
//		armyOfSuiDynasty.stop();
//		armyOfRevolt.stop();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		mrCheng.start();
		
		try {
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		System.out.println("end of war");
		System.out.println("Thanks");
	}
	
	public static void main(String[] args) {
		new Stage().start();
	}

}
