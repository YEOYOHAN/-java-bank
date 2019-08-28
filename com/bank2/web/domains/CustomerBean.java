package com.bank2.web.domains;

public class CustomerBean extends MemberBean {

	private String credit;

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return String.format("고객정보 [아이디: %s \n"
				+ "이름:%s\n"
				+ "주민번호:%s\n"
				+ "신용등급: %s]", super.getId(), super.getName(), super.getSsn(), this.credit);
	}
	
}
