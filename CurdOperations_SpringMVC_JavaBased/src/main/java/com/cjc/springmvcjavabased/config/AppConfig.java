package com.cjc.springmvcjavabased.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.cjc.springmvcjavabased.model.Employee;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.cjc.springmvccrudapp")
public class AppConfig {
   @Bean
   public InternalResourceViewResolver irvr() {
	   
	   InternalResourceViewResolver irvr=new InternalResourceViewResolver();
	     irvr.setSuffix(".jsp");
	    irvr.setPrefix("/JSP/");
		return irvr;
   }
   @Bean
   public DriverManagerDataSource dmds() {
	   
	   DriverManagerDataSource d=new DriverManagerDataSource();
	   d.setDriverClassName("com.mysql.jdbc.Driver");
	   d.setUrl("jdbc:mysql://localhost:3306/test");
	   d.setUsername("root");
	   d.setPassword("root");
	return d;
   }
   @Bean
   public LocalSessionFactoryBean sf() {
	   LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
	   sf.setDataSource(dmds());
	   Properties p=new Properties();
	   p.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
	   p.setProperty("hibernate.hbm2ddl.auto","update");
	   p.setProperty("hibernate.show_sql","true");
	   sf.setHibernateProperties(p);
	   sf.setAnnotatedClasses(Employee.class);
	   return sf;
   }
}