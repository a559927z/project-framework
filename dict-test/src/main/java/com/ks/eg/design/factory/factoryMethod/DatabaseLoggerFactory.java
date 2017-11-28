package com.ks.eg.design.factory.factoryMethod;

/**
 * Title: DatabaseLoggerFactory <br/>
 * Description: 数据库日志记录器工厂类：具体工厂
 * 
 * @author jxzhang
 * @DATE 2017年11月28日 下午9:29:27
 * @Verdion 1.0 版本
 */
public class DatabaseLoggerFactory extends AbstractLoggerFactory {

	@Override
	public Logger createLogger() {
		// 使用默认方式连接数据库，代码省略
		Logger logger = new DatabaseLogger();
		// 初始化数据库日志记录器，代码省略
		return logger;
	}

	@Override
	public Logger createLogger(String args) {
		// 使用参数args作为连接字符串来连接数据库，代码省略
		Logger logger = new DatabaseLogger();
		// 初始化数据库日志记录器，代码省略
		return logger;
	}

	@Override
	public Logger createLogger(Object obj) {
		// 使用封装在参数obj中的连接字符串来连接数据库，代码省略
		Logger logger = new DatabaseLogger();
		// 使用封装在参数obj中的数据来初始化数据库日志记录器，代码省略
		return logger;
	}

}
