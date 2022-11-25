package com.sarthak.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculatorApplicationInitializer// implements WebApplicationInitializer
{

	public void onStartup(ServletContext servletContext) throws ServletException {

		
//		For Loading Xml configuration files
//		XmlWebApplicationContext xmlWebApplicationContext = new XmlWebApplicationContext();
//		xmlWebApplicationContext.setConfigLocation("classpath:config.xml");
		
//		For java based configuration files...
		AnnotationConfigWebApplicationContext  webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(LoveCalculatorAppConfig.class);
		
//		Create a dispatcher Servlet object for xml based configuration
//		DispatcherServlet dispatcherServlet = new DispatcherServlet(xmlWebApplicationContext);
		
//		Create a dispatcher Servlet object for java based configuration
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		
//		Register dispatcher servlet with servlet context.
		Dynamic myCustomeDispatcherServlet = servletContext.addServlet("myDispatcherServlet",dispatcherServlet);
		
		myCustomeDispatcherServlet.setLoadOnStartup(1);
		myCustomeDispatcherServlet.addMapping("/sarthak.com/*");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
