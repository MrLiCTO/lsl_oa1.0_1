package com.test.shilong;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserTestService {
			@Resource
	         private SessionFactory  sf;
			
			@Transactional
			public void addUser(){
				UserTest u1=new UserTest();
				u1.setName("u3");
				UserTest u2=new UserTest();
				u2.setName("u4");
				sf.getCurrentSession().save(u1);
				int a=1/0;
				sf.getCurrentSession().save(u2);
			}
			
}
