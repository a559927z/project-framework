package net.chinahrd.entity.dto.pc.home;

import java.io.Serializable;

/**
 * 圈子
 * 
 * @author jxzhang on 2017年8月2日
 * @Verdion 1.0 版本
 */
public class CoterieDto implements Serializable {

	private static final long serialVersionUID = -7872905485231274103L;
	private String userId;
	private String userNameCh;
	private String myFirendId; // 我好友的用户ID
	private String myAttentionId; // 我关注的用户ID
	private Integer isSelect;
	private Integer isAuthc = 0;
	private Integer isBlack = 0;

	public String getMyAttentionId() {
		return myAttentionId;
	}

	public void setMyAttentionId(String myAttentionId) {
		this.myAttentionId = myAttentionId;
	}

	public String getMyFirendId() {
		return myFirendId;
	}

	public void setMyFirendId(String myFirendId) {
		this.myFirendId = myFirendId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNameCh() {
		return userNameCh;
	}

	public void setUserNameCh(String userNameCh) {
		this.userNameCh = userNameCh;
	}

	public Integer getIsSelect() {
		return isSelect;
	}

	public void setIsSelect(Integer isSelect) {
		this.isSelect = isSelect;
	}

	public Integer getIsAuthc() {
		return isAuthc;
	}

	public void setIsAuthc(Integer isAuthc) {
		this.isAuthc = isAuthc;
	}

	public Integer getIsBlack() {
		return isBlack;
	}

	public void setIsBlack(Integer isBlack) {
		this.isBlack = isBlack;
	}

}
