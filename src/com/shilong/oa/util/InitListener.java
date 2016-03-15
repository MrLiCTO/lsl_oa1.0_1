package com.shilong.oa.util;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.shilong.oa.domain.Privilege;
import com.shilong.oa.service.PrivilegeService;

public class InitListener implements ServletContextListener {
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
		PrivilegeService privilegeService=(PrivilegeService) ctx.getBean("privillegeService");
		List<Privilege> pris=privilegeService.findTopList();
		//System.out.print("+++++++++++++++"+pris+"===================");
		arg0.getServletContext().setAttribute("topPrivilegeList", pris);
		Collection<String> allPrivUrls=privilegeService.findAllUrls();
		//System.out.print("+++++++++++++++"+pris+"===================");
		arg0.getServletContext().setAttribute("allPrivUrls", allPrivUrls);
	}

}
