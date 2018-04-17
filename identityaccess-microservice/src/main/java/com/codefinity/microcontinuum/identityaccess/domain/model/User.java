package com.codefinity.microcontinuum.identityaccess.domain.model;

public class User {

	// @Id
	// @GeneratedValue
	private Long id;

	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String mobile;
	//@Column(nullable = false, unique = true)
	private String email;
	//@Column(nullable = false)
	private String password;
	private String avtar;
	private Integer logInFailureAttempts;
	private String uuid;

	public User() {

	}

	public User(User user) {
		  this.firstName = user.firstName;
		  this.middleName = user.middleName;
		  this.lastName =  user.lastName;
		  this.gender = user.gender;
		  this.mobile = user.mobile;
		  this.email = user.email;
		  this.password = user.password;
		  this.avtar = user.avtar;
		  this.logInFailureAttempts = user.logInFailureAttempts;
		  this.uuid = user.uuid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
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

	public String getAvtar() {
		return avtar;
	}

	public void setAvtar(String avtar) {
		this.avtar = avtar;
	}
	

	public Integer getLogInFailureAttempts() {
		return logInFailureAttempts;
	}

	public void setLogInFailureAttempts(Integer logInFailureAttempts) {
		this.logInFailureAttempts = logInFailureAttempts;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}	
	
}
