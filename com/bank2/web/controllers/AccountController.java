package com.bank2.web.controllers;
import javax.swing.JOptionPane;
import com.bank2.web.services.AccountService;
import com.bank2.web.servicesmpls.AccountsSrvicesmpl;

public class AccountController {

	public static void main(String[] args) {
		int num = 0;
		AccountService acc = new AccountsSrvicesmpl();

		while(true) {
			switch (JOptionPane.showInputDialog("[0. 종료\n"
					+ "1. 계좌생성\n"
					+ "2. 모든계좌보기\n"
					+ "3. 내계좌찾기\n"
					+ "4. 총계좌수보기\n"
					+ "5. 중복확인하기"
					+ "6. 입금\n"
					+ "7. 출금\n"
					+ "8. 계좌지우기]")) {
			case "0" :
				return;
			case "1" :
				num = Integer.parseInt(JOptionPane.showInputDialog("금액입력"));
				break;
			case "2" :
				
				break;
			case "3" :
				
				break;
			case "4" :
				
				break;
			case "5" :
				
				break;
			case "6" :
				
				break;
			case "7" :
				
				break;

			default:
				break;
			}
		}

	}

}
