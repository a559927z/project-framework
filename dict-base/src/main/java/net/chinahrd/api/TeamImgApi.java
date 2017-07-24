/**
*net.chinahrd.entity.module
*/
package net.chinahrd.api;


import java.util.List;

import net.chinahrd.entity.dto.KVItemDto;

/**团队画像API文档
 * @author htpeng
 *2016年10月18日下午5:20:18
 */
public interface TeamImgApi {
	

	/**
	 * 分组统计能力层级人数
	 * 
	 * @param organId
	 * @param customerId
	 * @return
	 */
	List<KVItemDto> groupCountTeamImgAb(String organId, String customerId);
}
