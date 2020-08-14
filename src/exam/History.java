package exam;

import java.text.SimpleDateFormat;
import java.util.Date;

public class History {
	private String dealingDate;
	private String dealingTime;
	private String division;
	private int dealingMoney;
	private int balance;
	
	public History() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String today = format.format(date);
		dealingDate = today.substring(0, 10);
		dealingTime = today.substring(11, 19);
	}
	
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public int getDealingMoney() {
		return dealingMoney;
	}
	public void setDealingMoney(int dealingMoney) {
		this.dealingMoney = dealingMoney;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return dealingDate + "\t" + dealingTime + "\t" + dealingMoney + "\t" + division + "\t" + balance;
	}
	
}
