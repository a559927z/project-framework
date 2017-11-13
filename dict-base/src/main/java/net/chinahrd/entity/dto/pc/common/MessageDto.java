package net.chinahrd.entity.dto.pc.common;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @author jxzhang on 2017年8月4日
 * @Verdion 1.0 版本
 */
public class MessageDto implements Serializable {

	private static final long serialVersionUID = -5970316564332426762L;
	private String id; // 消息ID
	private String seandUserId; // 发送者ID
	private String recipientId; // 接收者ID
	private String subject; // 主题
	private String content; // 内容
	private String attachmentId; // 附件ID
	private int isRead; // 是否已读
	private Timestamp createTime; // 创建时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSeandUserId() {
		return seandUserId;
	}

	public void setSeandUserId(String seandUserId) {
		this.seandUserId = seandUserId;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
