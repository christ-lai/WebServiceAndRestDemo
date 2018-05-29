package com.celnet;

import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.celnet.webservice.UserWService;
import com.celnet.webservice.webServiceImpl.UserWServiceImpl;



/**
 * @author 杨金国
 * @date 2018年5月28日 
*  @Description: servlet配置 及webService服务发布
 */
@Configuration
public class ServletConfig {
   
	/**
	 * webservice 接口处理
	 * @return
	 */
	@Bean
	public ServletRegistrationBean dispatcherServlet() {
		return new ServletRegistrationBean(new CXFServlet(), "/crmws/*");
	}
     
     /**
      * 添加普通的controller处理(rest接口)
     * @return
     */
	@Bean
	public ServletRegistrationBean dispatcherRestServlet() {
         AnnotationConfigWebApplicationContext context
                 = new AnnotationConfigWebApplicationContext();
         //替换成自己想买的controller包路径
         context.scan("com.celnet.controller");
         DispatcherServlet disp = new DispatcherServlet(context);
         ServletRegistrationBean registrationBean = new ServletRegistrationBean(disp);
         registrationBean.setLoadOnStartup(1);
         //映射路径自定义,必须设置一个不重复的名称
         registrationBean.addUrlMappings("/crmrest/*");
         registrationBean.setName("crmrest");
         return registrationBean;
     }
     
	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}
      
	@Bean
	public UserWService testService() {
		return (UserWService) new UserWServiceImpl();
	}
    /**
     * User相关 webService服务 
     * @return
     */
	@Bean
	public Endpoint endpointUser() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), testService());
		endpoint.publish("/userWService");
		return endpoint;
	}
	
	/**
	 * Student相关 webService服务
	 * @return
	 */
	@Bean
	public Endpoint endpointStudent() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), testService());
		endpoint.publish("/studentWService");
		return endpoint;
	}
	
}