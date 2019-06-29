/**
 * net.chinahrd.core.module.modle
 */
package net.chinahrd.core.module.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import net.chinahrd.core.ConfigEnum;
import net.chinahrd.core.InjectionModel;
import net.chinahrd.core.ReadModel;
import net.chinahrd.core.menu.model.MenuModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 模块模型
 *
 * @author jxzhang
 * 2016年10月12日下午5:47:51
 */
@Data
@NoArgsConstructor
public class ModuleModel {
    private String moduleId;
    private String code;
    private String name;
    private String version;
    private int status = 1; //默认 为1

    private MenuModel menuModel;
    private InjectionModel apiInjection;
    private List<InjectionModel> jobInjectionList;
    Class<?> cacheDaoClass;
    Class<?> cacheClass;

    /**
     * @param xmlModel
     */
    public ModuleModel(ReadModel xmlModel) {
        this.code = xmlModel.getAttribute(ConfigEnum.CODE);
        this.name = xmlModel.getAttribute(ConfigEnum.NAME);
        this.version = xmlModel.getAttribute(ConfigEnum.VERSION);
    }


    /**
     * @param jobInjection the jobInjection to set
     */
    public void setJobInjection(InjectionModel jobInjection) {
        if (null == jobInjectionList) {
            jobInjectionList = new ArrayList<InjectionModel>();
        }
        jobInjectionList.add(jobInjection);
//		this.jobInjection = jobInjection;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String str = "code:" + code + ";name:" + name + ";version:" + version + ";";
//		str+="\n"+menuModel;
        return str;
    }


}
