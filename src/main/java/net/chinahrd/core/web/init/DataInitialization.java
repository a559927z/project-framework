package net.chinahrd.core.web.init;

import javax.servlet.ServletConfig;

/**
 * 初始化加载接口
 *
 * @author jxzhang
 * 2016年2月2日下午2:27:53
 */
public interface DataInitialization {
    void init(ServletConfig config);
}
