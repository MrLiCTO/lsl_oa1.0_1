package com.test.shilong;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDataSource {
	private static ApplicationContext ctx=null;
	@Test
	public void loadUser() throws SQLException{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
//		DataSource ds=(DataSource) ctx.getBean("dataSource");
//		System.out.println(ds.getConnection());
		SessionFactory sf=(SessionFactory) ctx.getBean("sessionFactory");
		System.out.println(sf);
	}
	
	
	@Test
	public void addUser() throws SQLException{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserTestService us=(UserTestService) ctx.getBean("userService");
		us.addUser();
	}
}
