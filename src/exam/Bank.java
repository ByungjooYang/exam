package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
	private List<Account> list;
	private int totCount = 0;
	
	public void menu() {
		Scanner scan = new Scanner(System.in);
		list = new ArrayList<Account>();
		
		int choice;
		while(true) {
			System.out.println("====================");
			System.out.println("\t1. 계좌 생성");
			System.out.println("\t2. 계좌번호로 계좌 찾기");
			System.out.println("\t3. 이름으로 계좌번호로 계좌 찾기");
			System.out.println("\t4. 계좌 목록");
			System.out.println("\t5. 총 계좌 수");
			System.out.println("\t6. 끝내기");
			System.out.println("====================");
			System.out.print("번호 입력 : ");
			choice = scan.nextInt();
			
			if(choice==6) {
				System.out.println("프로그램 종료");
				scan.close();
				break;
			}
			
			if(choice == 1) {
				System.out.print("이름 입력 : ");
				String owner = scan.next();
				System.out.print("계좌 번호 입력 : ");
				String accountNum = scan.next();
				
				makeAccount(owner, accountNum);
				System.out.println("계좌 생성 완료!");
				
			} else if(choice == 2) {
				System.out.print("계좌번호를 입력해주세요 : ");
				String accountNum = scan.next();
				findAccount(accountNum);
				
			} else if(choice == 3) {
				System.out.print("이름을 입력해주세요 : ");
				String owner = scan.next();
				findAccountbyName(owner);
				
			} else if(choice == 4) {
				System.out.println("이름\t계좌번호");
				printAccount();
				
			} else if(choice == 5) {
				System.out.println(totCount + "개");
			}
		}
		
	}
	
	public void makeAccount(String name, String accountNum) {
		Account account = new Account();
		account.setOwner(name);
		account.setAccountNum(accountNum);
		list.add(account);
		totCount++;
	}
	
	public void findAccount(String account) {
		int count = 0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getAccountNum().equals(account)) {
				list.get(i).accoutMenu();
				count++;
			}
		}
		
		if(count == 0) System.out.println("찾으시는 계좌가 없습니다.");
	}
	
	public void findAccountbyName(String owner) {
		int count = 0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getOwner().equals(owner)) {
				list.get(i).accoutMenu();
				count++;
			}
		}
		
		if(count == 0) System.out.println("찾으시는 계좌가 없습니다.");
	}
	
	public void printAccount() {
		for(Account account : list) {
			System.out.println(account.toString());
		}
	}
	
	public int getTotCount() {
		return totCount;
	}
	
	public static void main(String[] args) {
		new Bank().menu();
		
	}
}
