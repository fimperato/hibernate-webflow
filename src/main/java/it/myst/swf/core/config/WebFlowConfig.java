package it.myst.swf.core.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.faces.config.AbstractFacesFlowConfiguration;
import org.springframework.faces.webflow.FlowFacesContextLifecycleListener;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.scope.ConversationScope;
import org.springframework.webflow.security.SecurityFlowExecutionListener;

import it.myst.swf.core.config.condition.MvcEnabledCondition;

/**
 * Disabled in standalone app main
 * 
 * @author Francesco
 *
 */
@Configuration
@Conditional(MvcEnabledCondition.class)
public class WebFlowConfig extends AbstractFacesFlowConfiguration {

	@Bean
	public FlowExecutor flowExecutor() {
		return getFlowExecutorBuilder(flowRegistry())
				.addFlowExecutionListener(new FlowFacesContextLifecycleListener())
				.addFlowExecutionListener(new SecurityFlowExecutionListener())
				.build();
	}

	@Bean
	public FlowDefinitionRegistry flowRegistry() {
		return getFlowDefinitionRegistryBuilder(flowBuilderServices())
				.setBasePath("/WEB-INF/flows")
				.addFlowLocationPattern("/**/*-flow.xml")
				.build();
	}

	@Bean
	public FlowBuilderServices flowBuilderServices() {
		return getFlowBuilderServicesBuilder().setDevelopmentMode(true).build();
	}
	
	/*
	 * https://stackoverflow.com/questions/15435860/spring-javaconfig-beans-custom-scopes-and-annotations
	 */
	@Bean
	public CustomScopeConfigurer customScope () {
	    CustomScopeConfigurer configurer = new CustomScopeConfigurer ();
	    Map<String, Object> workflowScope = new HashMap<String, Object>();
	    workflowScope.put("conversation", new ConversationScope());
	    configurer.setScopes(workflowScope);

	    return configurer;
	}

}
