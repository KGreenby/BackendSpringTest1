package myspring.di.aaa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.annot.HelloCons;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

// 객체 생성 어노테이션
// new GenericXmlApplicationContext("classpath:spring-beans.xml"); 와 같은 역할
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class HelloBeanSpringTest {
	
	@Autowired // 연결안해줄 시에는 객체생성이 안되기 때문에 null이 뜬다
	Hello hello;
	
	@Autowired
	@Qualifier("helloC") // 같은 타입의  여러 빈이 등록되어 있을때 지정해줌
	Hello hello2;
	
	@Resource(name = "helloC")
	Hello hello3;
	
	@Autowired
	@Qualifier("strPrinter")
	Printer printer;
	
	@Test //@Disabled
	public void hello() {
		System.out.println(hello);
		assertEquals("Hello 스프링", hello.sayHello());
		
		hello.print();
		assertEquals("Hello 스프링", printer.toString());
	}
	
	@Test
	public void helloC() {
		//System.out.println(hello2.sayHello());
		assertEquals("Hello 생성자", hello2.sayHello());
		assertEquals("Hello 생성자", hello3.sayHello());
		
	}
	
}
