package myspring.di.strategy2.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.strategy2.service.UserService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:user-annot-bean.xml")
public class AnnotUserServiceTest {
	@Autowired
	UserService userService;
	
	@Test
	void beanTest() {
		assertEquals(2, userService.getUserList().size());
	}
	
}
