package com.herokuapp.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRootPojo implements Serializable {
	private UserPojo user;
	private String token;

	public UserRootPojo() {
	}

	public UserRootPojo(UserPojo user, String token) {
		this.user = user;
		this.token = token;
	}

	public void setUser(UserPojo user){
		this.user = user;
	}

	public UserPojo getUser(){
		return user;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"UserRootPojo{" + 
			"user = '" + user + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}