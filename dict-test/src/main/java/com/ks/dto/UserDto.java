package com.ks.dto;

/**
 * Title: UserDto <br/>
 * Description:
 * 
 * @author jxzhang
 * @DATE 2017年11月29日 下午6:48:17
 * @Verdion 1.0 版本
 */
public class UserDto extends BaseDto {

	private static final long serialVersionUID = 1154715845327699595L;
	private String username;
	private String password;
	private String email;
	public String school;
	private Integer age;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
