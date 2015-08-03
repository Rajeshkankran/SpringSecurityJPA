package com.tupa.app.webconfig;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;


@Configuration
public class WebInitlizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		
		AnnotationConfigWebApplicationContext appContext  = new AnnotationConfigWebApplicationContext();
		appContext.setConfigLocation("com.tupa.app.config");
		
		servletContext.addListener(new ContextLoaderListener(appContext));
		
		FilterRegistration.Dynamic securityFilter = servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"));
			
		securityFilter.addMappingForUrlPatterns(null, false, "/*");
		securityFilter.addMappingForServletNames(null, false, "dispatcherServlet");
		
		ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(appContext));
		
		
		dispatcherServlet.addMapping("/");
		
		
	}

	
	
	
}
