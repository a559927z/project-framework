package net.chinahrd.tx.xml;

import net.chinahrd.utils.Identities;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-tx2.xml")
@ActiveProfiles("test")
public class TestTxXML {

    @Autowired
    private TxService txService;

    @Test
    public void test() {
        TxDto dto = new TxDto();
        dto.setUsername(Identities.uuid2());
        dto.setAge(15);
        try{
            txService.saveTbA(dto);
        }catch (Exception e){
            System.out.println("处理异常");
        }
    }

}
