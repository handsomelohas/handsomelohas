package com.thread;

public class Actress implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"this is actress");
		int count = 0;
		boolean keepRuning = true;
		
		while(keepRuning){
			System.out.println(Thread.currentThread().getName()+"show in stage "+(++count));
			
			if(count==100){
				keepRuning = false;
			}
			
			if(count%10==0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		
		
		
		System.out.println(Thread.currentThread().getName()+"show of end ");
	}

}
