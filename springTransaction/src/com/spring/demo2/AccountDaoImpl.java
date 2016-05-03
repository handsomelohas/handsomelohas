package com.spring.demo2;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
	/**
	 * @param out  	:转出帐号
	 * @param money	:转出金额
	 */
	@Override
	public void outMoney(String out, double money) {
		String sql = "update account set money = money-? where name=?";
		this.getJdbcTemplate().update(sql, money,out);
	}
	/**
	 * @param in	:转入帐号
	 * @param money	:转入金额
	 */
	@Override
	public void inMoney(String in, double money) {
		String sql = "update account set money = money+? where name=?";
		this.getJdbcTemplate().update(sql, money,in);
	}

}
