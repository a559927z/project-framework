package com.ks.eg.mybatis;

import java.util.Map;

/**
 * @author jxzhang on 2017年08月23
 * @Verdion 1.0版本
 */
public class MbProvider {

    public String tbSql(Map paramMap) {
        Map map = (Map) paramMap.get("paramMap");
        String sql =
                "SELECT * FROM `_tmp_tx_a` WHERE age='" + map.get("age") + "'";
        return sql;
    }
}
