package com.spring.demo1;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements AccountService {
	
	//注入转账的Dao
	private AccountDao accountDao;
	
	//注入事务管理的模板
	private TransactionTemplate transactionTemplate;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	/**
	 * @param out	:转出账号
	 * @param in 	:转入帐号
	 * @param money	:转账金额
	 */
	@Override
	public void tranfer(final String out, final String in, final double money) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				accountDao.outMoney(out, money);
//				int i = 1/0;
				accountDao.inMoney(in, money);
			}
		});
	}

}
