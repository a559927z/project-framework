package net.chinahrd.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @author jxzhang on 2017年08月17
 * @Verdion 1.0版本
 */
@Service("mbService")
public class MbServiceImpl implements MbService {

    @Autowired
    private MbDao mbDao;

    @Override
    public Integer findTb() {
        return mbDao.findTb();
    }

    @Override
    public List<MbDto> queryTb(Map<String, Object> paramMap) {
        return mbDao.queryTb(paramMap);
    }
}
