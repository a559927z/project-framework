/**
 * net.chinahrd.core.menu
 */
package net.chinahrd.core.module;

import net.chinahrd.core.module.model.ModuleModel;

import java.util.List;


/**
 * 模块与数据库同步
 *
 * @author jxzhang
 * 2016年10月12日下午2:59:04
 */

public interface ModuleSynchronization {

    /**
     *
     */
    void synchronization(List<ModuleModel> list);

}
