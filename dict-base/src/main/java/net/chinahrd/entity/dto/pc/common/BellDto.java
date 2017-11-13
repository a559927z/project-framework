package net.chinahrd.entity.dto.pc.common;

import java.io.Serializable;
import java.util.List;

import net.chinahrd.entity.dto.pc.home.CoterieDto;

public class BellDto implements Serializable {

	private static final long serialVersionUID = 3636019810576032555L;

	private Integer stayAuthcTotal; // 待好友验证
	private String myFirendTotal; // 好友
	private List<CoterieDto> stayAuthcDto; // 待好友验证

	public List<CoterieDto> getStayAuthcDto() {
		return stayAuthcDto;
	}

	public void setStayAuthcDto(List<CoterieDto> stayAuthcDto) {
		this.stayAuthcDto = stayAuthcDto;
	}

	public Integer getStayAuthcTotal() {
		return stayAuthcTotal;
	}

	public void setStayAuthcTotal(Integer stayAuthcTotal) {
		this.stayAuthcTotal = stayAuthcTotal;
	}

	public String getMyFirendTotal() {
		return myFirendTotal;
	}

	public void setMyFirendTotal(String myFirendTotal) {
		this.myFirendTotal = myFirendTotal;
	}

}
