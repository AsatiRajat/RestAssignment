package com.yash.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long empId;

	@Column(name = "address")
	private String address;

	@Column(name = "age")
	private Integer age;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "salary")
	private Double salary;

	public Employee() {
	}

	public Employee(Long empId, String address, Integer age, String contactNumber, String firstName, String lastName,
			Double salary) {
		super();
		this.empId = empId;
		this.address = address;
		this.age = age;
		this.contactNumber = contactNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", address=" + address + ", age=" + age + ", contactNumber=" + contactNumber
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + "]";
	}

}
