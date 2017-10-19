package net.chinahrd.tx.xml;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author jxzhang on 2017年08月17
 * @Verdion 1.0版本
 */
@Repository("txDao")
public interface TxDao {

    void saveTbA(@Param("dto") TxDto dto);

    void saveTbB(@Param("dto") TxDto dto);
}
