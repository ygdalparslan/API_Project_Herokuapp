package com.herokuapp.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPojo implements Serializable {
	private String _id;
	private String firstName;
	private String lastName;
	private String email;
	private int __v;

	public void set_id(String _id){
		this._id = _id;
	}

	public String get_id(){
		return _id;
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

	public void set__v(int V){
		this.__v = V;
	}

	public int get__v(){
		return __v;
	}

	@Override
 	public String toString(){
		return 
			"UserPojo{" + 
			"_id = '" + _id + '\'' +
			",firstName = '" + firstName + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",email = '" + email + '\'' + 
			",__v = '" + __v + '\'' +
			"}";
		}
}