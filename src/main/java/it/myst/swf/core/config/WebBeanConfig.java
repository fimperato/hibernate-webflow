package it.myst.swf.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.myst.swf.core.web.backingbean.ErrorBBean;
import it.myst.swf.web.backingbean.TestOperazioniBBean;
import it.myst.swf.web.controllerbean.SaltoTestCBean;
import it.myst.swf.web.controllerbean.TestOperazioniCBean;


@Configuration
public class WebBeanConfig {

	@Bean
    public SaltoTestCBean saltoTestCBean() {
        return new SaltoTestCBean();
    }
	
	@Bean
    public TestOperazioniCBean testOperazioniCBean() {
        return new TestOperazioniCBean();
    }
	
	/*
	 * BackingBean
	 */

	@Bean
//	@ConversationScoped
	@Scope("conversation")
    public TestOperazioniBBean testOperazioniBBean() {
        return new TestOperazioniBBean();
    }

	@Scope("session")
	public ErrorBBean erroreBBean() {
        return new ErrorBBean();
    }
	
}
