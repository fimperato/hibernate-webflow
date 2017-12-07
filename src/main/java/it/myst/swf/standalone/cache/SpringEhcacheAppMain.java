package it.myst.swf.standalone.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.myst.swf.core.config.AppConfig;
import it.myst.swf.utility.business.service.MappaParametriService;
import it.myst.swf.utility.business.service.UserService;
import it.myst.swf.utility.domain.entity.User;

public class SpringEhcacheAppMain {
	
	private static Logger logger = LoggerFactory.getLogger(SpringEhcacheAppMain.class);

	/**
	 * Main to test ehcache config
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// ##### Service level cache ##### 
		UserService userService = context.getBean("userService", UserService.class);
		MappaParametriService mappaParametriService = context.getBean("mappaParametriService", MappaParametriService.class);
		
		testUserServiceCache(userService);
		testMappaParametriServiceCache(mappaParametriService);
		
		// Close application context (destroy also cached resources)
		((ConfigurableApplicationContext) context).close();
		// ##### Service level cache END ##### 
		
		
		// ##### Entity level cache ##### 
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		User user=(User)ctx.getBean(User.class);
		long initMs=0, finalMs=0;
		
		// calling getCachedUser method first time:
		initMs = System.currentTimeMillis();
		logger.info("## Search user-A ##");
		logger.info("User: "+ user.getCachedUser("user_A"));
		finalMs = System.currentTimeMillis();
		logger.info("--> Time to fetch: " + (finalMs - initMs)/1000 + " sec");
		
		// ..and second time: method will not execute this time:
		initMs = System.currentTimeMillis();
		logger.info("## Search user-A (second time result will be fetched from cache) ##");
		logger.info("User: "+user.getCachedUser("user_A"));
		finalMs = System.currentTimeMillis();
		logger.info("--> Time to fetch: " + (finalMs - initMs)/1000 + " sec");
		
		//calling getCachedUser method third time with different value.
		initMs = System.currentTimeMillis();
		logger.info("## Search user-B (not in cache) ##");
		logger.info("User: "+user.getCachedUser("user_B"));
		finalMs = System.currentTimeMillis();
		logger.info("--> Time to fetch: " + (finalMs - initMs)/1000 + " sec");
		
		ctx.close();
		// ##### Entity level cache END ##### 
		
	}

	private static void testUserServiceCache(UserService userService) {
		logger.info("# Search user1: ");
		long initMs = System.currentTimeMillis();
		userService.findUser("usernametest1");
		long finalMs = System.currentTimeMillis();
		logger.info("--> Time to fetch user1: " + (finalMs - initMs)/1000 + " sec");
		
		logger.info("# Search user1 again: ");
		initMs = System.currentTimeMillis();
		userService.findUser("usernametest1");
		finalMs = System.currentTimeMillis();
		logger.info("--> Time to fetch user1 (cached): " + (finalMs - initMs)/1000 + " sec");
		
		logger.info("# Search user2: ");
		initMs = System.currentTimeMillis();
		userService.findUser("usernametest2");
		finalMs = System.currentTimeMillis();
		logger.info("--> Time to fetch user2 (not cached) " + (finalMs - initMs)/1000 + " sec");
	}
	
	private static void testMappaParametriServiceCache(MappaParametriService mappaParametriService) {
		logger.info("[testMappaParametriServiceCache] (#1)");
		long initMs = System.currentTimeMillis();
		mappaParametriService.getAllEntities();
		long finalMs = System.currentTimeMillis();
		logger.info("--> Time to fetch all parameters: " + (finalMs - initMs)/1000 + " sec");
		
		logger.info("(#2)");
		initMs = System.currentTimeMillis();
		mappaParametriService.getAllEntities();
		finalMs = System.currentTimeMillis();
		logger.info("--> Time to fetch all parameters (cached): " + (finalMs - initMs)/1000 + " sec");
	}
}
