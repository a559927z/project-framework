package com.ks.mybatis;

import java.util.List;
import java.util.Map;

import com.ks.dto.UserDto;

/**
 * @author jxzhang on 2017年08月17
 * @Verdion 1.0版本
 */
public interface MbService {

    Integer findTb();

    List<UserDto> queryTb(Map<String, Object> paramMap);
}
