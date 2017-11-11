package net.chinahrd.eis.aop;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @author jxzhang on 2016年11月10日
 * @Verdion 1.0 版本
 */
public class AopInformation implements Serializable {
	private static final long serialVersionUID = 1412651275510147118L;

	private String userLoginId; // 登录日志ID
	private String userId; // 用户ID
	private String userKey; // 用户key
	private String userName; // 用户名
	private String userNameCh; // 用户姓名
	private String ipAddress; // 登录IP地址
	private Timestamp loginTime; // 登录时间

	private String description; // 描述
	private String packageName; // 包名
	private String clazz; // 类名
	private String method; // 方法名
	private String methodFull; // 类+方法名
	private int type; // 1，登录， 2 登出， 3，查询、修改、添加
	private int exceptionCode = 0; // 错误代号 0为没有
	private String exceptionDetail; // 错误描述
	private String params; // 参数
	private double useTime; // 用时单位秒
	private Timestamp createDate; // 创建时间
	private boolean writeDb; // 是否写入数据库

	
	public double getUseTime() {
		return useTime;
	}

	public void setUseTime(double useTime) {
		this.useTime = useTime;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}


	public String getMethodFull() {
		return methodFull;
	}

	public void setMethodFull(String methodFull) {
		this.methodFull = methodFull;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public boolean isWriteDb() {
		return writeDb;
	}

	public void setWriteDb(boolean writeDb) {
		this.writeDb = writeDb;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public int getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(int exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionDetail() {
		return exceptionDetail;
	}

	public void setExceptionDetail(String exceptionDetail) {
		this.exceptionDetail = exceptionDetail;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNameCh() {
		return userNameCh;
	}

	public void setUserNameCh(String userNameCh) {
		this.userNameCh = userNameCh;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
}
