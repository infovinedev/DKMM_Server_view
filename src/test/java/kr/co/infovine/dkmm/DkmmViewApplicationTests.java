package kr.co.infovine.dkmm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DkmmViewApplication.class
, 
properties = {"server.mode=local"})
class DkmmViewApplicationTests {

	@Test
	void contextLoads() {
	}

}
