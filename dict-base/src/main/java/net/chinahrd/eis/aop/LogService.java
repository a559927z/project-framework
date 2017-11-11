package net.chinahrd.eis.aop;

public interface LogService {

	void insertLoginLog(AopInformation aopInformation);

	void information(AopInformation aopInfo);

}
