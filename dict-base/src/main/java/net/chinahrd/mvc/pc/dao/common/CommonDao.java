package net.chinahrd.mvc.pc.dao.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import net.chinahrd.utils.holiday.DaysDto;

/**
 * 公共Dao接口类
 */
@Repository("commonDao")
public interface CommonDao {
	
	

	/**
	 * 检查Days表是否有本年度数据
	 * 
	 * @param paramMap
	 * @return
	 */
	Integer checkDaysTable(Map<String, Integer> paramMap);

	/**
	 * 插入新的一年每天工作或假期情况
	 */
	void insertDays(@Param("list") List<DaysDto> days);

	/**
	 * 插入日志
	 * 
	 * @param paramMap
	 * @author jxzhang on 2017-02-11
	 */
	void insertLog(Map<String, Object> paramMap);

	/**
	 * 插入指定年每天应出勤小时数
	 * 
	 * @param paramMap
	 */
	void insertTheoryAttendance(Map<String, Object> paramMap);
}
