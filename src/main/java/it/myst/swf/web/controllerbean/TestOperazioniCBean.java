package it.myst.swf.web.controllerbean;

import javax.faces.event.ComponentSystemEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import it.myst.swf.core.controllerbean.AbstractCBean;
import it.myst.swf.core.spring.utils.SpringUtils;
import it.myst.swf.utility.business.service.UtilityService;
import it.myst.swf.web.backingbean.TestOperazioniBBean;

public class TestOperazioniCBean extends AbstractCBean {
	
	private static Logger logger = LoggerFactory.getLogger(TestOperazioniCBean.class);

	@Autowired
	private UtilityService service;

//	@Inject private BeanManager beanManager;
	
	public void initData() {
		TestOperazioniBBean bBean = SpringUtils.getBean("testOperazioniBBean");
		Object scope = SpringUtils.getBeanScope("testOperazioniBBean");
//		getAllViewScoped();
		bBean.setBbAttributeOne("gestioneOperazioniThree");
	}
	
//	public List<Object> getAllViewScoped() {
//	    List<Object> allBeans = new ArrayList<Object>();
//	    Set<Bean<?>> beans = this.getBeanManager().getBeans(Object.class);
//	    // NOTE - context has to be active when you try this
//	    Context context = this.getBeanManager().getContext(ConversationScoped.class);
//
//	    for (Bean<?> bean : beans) {
//	        Object instance = context.get(bean);
//	        if (instance != null) {
//	            allBeans.add(instance);
//	        }
//	    }
//	    return allBeans;
//	}
	
	public String actionStateGestioneOperazioni() {
		TestOperazioniBBean bBean = SpringUtils.getBean("testOperazioniBBean");

		return bBean.getBbAttributeOne();
	}
	
	public void checkAttributeScope() {
		TestOperazioniBBean bBean = SpringUtils.getBean("testOperazioniBBean");
		logger.info("check attribute TestOperazioniBBean (1): "+bBean.getBbAttributeOne());
	}
	
	@Override
	public void initControllerBean() throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroyControllerBean() throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void onPageRender(ComponentSystemEvent event) throws Throwable {
		// TODO Auto-generated method stub
	}

	public UtilityService getUtilityService() {
		return service;
	}

	public void setUtilityService(UtilityService service) {
		this.service = service;
	}
	
}
