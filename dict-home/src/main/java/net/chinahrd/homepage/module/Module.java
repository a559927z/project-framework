/**
*net.chinahrd.core.cache
*/
package net.chinahrd.homepage.module;

import net.chinahrd.core.api.ApiRegister;
import net.chinahrd.core.cache.CacheRegister;
import net.chinahrd.core.job.JobRegister;
import net.chinahrd.core.menu.MenuRegister;
import net.chinahrd.core.module.ModuleRegister;
import net.chinahrd.core.module.ModuleService;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 模块注册中心接口
 * 
 * @author htpeng 2016年10月8日下午1:42:50
 */
@Lazy(false)
@Component("home-page-model")
public class Module extends ModuleRegister {

	@Override
	protected CacheRegister registerCache() {
		return new CacheDefine();
	}

	@Override
	protected MenuRegister registerMenu() {
		return new Menu();
	}

	@Override
	protected String getFilePath() {
		return "module.properties";
	}

	@Override
	protected ApiRegister registerApi() {
		return null;
	}

	@Override
	protected ModuleService install() {
		return null;
	}

	@Override
	protected ModuleService uninstall() {
		return null;
	}

	@Override
	protected JobRegister registerJob() {
		return null;
	}

}
