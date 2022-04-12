package com.vo;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.hibernate.annotations.BatchSize;

@Entity
@Table(name="Register")


public class RegisterVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    
	private int registerId;
	
	
	@Column(name="firstName")
	/*@NotNull
	@Size(min=2, max=30)
*/	private String firstName;

	/*@NotNull
	@Size(min=2, max=30)*/
	@Column(name="lastName")
	private String lastName;
	
	/*@NotNull
	@Size(min=5,max=6)*/
	@Column(name="RTO_ID")
	private String rto_id;
	
	public String getRto_id() {
		return rto_id;
	}

	public void setRto_id(String rto_id) {
		this.rto_id = rto_id;
	}

	@Column(name="dateOfBirth")
	private String dateOfBirth;
/*	
	@Column(name="gender")
	private String gender;*/
	
	/*@Column(name="mobile")
	private String mobile;*/
	
	/*@Column(name="address")
	private String address;*/
	
	@Column(name="status")
	private boolean status=true;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="loginId")
	private LoginVO loginVO;

	public int getRegisterId() {
		return registerId;
	}

	public void setRegisterId(int registerId) {
		this.registerId = registerId;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

/*	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
*/
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	
	

}
