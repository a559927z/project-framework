package net.chinahrd.utils;

import java.util.List;
import java.util.Map;

import net.chinahrd.entity.dto.KVItemDto;
import net.chinahrd.entity.dto.pc.admin.FunctionDto;
import net.chinahrd.module.SysCache;

/**
 * 缓存助手
 */
public class CacheHelper {

	private CacheHelper() {
	}

	/**
	 * 获得superAdminId
	 *
	 * @param organId
	 * @return
	 */
	public static String getSuperAdminId() {
		return SysCache.findSuperAdminId.get();
	}

	/**
	 * 获得所有子孙机构ID by 父机构ID
	 *
	 * @param organId
	 * @return
	 */
	public static List<String> getSubOrganIdList(String organId) {
		Map<String, List<String>> obj = SysCache.cacheAllSubOrganId.get();
		if (null != obj) {
			return obj.get(organId);
		}
		return null;
	}

	/**
	 * 获得所有子机构ID by 父机构ID
	 *
	 * @param organId
	 * @return
	 */
	public static List<String> getUnderSubOrganIdList(String organId) {
		Map<String, List<String>> obj = SysCache.cacheUnderAllSubOrganId.get();
		if (null != obj) {
			return obj.get(organId);
		}
		return null;
	}

	public static Double getConfigValByCacheDouble(String key) {
		Map<String, List<String>> formatObj = SysCache.config.get();

		if (null != formatObj) {
			List<String> rs = formatObj.get(PropertiesUtil.getProperty(key).trim());
			if (rs.size() > 0) {
				try {
					return Double.valueOf(rs.get(0));
				} catch (NumberFormatException e) {
					return null;
				}
			}
		}
		return 0.0;
	}

	public static List<Double> getConfigValsByCacheDouble(String key) {
		Map<String, List<String>> formatObj = SysCache.config.get();
		if (null != formatObj) {
			List<String> list = formatObj.get(PropertiesUtil.getProperty(key).trim());
			List<Double> dob = CollectionKit.newList();

			for (String string : list) {
				try {
					dob.add(Double.valueOf(string));
				} catch (NumberFormatException e) {
					return null;
				}
			}

			return dob;
		}
		return null;
	}

	/**
	 * 获取缓存单一值
	 *
	 * @param key
	 *            ConfigKeyUtil值
	 * @return
	 */
	public static Integer getConfigValByCacheInt(String key) {
		Map<String, List<String>> formatObj = SysCache.config.get();
		if (null != formatObj) {
			List<String> rs = formatObj.get(PropertiesUtil.getProperty(key).trim());
			if (rs.size() > 0) {
				try {
					return Integer.valueOf(rs.get(0));
				} catch (NumberFormatException e) {
					return null;
				}
			}
		}
		return 0;
	}

	/**
	 * 获取缓存多值
	 *
	 * @param key
	 *            ConfigKeyUtil值
	 * @return
	 */
	public static List<Integer> getConfigValsByCacheInt(String key) {
		Map<String, List<String>> formatObj = SysCache.config.get();
		if (null != formatObj) {
			List<String> rs = formatObj.get(PropertiesUtil.getProperty(key).trim());
			List<Integer> intRs = CollectionKit.newList();
			for (String i : rs) {
				try {
					intRs.add(Integer.valueOf(i));
				} catch (NumberFormatException e) {
					return null;
				}
			}
			return intRs;
		}
		return null;
	}

	/**
	 * 获取缓存单值
	 *
	 * @param key
	 * @return
	 */
	public static String getConfigValByCacheStr(String key) {
		Map<String, List<String>> formatObj = SysCache.config.get();
		if (null != formatObj) {
			List<String> list = formatObj.get(PropertiesUtil.getProperty(key).trim());
			try {
				return list.get(0);
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}

	/**
	 * 机构维
	 *
	 * @return
	 */
	public static List<KVItemDto> getOrgan() {
		List<KVItemDto> list = SysCache.queryOrgan.get();
		return list;
	}

	public static List<FunctionDto> getFunction() {
		return SysCache.queryFunction.get();
	}

	/**
	 * 传入url得到functionId，作用各个指标得到quotaId
	 *
	 * @param url
	 * @return
	 */
	public static String getFunctionId(String url) {
		List<FunctionDto> function = getFunction();
		for (FunctionDto dto : function) {
			if (dto.getUrl().equals(url)) {
				return dto.getFunctionId();
			}
		}
		return null;
	}
}
