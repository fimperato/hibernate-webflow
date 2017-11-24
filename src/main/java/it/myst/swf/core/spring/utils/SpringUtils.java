package it.myst.swf.core.spring.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * 
 *
 */
@Component
public class SpringUtils implements ApplicationContextAware {

//	@Autowired
//	private static ApplicationContext ctx;
	
	private static ApplicationContext applicationContext;
	
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.context.ApplicationContextAware#setApplicationContext
	 * (org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		SpringUtils.applicationContext = arg0;

	}

	public static <T> T getBean(String beanName) {
		
		return (T) SpringUtils.applicationContext.getBean(beanName);
	}
	
	public static <T> T getBeanScope(String beanName) {
		ConfigurableApplicationContext capptx = (ConfigurableApplicationContext)applicationContext;
		return (T) capptx.getBeanFactory().getBeanDefinition(beanName).getScope();
	}

	public void resetSessionBean(String beanName){
		ApplicationContext context = SpringUtils.applicationContext;
		if(context!=null && context instanceof XmlWebApplicationContext){
			XmlWebApplicationContext appContext = (XmlWebApplicationContext) context;
			ConfigurableListableBeanFactory configurableListableBeanFactory = appContext
	                .getBeanFactory();
			configurableListableBeanFactory.destroyScopedBean(beanName);
		}
		Object newBean = SpringUtils.getBean(beanName);
	}

}
