package it.myst.swf.core.spring.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.myst.swf.core.config.AppConfig;
import it.myst.swf.utility.business.service.UserService;

public class SpringEhcacheApplication {
	
	private static Logger logger = LoggerFactory.getLogger(SpringEhcacheApplication.class);

	/**
	 * Main to test ehcache config
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserService obj = context.getBean("userService", UserService.class);
		
		logger.info("# Search user1: ");
		long initMs = System.currentTimeMillis();
		obj.findUser("usernametest1");
		long finalMs = System.currentTimeMillis();
		logger.info("--> Time to fetch user1: " + (finalMs - initMs)/1000 + " sec");
		
		logger.info("# Search user1 again: ");
		initMs = System.currentTimeMillis();
		obj.findUser("usernametest1");
		finalMs = System.currentTimeMillis();
		logger.info("--> Time to fetch user1 (cached): " + (finalMs - initMs)/1000 + " sec");
		
		logger.info("# Search user2: ");
		initMs = System.currentTimeMillis();
		obj.findUser("usernametest2");
		finalMs = System.currentTimeMillis();
		logger.info("--> Time to fetch user2 (not cached) " + (finalMs - initMs)/1000 + " sec");
		
		// Close application context (destroy also cached resources)
		((ConfigurableApplicationContext) context).close();

	}
}
