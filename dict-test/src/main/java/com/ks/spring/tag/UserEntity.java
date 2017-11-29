package com.ks.spring.tag;

public class UserEntity {

	private String name;
	private String email;

	public UserEntity(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
