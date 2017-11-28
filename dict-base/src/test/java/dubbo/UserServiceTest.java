package dubbo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ks.dto.UserDto;
import com.ks.service.UserService;

public class UserServiceTest {

	@Test
	public void findTbTest() {

		// 测试常规服务
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:dubbo-consumer.xml");
		context.start();
		UserService service = context.getBean(UserService.class);
		UserDto dto = service.findUserById("b5c9410dc7e4422c8e0189c7f8056b5f", "USER_superAdmin");

		System.out.println("=========" + dto.getEmail());
	}

}
