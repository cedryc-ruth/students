package be.iccbxl.poo;

import java.util.ArrayList;

public class Member extends Person {
	private String login;
	private String password;
	private double money;
	private String email;
	private Status status;
	private ArrayList<Evenement> events;

	public Member() {
	}

	public Member(String firstname, String lastname, char gender, String login, String password, String email) {
		super(firstname, lastname, gender);
		this.login = login;
		this.password = password;
		this.money = 0d;
		this.email = email;
		this.status = Status.MEMBER;
		this.events = new ArrayList<>();
	}

	public Member(String firstname, String lastname, char gender, String login) {
		this(firstname, lastname, gender, login, null, null);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ArrayList<Evenement> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Evenement> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Member [login=" + login + ", password=" + password + ", money=" + money + ", email=" + email
				+ ", status=" + status + ", events=" + events + "]";
	}
	
	
	
}
