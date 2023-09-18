package be.iccbxl.poo;

public class Person {
	private String firstname;
	private String lastname;
	private char gender;

	public Person() {
	}

	public Person(String firstname, String lastname, char gender) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender + "]";
	}
	
	
	
}
