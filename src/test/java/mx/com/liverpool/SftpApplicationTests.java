package mx.com.liverpool;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SftpApplicationTests {

	@Test
	void contextLoads() {
		new UpAndDownload().upload();
	}

}
