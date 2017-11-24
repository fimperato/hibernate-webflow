package it.myst.swf.web.controllerbean;

import javax.faces.event.ComponentSystemEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import it.myst.swf.core.controllerbean.AbstractCBean;
import it.myst.swf.core.spring.utils.SpringUtils;
import it.myst.swf.core.web.data.MyFlowData;
import it.myst.swf.core.web.data.MySaltoData;
import it.myst.swf.core.web.data.MySaltoDataInFlowScope;
import it.myst.swf.utility.business.service.UtilityService;
import it.myst.swf.web.backingbean.TestOperazioniBBean;

public class SaltoTestCBean extends AbstractCBean {
	
	private static Logger logger = LoggerFactory.getLogger(AbstractCBean.class);

	@Autowired 
	private UtilityService utilityService;

	public MyFlowData initFlow(MySaltoDataInFlowScope mySaltoZero, MySaltoData mySalto) {
		MyFlowData myFlowData = new MyFlowData();
		
		TestOperazioniBBean bBean = SpringUtils.getBean("testOperazioniBBean");
		String conversationAttribute=bBean.getBbAttributeOne();
		logger.info("conversationAttribute is: "+conversationAttribute);
		
		return myFlowData;
	}
	
	public MySaltoDataInFlowScope initDataExchange() {
		MySaltoDataInFlowScope mySaltoData = new MySaltoDataInFlowScope();
		mySaltoData.setNome("nome-00");
		return mySaltoData;
	}
	
	public MySaltoData buildDataSaltoSelezionato()  {
		MySaltoData mySaltoData = new MySaltoData();
		mySaltoData.setNome("nome-ab-01");
		return mySaltoData;
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
		return utilityService;
	}

	public void setUtilityService(UtilityService service) {
		this.utilityService = service;
	} 

}
