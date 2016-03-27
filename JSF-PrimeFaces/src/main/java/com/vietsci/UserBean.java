package com.vietsci;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private String gender;
	private Date dob;
	private String occupation;
	private String area;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	// =========== Business Methods ============ //
	
	public String signUpUser() {
		System.out.println("signUpUser START");
		return "signup-succes";
		
	}
}