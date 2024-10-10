package com.example.demo.dto;

import java.io.Serializable;

public class EmployeeDto implements Serializable {

	private static final long serialVersionUID = -8826344253361408553L;

	private int id;
	private String imageUrl;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNumber;
	private int age;
	private String dob;
	private String address;
	private double salary;
	private double annualSalary;

	public EmployeeDto() {
	}

	public EmployeeDto(int id, String imageUrl, String firstName, String lastName, String email, String contactNumber, int age, String dob, String address, double salary) {
		this.id = id;
		this.imageUrl = imageUrl;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.age = age;
		this.dob = dob;
		this.address = address;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getAnnualSalary() {
		annualSalary = salary * 12;
		return annualSalary;
	}

}
