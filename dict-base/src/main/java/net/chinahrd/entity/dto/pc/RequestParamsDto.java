package net.chinahrd.entity.dto.pc;

import java.io.Serializable;

import net.chinahrd.entity.dto.pc.admin.RoleDto;
import net.chinahrd.entity.dto.pc.admin.UserDto;

/**
 * 
 * @author jxzhang on 2017年7月19日
 * @Verdion 1.0 版本
 */
public class RequestParamsDto implements Serializable {

	private static final long serialVersionUID = 3902450654731368099L;

	private int start; // 分页开始行
	private int length; // 每页大小
	private String[] ids; // PK可作一些删除或更新操作

	private RoleDto roleDto;
	private UserDto userDto;
	private String oper;
	

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public RoleDto getRoleDto() {
		return roleDto;
	}

	public void setRoleDto(RoleDto roleDto) {
		this.roleDto = roleDto;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
