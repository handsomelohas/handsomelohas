package com.spring.demo3;

public interface AccountDao {
	/**
	 * 
	 * @param out  	:转出帐号
	 * @param money	:转出金额
	 */
	public void inMoney(String out , double money);
	
	/**
	 * 
	 * @param in	:转入帐号
	 * @param money	:转入金额
	 */
	public void outMoney(String in , double money);
}
