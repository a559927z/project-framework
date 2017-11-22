package net.chinahrd.homepage.mvc.pc.enums;

public enum PhotoCode {

	avatar(1, "头像");

	private final int code;
	private final String deil;

	private PhotoCode(int code, String deil) {
		this.code = code;
		this.deil = deil;
	}

	public int getCode() {
		return code;
	}

	public String getDeil() {
		return deil;
	}

}
