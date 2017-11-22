package com.ks.eg.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

/**
 * @author jxzhang on 2017年08月17
 * @Verdion 1.0版本
 */
@Repository("mbDao")
public interface MbDao {

    Integer findTb();

    @SelectProvider(type = MbProvider.class, method = "tbSql")
    List<MbDto> queryTb(@Param("paramMap") Map<String, Object> paramsMap);

}
