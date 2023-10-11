package myspring.di.strategy2.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.strategy2.service.UserService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AnnotUserConfig.class, 
					  loader = AnnotationConfigContextLoader.class)
public class AnnotConfigTest {
	@Autowired
	UserService userService;
	
	@Test
	void beanTest() {
		assertEquals(2, userService.getUserList().size());
	}
}
