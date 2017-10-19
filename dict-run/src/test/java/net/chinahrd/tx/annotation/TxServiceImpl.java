package net.chinahrd.tx.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author jxzhang on 2017年08月17
 * @Verdion 1.0版本
 */
@Transactional(isolation = Isolation.READ_COMMITTED)    // oracle默认READ_COMMITTED。 mySQL默认：REPEATABLE_READ
//@TransactionConfiguration(defaultRollback = false)    //保护数据现场：默认true
@Service("txService")
public class TxServiceImpl implements TxService {

    @Autowired
    private TxDao txDao;

    @Override
    public void saveTbA(TxDto dto) {
        txDao.saveTbA(dto);
        saveTbB(dto);
    }

    @Override
    public void saveTbB(TxDto dto) {
        txDao.saveTbB(dto);
        throw new RuntimeException();
    }
}
