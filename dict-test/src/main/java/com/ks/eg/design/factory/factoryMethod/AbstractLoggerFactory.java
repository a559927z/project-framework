package com.ks.eg.design.factory.factoryMethod;

/**
 * Title: AbstractLoggerFactory <br/>
 * Description: 日志记录器工厂接口：抽象工厂
 * 
 * @author jxzhang
 * @DATE 2017年11月28日 下午9:24:15
 * @Verdion 1.0 版本
 */
public abstract class AbstractLoggerFactory {

	// 在工厂类中直接调用日志记录器类的业务方法writeLog()
	public void writeLog() {
		Logger logger = this.createLogger();
		logger.writeLog();
	}

	public abstract Logger createLogger();

	public abstract Logger createLogger(String args);

	public abstract Logger createLogger(Object obj);

}
