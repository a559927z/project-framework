package com.ks.dto;

import java.io.Serializable;

/**
 * 公共基本dto
 * 
 * @author jxzhang on 2017年11月13日
 * @Verdion 1.0 版本
 */
public class BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 104793415528352911L;
	private String k;
	private String v;

	public BaseDto() {
		super();
	}

	public BaseDto(String k, String v) {
		super();
		this.k = k;
		this.v = v;
	}

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

}
