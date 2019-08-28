package com.bank2.web.servicesmpls;

import com.bank2.web.domains.AdminBean;
import com.bank2.web.domains.CustomerBean;
import com.bank2.web.domains.MemberBean;
import com.bank2.web.services.AdminService;

public class AdminSrvicesmpl implements AdminService{
	
	private CustomerBean[] customers;
	private AdminBean[] admins;
	private int custCount, admCount;
	public AdminSrvicesmpl() {
		customers = new CustomerBean[10];
		admins = new AdminBean[10];
		custCount = 0;
		admCount = 0;
	}
	@Override
	public void join(CustomerBean param) {
		customers[custCount] = param;
		custCount++;
	}
	@Override
	public void register(AdminBean param) {
		admins[admCount] = param;
		admCount++;
		
	}
		
	@Override
	public CustomerBean[] findAllCustomers() {
		return customers;
	}
	@Override
	public AdminBean[] findAllAdmins() {
		return admins;
	}
	@Override
	public MemberBean[] findByName(String name) {
		int count1 = 0, count2 = 0, count3 = 0;
		for(int i=0; i<custCount; i++) {
			if(name.equals(customers[i].getName())) {
				count1++;
				break;
			}
		}
		for(int i=0; i<admCount; i++) {
			if(name.equals(admins[i].getName())) {
				count2++;
				break;
			}
		}
		count3 = count1+count2;
		MemberBean[] members = new MemberBean[count3];
		int j= 0;
		for(int i=0; i<custCount; i++) {
			if(name.equals(customers[i].getName())) {
				members[j] = customers[i];
				j++;
				if(count1==j) {
					break;
				}
			}
		}
		int k=0;
		for(int i=0; i<custCount; i++ ) {
			if(name.equals(admins[i].getName())) {
				members[j] = admins[i];
				k++;
				j++;
				if(count2==k) {
					break;
				}
				break;
			}
		}
		return members;
	}
	@Override
	public MemberBean findById(String id) {
		MemberBean c = new MemberBean();
		for(int i=0;i<custCount;i++) {
			if(id.equals(customers[i].getId())) {
				c = customers[i];
				break;
			}
		}
		for(int i=0;i<admCount;i++) {
			if(id.equals(admins[i].getId())) {
				c = admins[i];
				break;
			}
		}
		return c;
	}
	@Override
	public boolean login(MemberBean param) {
		return findById(param.getId())
				.getPw()
				.equals(param.getPw());
	}
	@Override
	public int countCustomers() {
		return custCount;
	}
	@Override
	public int countAdmins() {
		return admCount;
	}
	@Override
	public boolean existId(String id) {
		boolean flag = false;
		for(int i=0;i<custCount;i++) {
			if(id.equals(customers[i].getId())) {
				flag = true;
				break;
			}
		}
		for(int i=0;i<admCount;i++) {
			if(id.equals(admins[i].getId())) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	@Override
	public void updatePass(MemberBean param) {
		String id = param.getId();
		String[] passwords = param.getPw().split(",");
		String oldPass = passwords[0];
		String newPass = passwords[1];
		param.setPw(oldPass);
		if(login(param)) {
			for(int i=0; i<custCount; i++) {
				if(id.equals(customers[i].getId())) {
					customers[i].setPw(newPass);
					break;
				}
			}
			for(int i=0; i<admCount; i++) {
				if(id.equals(admins[i].getId())) {
					admins[i].setPw(newPass);
					break;
				}
			}
		}
	}
	@Override
	public void deleteMember(MemberBean param) {
		if(login(param)) {
			int i=0;
			for(; i<custCount;i++) {
				if(customers[i].getId().equals(param.getId())) {
					customers[i] = customers[custCount-1];
					customers[custCount-1] = null;
					custCount--;
					break;
				}
			}
			i = 0;
			for(; i<admCount;i++) {
				if(admins[i].getId().equals(param.getId())) {
					admins[i] = admins[admCount-1];
					admins[admCount-1] = null;
					admCount--;
					break;
				}
			}
		}
	}
}
	
