package com.spring.demo2;

public interface AccountService {
	/**
	 * 
	 * @param out	:转出帐号
	 * @param in	:转入帐号
	 * @param money	:金额
	 */
	public void tranfer(String out , String in , double money);
}
