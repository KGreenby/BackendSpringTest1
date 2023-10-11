package myspring.di.strategy1.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;


public class XmlUserServiceTest {

	BeanFactory factory;

	@BeforeEach
	void init() {
		factory = new GenericXmlApplicationContext("classpath:user-bean.xml");
	}
	
	@Test
	void beanTest() {
		UserService userService = factory.getBean("userService", UserServiceImpl.class);
		assertEquals(2, userService.getUserList().size());
	}
};
