package net.chinahrd.core.timer;

import lombok.extern.slf4j.Slf4j;
import net.chinahrd.core.web.init.DataInitialization;

import javax.servlet.ServletConfig;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月22日 00:10
 * @Verdion 1.0 版本
 * ${tags}
 */
@Slf4j
public class JobInitialization implements DataInitialization {
    @Override
    public void init(ServletConfig config) {
        log.info("=========================================>>>>");
    }
}
