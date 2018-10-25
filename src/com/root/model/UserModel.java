package com.root.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_registration_table")
public class UserModel {

	private String name;
	@Id
	private String email;
	
	private String mobileNumber;
	private String pincode;
	private String areaName;
	private String stateName;

	
	

	public UserModel() {
		super();
	}

	public UserModel(String name, String email, String mobileNumber, String pincode, String areaName,
			String stateName) {
		super();
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.pincode = pincode;
		this.areaName = areaName;
		this.stateName = stateName;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
