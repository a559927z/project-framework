package com.ks.eg.design.factory.factoryMethod;

/**
 * Title: DatabaseLogger <br/>
 * Description: 文件日志记录器：具体产品
 * 
 * @author jxzhang
 * @DATE 2017年11月28日 下午9:22:43
 * @Verdion 1.0 版本
 */
public class FileLogger implements Logger {

	@Override
	public void writeLog() {
		System.out.println("文件日志记录。");
	}

}
