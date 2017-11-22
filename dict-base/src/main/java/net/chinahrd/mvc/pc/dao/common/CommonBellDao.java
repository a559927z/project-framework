package net.chinahrd.mvc.pc.dao.common;

import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * 公共-信息Dao接口类
 */
@Repository("commonBellDao")
public interface CommonBellDao {

	/**
	 * 待验证好友总数
	 * 
	 * @param paramMap
	 * @return
	 */
	Integer findStayAuthc(Map<String, Object> paramMap);


}
