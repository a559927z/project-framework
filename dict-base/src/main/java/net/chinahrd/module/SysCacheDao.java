/**
 * net.chinahrd.cache
 */
package net.chinahrd.module;

import java.util.List;

import net.chinahrd.entity.dto.KVItemDto;
import net.chinahrd.entity.dto.pc.DegreeDto;
import net.chinahrd.entity.dto.pc.SequenceItemsDto;
import net.chinahrd.entity.dto.pc.SubSequenceItemsDto;
import net.chinahrd.entity.dto.pc.admin.FunctionDto;
import net.chinahrd.entity.dto.pc.common.ConfigDto;

import org.apache.ibatis.annotations.Param;

/**
 * sys缓存
 *
 * @author jxzhang on 2016-11-07
 */
public interface SysCacheDao {

	/**
	 * 配置表
	 *
	 * @return
	 */
	List<ConfigDto> queryConfig(@Param("customerId") String customerId);

	/**
	 * 机构与所有子孙机构的关系
	 *
	 * @param customerId
	 * @return
	 */
	List<KVItemDto> queryAllOrganRelation(@Param("customerId") String customerId);

	/**
	 * 机构与所有子机构的关系
	 *
	 * @param customerId
	 * @return
	 */
	List<KVItemDto> queryUnderAllOrganRelation(@Param("customerId") String customerId);

	// =================================
	// 维度表
	// =================================
	List<KVItemDto> queryOrgan(@Param("customerId") String customerId);

	List<FunctionDto> queryFunction(@Param("customerId") String customerId);

}
