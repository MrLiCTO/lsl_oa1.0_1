package com.shilong.oa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shilong.oa.base.DaoSupportImpl;
import com.shilong.oa.domain.Role;
import com.shilong.oa.service.RoleService;
@Service("roleService")
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService {
	
	
//	@Resource
//	private RoleDao roleDao;
//	@Override
//	public List<Role> findAll() {
//		// TODO Auto-generated method stub
//		return roleDao.findAll();
//	}
//	@Override
//	public void delete(Long id) {
//		// TODO Auto-generated method stub
//		roleDao.delete(id);
//	}
//	@Override
//	public void add(Role role) {
//		// TODO Auto-generated method stub
//		roleDao.save(role);
//	}
//	@Override
//	public Role getById(Long id) {
//		// TODO Auto-generated method stub
//		return roleDao.getById(id);
//	}
//	@Override
//	public void update(Role role) {
//		// TODO Auto-generated method stub
//		roleDao.update(role);
//	}
			
}
