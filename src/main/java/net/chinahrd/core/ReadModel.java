/**
 * net.chinahrd.core
 */
package net.chinahrd.core;

/**
 * @author jxzhang
 *2016年10月13日下午2:38:28
 */
public interface ReadModel {
    String getAttribute(String key);

    String getAttribute(ConfigEnum key);
}
