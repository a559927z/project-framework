/**
*net.chinahrd
*/
package net.chinahrd.homepage.module;

import net.chinahrd.core.cache.CacheRegisterAbstract;

/**
 * @author htpeng 2016年10月8日下午1:45:11
 */

public class CacheDefine extends CacheRegisterAbstract {

	@Override
	protected String getXmlPath() {
		return "mapper/common/Cache.xml";
	}

	@Override
	public Class<? extends Object> getCacheClass() {
		return Cache.class;
	}

}
