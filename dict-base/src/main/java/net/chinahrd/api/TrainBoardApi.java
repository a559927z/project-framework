package net.chinahrd.api;

import java.util.Map;

/**
 * 培训看板的 Api 接口
 * @author xwli
 * 2017年5月8日
 */
public interface TrainBoardApi {
	Map<String, Object> getSubOrganizationCover(String customerId, String organId);
	
	Map<String, Object>  getTrainingType(String customerId, String organId);
	
}
