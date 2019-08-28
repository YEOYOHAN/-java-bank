package com.bank2.web.domains;

public class AccountBean {

	private String accNum , today, money;

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "계좌정보 [계좌번호=" + accNum 
				+ ", 거래일자=" + today 
				+ ", 금액=" + money + "]";
	}
	
}
