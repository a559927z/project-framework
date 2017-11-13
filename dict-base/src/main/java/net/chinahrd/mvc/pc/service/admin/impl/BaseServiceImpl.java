package net.chinahrd.mvc.pc.service.admin.impl;

import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import net.chinahrd.eis.permission.EisWebContext;
import net.chinahrd.utils.CollectionKit;

/**
 * 提供接入dao层的一些必要方法
 * 
 * @author jxzhang on 2017年7月20日
 * @Verdion 1.0 版本
 */
public class BaseServiceImpl {
	/**
	 * 强制带上参数
	 * 
	 * @return
	 */
	private Map<String, Object> paramsBase() {
		Map<String, Object> paramsBaseMap = CollectionKit.newMap();
		paramsBaseMap.put("customerId", EisWebContext.getCustomerId());
		paramsBaseMap.put("userId", EisWebContext.getCurrentUser().getUserId());
		return paramsBaseMap;
	}

	/**
	 * 对外附加参数
	 * 
	 * @return
	 */
	public Map<String, Object> paramsMap() {
		Map<String, Object> paramsBaseMap = this.paramsBase();
		Map<String, Object> paramsExpMap = CollectionKit.newMap();
		paramsExpMap.putAll(paramsBaseMap);
		return paramsExpMap;
	}

	/**
	 * 获得MyBatis分页组件
	 * 
	 * @param start
	 * @param length
	 * @return
	 */
	public RowBounds getRowBounds(Integer start, Integer length) {
		return length == -1 || length == null ? new RowBounds() : new RowBounds(start, length);
	}

}
