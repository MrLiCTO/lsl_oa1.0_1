package com.shilong.oa.service.impl;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shilong.oa.base.DaoSupportImpl;
import com.shilong.oa.domain.User;
import com.shilong.oa.service.UserService;
@Service("userService")
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {

	
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public User findByLoginNameAndPassword(String loginName, String password) {
		// TODO Auto-generated method stub
		String md5Digest=DigestUtils.md5Hex(password);
//		sessionFactory.getCurrentSession().createQuery//
//		
//		("from User u where u.loginName=? and u.password=?")//
//		.setParameter(0, loginName)//
//		.setParameter(1, md5Digest)//
//		.uniqueResult();
		//System.out.println("+++++++++++++++"+loginName+"+++++++++++++++"+md5Digest+"=================================");
		
		
		return 	(User) sessionFactory.getCurrentSession().createQuery//
									("from User u where u.loginName=? and u.password=?")//
										.setParameter(0, loginName)//
										.setParameter(1, md5Digest)//
										.uniqueResult();
		
	}

}
