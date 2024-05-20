package com.herokuapp.pojos;

import java.io.Serializable;

public class UserSignUpPojo implements Serializable {
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public UserSignUpPojo() {
	}

	public UserSignUpPojo(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	@Override
 	public String toString(){
		return 
			"UserSignUpPojo{" + 
			"firstName = '" + firstName + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",email = '" + email + '\'' + 
			",password = '" + password + '\'' + 
			"}";
		}
}