package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account {
	private String accountNum;
	private String owner;
	private int balance = 0;
	private List<History> historyList;
	
	public void accoutMenu(){
		Scanner scan = new Scanner(System.in);
		historyList = new ArrayList<History>();
		int a = 1;
		int choice = 0;
		while(true) {
			System.out.println("===================");
			System.out.println("\t1. 입금하기");
			System.out.println("\t2. 출금하기");
			System.out.println("\t3. 잔고 확인");
			System.out.println("\t4. 거래 내역");
			System.out.println("\t5. 돌아가기");
			System.out.println("===================");
			System.out.print("번호 입력 : ");
			choice = scan.nextInt();
			
			if(choice == 5) break;
			
			if(choice == 1) {
				System.out.print("입금할 금액을 넣어주세요 : ");
				int deposit = scan.nextInt();
				deposit(deposit);
				
				History history = new History();
				history.setDivision("입금");
				history.setBalance(balance);
				history.setDealingMoney(deposit);
				historyList.add(history);
				
				
			} else if(choice == 2) {
				System.out.print("출금할 금액을 입력해주세요 : ");
				int withdraw = scan.nextInt();
				withdraw(withdraw);
				
				History history = new History();
				history.setDivision("출금");
				history.setBalance(balance);
				history.setDealingMoney(withdraw);
				historyList.add(history);
				
			} else if(choice == 3) {
				showBalance();
				
			} else if(choice == 4) {
				System.out.println("=====================");
				System.out.println("날짜\t\t시간\t\t거래금액\t종류\t잔액");
				showHistroy();
			}
			
		}
	}
	
	public void deposit(int deposit) {
		balance += deposit;
	}
	
	public void withdraw(int withdraw) {
		balance -= withdraw;
		
	}
	
	public void showBalance() {
		System.out.println("잔고는 " + balance + "원 입니다.");
	}
	
	public void showHistroy() {
		for(History his : historyList) {
			System.out.println(his.toString());
		}
	}
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getAccountNum() {
		return accountNum;
	}
	
	public String getOwner() {
		return owner;
	}
	
	@Override
	public String toString() {
		return owner + "\t" + accountNum;
	}

}
