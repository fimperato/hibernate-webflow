package it.myst.swf.core.spring.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.XmlWebApplicationContext;

import it.myst.swf.constants.ConstantsApp;

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
	
	/**
	 * Clean della cache fornito, sulla base del valueCache in input
	 *
	 * @param valueCache
	 */
	public static void clearAllCache(String valueCache) {
		EhCacheCacheManager ehCacheCacheManager = SpringUtils
				.getBean(ConstantsApp.CACHE_MANAGER);
		if (ehCacheCacheManager != null) {
			ehCacheCacheManager.getCache(valueCache).clear();
		}
	}

	/**
	 * Esegue la get da cache in base alla singola key in input
	 *
	 * @param valueCache
	 * @param key
	 */
	public static void clearCacheByKey(String valueCache, String key) {
		EhCacheCacheManager ehCacheCacheManager = SpringUtils
				.getBean(ConstantsApp.CACHE_MANAGER);
		if (ehCacheCacheManager != null
				&& ehCacheCacheManager.getCache(valueCache) != null) {
			ehCacheCacheManager.getCache(valueCache).evict(key);
		}
	}

}
