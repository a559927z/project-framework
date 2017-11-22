package com.ks.eg.mybatis;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:eg/test-mybatis.xml")
@ActiveProfiles("test")
public class TestMybatis {

    @Autowired
    private MbService mbService;

    @Test
    public void findTbTest() {
        Integer tb = mbService.findTb();
        System.out.println(tb);
    }

    @Test
    public void queryTbTest() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("age", 15);
        List<MbDto> rs = mbService.queryTb(paramMap);
        for (MbDto dto : rs) {
            System.out.println(dto.getUsername() + "__" + dto.getAge());
        }
    }

}
