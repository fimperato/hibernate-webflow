package it.myst.swf.core.spring.cache;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.myst.swf.core.config.AppConfig;
import it.myst.swf.utility.domain.entity.User;

public class SpringEhcacheDemo {

	public static void main(String... args) {
   	 	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
   	 	ctx.register(AppConfig.class);
   	 	ctx.refresh();
        User user=(User) ctx.getBean(User.class);
           
        //calling getEmployee method first time.
        System.out.println("---Fetch Employee with id 1---");
        System.out.println("Employee:"+ user.getCachedUser(1));
           
        //calling getEmployee method second time. This time, method will not execute.
        System.out.println("---Again Fetch Employee with id 1, result will be fetched from cache---");
        System.out.println("Employee:"+user.getCachedUser(1));
           
        //calling getEmployee method third time with different value.
        System.out.println("---Fetch Employee with id 2---");
        System.out.println("Employee:"+user.getCachedUser(2));
    } 

}
