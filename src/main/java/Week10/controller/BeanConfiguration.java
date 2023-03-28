package Week10.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Week10.beans.House;


/**
 * @author Scott Grigsby-sdgrigsby
 *CIS175-Spring 2023
 * Mar 28, 2023
 */
@Configuration
public class BeanConfiguration {

	@Bean
	public House House() {
		House bean = new House();
		return bean;
	}
}
