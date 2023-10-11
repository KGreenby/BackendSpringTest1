package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-bean.xml")
public class HelloBeanSpringNewTest {
	@Autowired
	ApplicationContext context;
	
	@Autowired
	Hello hello;
	
	@Test //@Disabled
	public void hello() {
		System.out.println(SpringExtension.class);
		System.out.println(context);
		System.out.println(hello);
		//assertEquals("Hello 스프링", hello.sayHello());
	}
}
