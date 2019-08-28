package com.bank2.web.domains;

public class AdminBean extends MemberBean {

	private int sabun;

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	@Override
	public String toString() {
		return String.format("사원정보 [아이디 : %s\n"
				+ "이름: %s\n"
				+ "주민번호 : %s\n"
				+ "사번: %d \n]", super.getId(), super.getName(), super.getSsn(), this.sabun);
	}
	
}
