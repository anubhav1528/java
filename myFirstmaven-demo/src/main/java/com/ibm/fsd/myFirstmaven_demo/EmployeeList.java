package com.ibm.fsd.myFirstmaven_demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "EmployeeList")
@Data
public class EmployeeList{
public EmployeeList() {
		super();
	}
@Id
@Column (name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column (name = "name")
private String name;
@Column (name = "password")
private String password;
@Column (name = "country")
private String country;
@Column (name = "email")
private String email;
@Column (name = "uid")
private int uid;
@Override
public String toString() {
	return "EmployeeList [id=" + id + ", name=" + name + ", password=" + password + ", country=" + country + ", email="
			+ email + ", uid=" + uid + "]";
}
public EmployeeList(String name, String password, String country, String email, int uid) {
	super();
	this.name = name;
	this.password = password;
	this.country = country;
	this.email = email;
	this.uid = uid;
}
}
