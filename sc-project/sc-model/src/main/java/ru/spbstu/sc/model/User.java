package ru.spbstu.sc.model;

import java.util.Date;

public abstract class User extends BaseEntity {

	private String username;
	private String email;
	private String password;
	private boolean enabled;
	private String firstName;
	private String lastName;
	private String patronymic;
	private Date birthDate;
	private Address address;
	private String selfInformation;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getSelfInformation() {
		return selfInformation;
	}

	public void setSelfInformation(String selfInformation) {
		this.selfInformation = selfInformation;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [userName=" + username + ", email=" + email
				+ ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", patronymic=" + patronymic
				+ ", birthDate=" + birthDate + ", address=" + address
				+ ", selfInformation=" + selfInformation + "]";
	}

}
