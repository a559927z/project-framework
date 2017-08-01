package net.chinahrd.entity.dto.pc.common;

import java.util.Date;

import net.chinahrd.entity.dto.pc.admin.UserDto;

/**
 * 
 * @author jxzhang on 2017年8月1日
 * @Verdion 1.0 版本
 */
public class UserExpDto extends UserDto {

	private static final long serialVersionUID = 5564253697037192924L;
	private String location;
	private double age;
	private Date joinedDate;
	private Date lastTime;
	private String avatar; // 头像

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

}
