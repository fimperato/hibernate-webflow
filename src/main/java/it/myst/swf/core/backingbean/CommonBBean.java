package it.myst.swf.core.backingbean;

import java.io.Serializable;

import it.myst.swf.core.spring.utils.SpringUtils;

public class CommonBBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String COMMON_BBEAN= "commonBBean";

	private String standardTemplate = "/WEB-INF/template/standardTemplate.xhtml";

	private String currentPageName;

	private String gotoAction;

	public static CommonBBean getBean(){
		return SpringUtils.getBean(COMMON_BBEAN);
	}

	public String getCurrentPageName() {
		return this.currentPageName;
	}

	public void setCurrentPageName(String currentPageName) {
		this.currentPageName = currentPageName;
	}

	public String getGotoAction() {
		return this.gotoAction;
	}

	public void setGotoAction(String gotoAction) {
		this.gotoAction = gotoAction;
	}

	public String getStandardTemplate() {
		return this.standardTemplate;
	}

	public void setStandardTemplate(String standardTemplate) {
		this.standardTemplate = standardTemplate;
	}

}
