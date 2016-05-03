package com.spring.demo3;

public class AccountServiceImpl implements AccountService {
	
	//注入转账的Dao
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	/**
	 * @param out	:转出账号
	 * @param in 	:转入帐号
	 * @param money	:转账金额
	 */
	public void tranfer(String out , String in , double money){
		accountDao.outMoney(out, money);
		int i=1/0;
		accountDao.inMoney(in, money);
	}

}
