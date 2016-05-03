package com.demo;

public class VolatileDemo {
	
	private volatile int number = 0;
	
	public int getNumber(){
		return this.number;
	}
	
	public void increase(){
		this.number++;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		final VolatileDemo volatileDemo = new VolatileDemo();
		
	}

}
