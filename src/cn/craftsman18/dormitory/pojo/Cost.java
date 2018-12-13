package cn.craftsman18.dormitory.pojo;

import java.util.Date;

public class Cost {
	public int id;
	public double money;
	public String type;
	public String detail;
	public Date time;
	public String operator;
	public double balance;
	private boolean delFlag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isDelFlag() {
		return delFlag;
	}
	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}

	

}
