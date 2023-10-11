package myspring.di.strategy1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myspring.di.strategy1.dao.UserDao;
import myspring.di.strategy1.dao.UserDaoImpl;
import myspring.di.strategy1.service.UserServiceImpl;

@Configuration
public class XmlUserConfig {
	@Bean
	public UserDao userdaoImpl() {
		return new UserDaoImpl();
	}
	
	@Bean
	public UserServiceImpl userServiceImpl() {
		UserServiceImpl userService = new UserServiceImpl();
		userService.setUserdao(userdaoImpl());
		return userService;
	}
}
