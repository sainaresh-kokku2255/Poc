package com.ojas.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private String mnumber;
	private int Stdclass;
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	public Student() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getMnumber() {
		return mnumber;
	}
	public void setMnumber(String mnumber) {
		this.mnumber = mnumber;
	}
	public int getStdclass() {
		return Stdclass;
	}
	public void setStdclass(int stdclass) {
		Stdclass = stdclass;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", mnumber="
				+ mnumber + ", Stdclass=" + Stdclass + "]";
	}
	
}
