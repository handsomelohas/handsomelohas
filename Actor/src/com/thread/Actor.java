package com.thread;

public class Actor extends Thread {
	
	public void run(){
		System.out.println(getName()+"this is actor");
		int count = 0;
		boolean keepRuning = true;
		
		while(keepRuning){
			System.out.println(getName()+"show in stage "+(++count));
			
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
		
		
		
		System.out.println(getName()+"show of end ");
	}
	
	public static void main(String[] args){
		Thread actor = new Actor();
		actor.setName("Mr.Thread ");
		actor.start();
		
		Thread actress = new Thread(new Actress(),"Ms.Runnable ");
		actress.start();
	}
}
