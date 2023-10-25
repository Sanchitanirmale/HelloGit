package com.cjc.springmvcjavabased.config;

import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebXml implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		System.out.println("welcome to webxml java based class");
		AnnotationConfigWebApplicationContext acp=new AnnotationConfigWebApplicationContext();
		  acp.register(AppConfig.class);
		  acp.setServletContext(sc);
		  
		  DispatcherServlet ds=new DispatcherServlet(acp);
		  ServletRegistration.Dynamic sd=sc.addServlet("dispatcher",ds);
		  sd.addMapping("/");
		  
	}

}