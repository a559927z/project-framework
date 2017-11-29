package com.ks.design.factory.factoryMethod;

/**
 * Title: FileLoggerFactory <br/>
 * Description: 文件日志记录器工厂类：具体工厂
 * 
 * @author jxzhang
 * @DATE 2017年11月28日 下午9:29:54
 * @Verdion 1.0 版本
 */
public class FileLoggerFactory extends AbstractLoggerFactory {

	@Override
	public Logger createLogger() {
		// 创建文件日志记录器对象
		Logger logger = new FileLogger();
		// 创建文件，代码省略
		return logger;
	}

	@Override
	public Logger createLogger(String args) {
		// 创建文件日志记录器对象
		Logger logger = new FileLogger();
		// 创建文件，代码省略
		return logger;
	}

	@Override
	public Logger createLogger(Object obj) {
		// 创建文件日志记录器对象
		Logger logger = new FileLogger();
		// 创建文件，代码省略
		return logger;
	}

}
