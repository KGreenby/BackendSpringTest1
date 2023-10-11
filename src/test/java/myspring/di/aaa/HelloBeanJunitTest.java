package myspring.di.aaa;

import static org.junit.jupiter.api.Assertions.*; // static import

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanJunitTest {
	
	BeanFactory factory;
	
	@BeforeEach
	void init() {
		// 1. Spring Bean Container 객체생성
		factory = new GenericXmlApplicationContext("classpath:spring-beans.xml");		
	}
	
	@Test //@Disabled
	void 생성자주입테스트() {
		//constructor 인젝션 테스트
		Hello helloBean = factory.getBean("helloC", Hello.class);
		assertEquals("Hello 생성자", helloBean.sayHello());
		helloBean.print();
		
		List<String> names = helloBean.getNames();
		assertEquals(3, names);
		assertEquals("SpringBoot", names.get(1));
	}
	
	@Test @Disabled
	void hello() {
		//setter인젝션 테스트
		// 2. Container가 생성한 Bean을 요청하기
		Hello hello1 = (Hello)factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class); // 이 방법 권장
		
		// 3. HelloBean 래퍼런스 비교하기
		// 싱글톤인지 확인하기 위헤
//		Assertions.assertSame(hello1, hello2); // static import 했기 때문에 Assertions 안적어줘도 됨
		assertSame(hello1, hello2); // 주소가 같으면 테스트 성공
		System.out.println(hello1 == hello2); // 주소가 같으면 true
		// 테스트 성공 혹은 true가 뜨면, 싱글톤 성공
		
		assertEquals("Hello 스프링", hello2.sayHello());
		hello2.print();
		
		// toString 테스트
		Printer printer = factory.getBean("strPrinter", Printer.class); //strPrinter가 Printer의 하위이기 때문에
		assertEquals("Hello 스프링", printer.toString());
		
		
	}
}
