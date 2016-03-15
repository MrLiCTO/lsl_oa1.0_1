package com.shilong.oa.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shilong.oa.base.DaoSupportImpl;
import com.shilong.oa.domain.Privilege;
import com.shilong.oa.service.PrivilegeService;
@Service("privillegeService")
@Transactional
public class PrivillegeServiceImpl extends DaoSupportImpl<Privilege> implements
		PrivilegeService {

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public List<Privilege> findTopList() {
		// TODO Auto-generated method stub
		
		return sessionFactory.getCurrentSession().createQuery("from Privilege where parent is null").list();
	}

	@Override
	public Collection<String> findAllUrls() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(//
				"select distinct p.url from Privilege p where p.url is not null")//
				.list();
	}
		
}
