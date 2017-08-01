package net.chinahrd.homepage.module;

import net.chinahrd.eis.permission.EisWebContext;

/**
 * 定时更新缓存类
 * 
 * @author htpeng
 *
 */
public class Cache {
	
	private final static String customerId = EisWebContext.getCustomerId();

//	public static  CacheBlock<Integer> AvailabilityDayNum = new CacheBlockConstructor<Integer>(
//			"queryAvailabilityDayNum").getDefaultBlock(customerId,DateUtil.getDBCurdate(), PropertiesUtil.getProperty(ConfigKeyUtil.SY_REVIEWOTWEEK));

	
}
