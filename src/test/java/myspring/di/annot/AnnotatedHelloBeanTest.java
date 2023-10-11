package myspring.di.annot;

import javax.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration (locations = "classpath:spring-beans-annot.xml")
public class AnnotatedHelloBeanTest {
	@Autowired 
	Hello hello; // Hello타입이 하나밖에 없기 때문에 이름 안 맞춰줘도 됨
	
	@Resource(name = "stringPrinter")
	Printer printer;
	
	@Autowired
	HelloCons helloCons;
	
	@Test 
	public void helloBean() {
		Assertions.assertEquals("Hello 어노테이션", hello.sayHello());
		hello.print();
		Assertions.assertEquals("Hello 어노테이션", printer.toString());
	}
	
	@Test
	public void helloConsBean() {
		Assertions.assertEquals("Hello annot생성자", helloCons.sayHello());
		helloCons.print();
	}
	
	
}
