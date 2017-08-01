package net.chinahrd.entity.dto.pc.home;

import java.io.Serializable;
import java.sql.Timestamp;

public class PhotoDto implements Serializable {

	private static final long serialVersionUID = 7435312872131058503L;
	private String photoId;
	private String filePath;
	private int type;
	private String createUserId;
	private Timestamp createTime;

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
