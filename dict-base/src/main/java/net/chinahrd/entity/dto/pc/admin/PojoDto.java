package net.chinahrd.entity.dto.pc.admin;

import java.io.Serializable;
import java.util.List;

public class PojoDto implements Serializable {

	private static final long serialVersionUID = -1263390655478896349L;

	private String roleId;
	private String empId;
	private String userId;
	private List<OrganDto> organDto;

	private RoleDto roleDto;
	private String oper;

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

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public List<OrganDto> getOrganDto() {
		return organDto;
	}

	public void setOrganDto(List<OrganDto> organDto) {
		this.organDto = organDto;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
