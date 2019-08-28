package com.bank2.web.servicesmpls;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.bank2.web.domains.AccountBean;
import com.bank2.web.services.AccountService;

public class AccountsSrvicesmpl implements AccountService {
	
	private AccountBean[] accounts;
	private int count;
	public AccountsSrvicesmpl() {
		accounts = new AccountBean[10];
		count = 0;
	}
	@Override
	public void createAccount(int money) {
		AccountBean acc = new AccountBean();
		acc.setAccNum(createAccountNum());
		acc.setMoney(money+"");
		acc.setToday(findDate());
		accounts[count] = acc;
		count++;
	}
	@Override
	public String createAccountNum() {
		String accountNum = "";
		Random ran = new Random();
		/*int t1 = (ran.nextInt(8999)+1000);
		int t2 = (ran.nextInt(9999)+1);
		System.out.println("-------------");
		System.out.println(String.format("%d-%04d, t1, t2"));
		*/
		for(int i=0;i<9;i++) {
			accountNum += (i==4)?"-":ran.nextInt(10);
		}
		return accountNum;
	}
	@Override
	public AccountBean[] findAll() {
		return accounts;
	}
	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean acc = new AccountBean();
		for(int i=0;i<count;i++) {
			if(accountNum.equals(accounts[i].getAccNum())) {
				acc = accounts[i];
			}
		}
		return acc;
	}
	@Override
	public int countAccounts() {
		return count;
	}
	@Override
	public boolean existAccountNum(String accountNum) {
		boolean flag = false;
		for(int i=0; i<count; i++) {
			if(accountNum.equals(accounts[i].getAccNum())) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm")
				.format(new Date());
	}
	@Override
	public void depositMoney(AccountBean param) {
		if(existAccountNum(param.getAccNum())) {
			for(int i=0;i<count;i++) {
				if(accounts[i].getAccNum().equals(param.getAccNum())) {
					int saving = Integer.parseInt(param.getMoney());
					int saving2 = Integer.parseInt(accounts[i].getMoney());
					accounts[i].setMoney(String.valueOf(saving + saving2));
					break;
				}
			}
		}
	}
	@Override
	public void withdrawMoney(AccountBean param) {
		if(existAccountNum(param.getAccNum())) {
			for(int i=0;i<count;i++) {
				if(accounts[i].getAccNum().equals(param.getAccNum())) {
					int withdrawal = Integer.parseInt(param.getMoney());
					int saving = Integer.parseInt(accounts[i].getMoney());
					accounts[i].setMoney(String.valueOf(saving - withdrawal));
					break;
				}
			}
		}
	}
	@Override
	public void deleteAccountNum(String accountNum) {
		if(existAccountNum(accountNum)) {
		int i =0;
		for(;i<count;i++) {
			if(accounts[i].getAccNum().equals(accountNum)) {
				accounts[i] = accounts[count-1];
				count--;
				break;
				}
			}
		}
	}
}
	