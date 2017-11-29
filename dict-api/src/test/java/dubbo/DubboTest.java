package dubbo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ks.dto.UserDto;
import com.ks.service.UserService;

public class DubboTest {

	@Test
	public void findTbTest() {

		// 测试常规服务
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath*:dubbo-consumer-sysempinfo.xml");
		context.start();
		UserService service = context.getBean(UserService.class);
		UserDto dto = service.findUserById("b5c9410dc7e4422c8e0189c7f8056b5f", "USER_jxzhang");

		System.out.println("=========" + dto.getUserNameCh());
	}

}
