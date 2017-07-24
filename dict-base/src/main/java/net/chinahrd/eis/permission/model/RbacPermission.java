package net.chinahrd.eis.permission.model;

import java.io.Serializable;

public class RbacPermission implements Serializable {

	private static final long serialVersionUID = 8739783846731071660L;

	private String userKey;
	private String userNameCh;
	private String roleRank; // 角色范围
	private String funRank; // 功能范围
	private String organRank;

	private String fullPath;
	private String itemCodes;

	private String roleKey;

	public String getOrganRank() {
		return organRank;
	}

	public void setOrganRank(String organRank) {
		this.organRank = organRank;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public String getUserNameCh() {
		return userNameCh;
	}

	public void setUserNameCh(String userNameCh) {
		this.userNameCh = userNameCh;
	}

	public String getRoleRank() {
		return roleRank;
	}

	public void setRoleRank(String roleRank) {
		this.roleRank = roleRank;
	}

	public String getFunRank() {
		return funRank;
	}

	public void setFunRank(String funRank) {
		this.funRank = funRank;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public String getItemCodes() {
		return itemCodes;
	}

	public void setItemCodes(String itemCodes) {
		this.itemCodes = itemCodes;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

}
