package it.myst.swf.core.config.standalone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.myst.swf.core.config.BeanConfig;

public class Application {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		System.out.println("do something here");
		
		((ConfigurableApplicationContext) context).close();

	}
}
