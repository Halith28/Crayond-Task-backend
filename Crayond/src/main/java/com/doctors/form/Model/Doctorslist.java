package com.doctors.form.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Doctors")

public class Doctorslist {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String Name;
	private String Designation;
	private String Gender;
	private String Specialist;
	private String Mobile;
	private long loginid;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getSpecialist() {
		return Specialist;
	}
	public void setSpecialist(String specialist) {
		Specialist = specialist;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public long getLoginid() {
		return loginid;
	}
	public void setLoginid(long loginid) {
		this.loginid = loginid;
	}
}
