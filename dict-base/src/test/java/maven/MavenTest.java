package maven;

import org.junit.Test;

import net.chinahrd.utils.Identities;

public class MavenTest {

	@Test
	public void uuid2() {
		for (int i = 0; i < 10; i++) {
			String uuid = Identities.uuid2();
			System.out.println(uuid);
		}
	}
}
