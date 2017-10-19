package com.ks.eg.mybatis;

import java.util.List;
import java.util.Map;

/**
 * @author jxzhang on 2017年08月17
 * @Verdion 1.0版本
 */
public interface MbService {

    Integer findTb();

    List<MbDto> queryTb(Map<String, Object> paramMap);
}
