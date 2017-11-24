package it.myst.swf.core.controllerbean;

import javax.faces.event.ComponentSystemEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import it.myst.swf.core.backingbean.CommonBBean;
import it.myst.swf.core.spring.utils.SpringUtils;

public abstract class AbstractCBean implements InitializingBean, DisposableBean {

	private static Logger logger = LoggerFactory.getLogger(AbstractCBean.class);

	@Override
	public final void afterPropertiesSet() throws Exception {
		logger.debug("afterPropertiesSet");
		this.initControllerBean();
	}

	@Override
	public final void destroy() throws Exception {
		logger.debug("destroy");
		this.destroyControllerBean();
	}

	public abstract void initControllerBean() throws Exception;

	public abstract void destroyControllerBean() throws Exception;

	public abstract void onPageRender(ComponentSystemEvent event) throws Throwable;

	public final void initPageRender(ComponentSystemEvent event) throws Throwable {
		logger.debug("initPageRender");
		this.onPageRender(event);
	}

	public void setPageName(String pageName) throws Throwable {
		CommonBBean commonBean = (CommonBBean) SpringUtils.getBean(CommonBBean.COMMON_BBEAN);
		commonBean.setCurrentPageName(pageName);
	}

}
