package net.chinahrd.mvc.pc.dao.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import net.chinahrd.entity.dto.pc.common.MessageDto;

/**
 * 公共-信息Dao接口类
 */
@Repository("commonMessageDao")
public interface CommonMessageDao {

	/**
	 * 保存信息
	 * 
	 * @param userId
	 */
	void saveMessage(Map<String, Object> paramsMap);

	/**
	 * 查询信息
	 * 
	 * @param userId
	 * @param isRead
	 */
	List<MessageDto> queryMessage(@Param("userId") String userId, @Param("isRead") Integer isRead);
}
