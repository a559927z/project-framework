package net.chinahrd.tx.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author jxzhang on 2017年08月17
 * @Verdion 1.0版本
 */
@Service("txService")
public class TxServiceImpl implements TxService {

    @Autowired
    private TxDao txDao;

    @Override
    public void saveTbA(TxDto dto) {
        txDao.saveTbA(dto);
//        saveTbB(dto);
    }

    @Override
    public void saveTbB(TxDto dto) {
        txDao.saveTbB(dto);
//        throw new RuntimeException();
    }
}
