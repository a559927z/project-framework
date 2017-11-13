package net.chinahrd.mvc.pc.service.common;

import java.util.Date;

/**
 * 公共service接口类
 */
public interface CommonService {

	/**
	 * 插入days表，计算工作天、休息天、法定节日
	 * 
	 * @param endDay
	 *            2018-01-01
	 * @param startDay
	 *            2017-01-01
	 * @return
	 * @author jxzhang on 2017-02-13
	 */
	boolean insertDays(String endDay, String startDay);

	/**
	 * 插入日志
	 * 
	 * @param userId
	 *            操作者
	 * @param module
	 *            表名称
	 * @param text
	 *            描述
	 * @param startTime
	 *            开始时间
	 * @param isError
	 *            是否错误
	 * @param showIndex
	 *            顺序
	 * @author jxzhang on 2017-02-13
	 * 
	 */
	void insertLog(String userId, String module, String text, Date startTime, int isError, Integer showIndex);

	/**
	 * 检查Days表是否有本年度数据
	 * 
	 * @param year
	 *            本年度
	 * @return
	 * @author jxzhang on 2017-02-14
	 */
	boolean checkDaysTable(String year);

}
