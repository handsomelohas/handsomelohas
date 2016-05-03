package com.thread;

public class keyPersonThread extends Thread {
	public void run(){
		System.out.println(Thread.currentThread().getName()+" begin hit ");
		
		for(int i = 0 ; i < 10 ; i++){
			System.out.println(Thread.currentThread().getName()+" hit ");
		}
		
		System.out.println(Thread.currentThread().getName()+" hit of end ");
	}
}
