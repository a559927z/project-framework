package net.chinahrd.mvc.pc.dao.admin;

import java.util.List;

import net.chinahrd.entity.dto.pc.admin.DaysDto;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author zhiwei 20161130
 *
 */
@Repository("daysDao")
public interface DaysDao {
	/**
	 * 查集合
	 * @param days
	 * @param beginDay
	 * @param endDay
	 * @return
	 */
	List<DaysDto> queryDays(DaysDto days);
	/**
	 * 查某种类型节假日的总天数
	 * @param days dto
	 * @param beginDay 范围开始
	 * @param endDay 范围结束
	 * @return
	 */
	Integer getCount(DaysDto days);
	
}
