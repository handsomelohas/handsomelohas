package com.thread;

public class ArmyRunnable implements Runnable {
	
	volatile boolean keepRuning=true;
	
	@Override
	public void run() {
		while(keepRuning){
			for(int i = 0 ; i<5;i++){
				System.out.println(Thread.currentThread().getName()+" hit "+i);
				Thread.yield();
			}
		}
		
		System.out.println("end....");
	}

}
