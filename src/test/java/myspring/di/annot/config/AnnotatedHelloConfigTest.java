package myspring.di.annot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.Hello;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AnnotatedHelloConfig.class, //xml이 아닌 java class에 작성했기 때문에 classes 사용
					  loader = AnnotationConfigContextLoader.class) // 빈컨테이너 종류가 바뀌었기 때문에 로더를 사용해줌
					  //AnnotationConfigContextLoader.class -> AnnotationConfigContextLoader라는 빈 컨테이너를 로딩해주는 역할을 함
public class AnnotatedHelloConfigTest {
	@Autowired
	Hello hello;
	
	@Test
	public void hello() {
		System.out.println(hello.sayHello());
	}
}
