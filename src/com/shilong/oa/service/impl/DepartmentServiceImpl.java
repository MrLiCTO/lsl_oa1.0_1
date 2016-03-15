package com.shilong.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shilong.oa.base.DaoSupportImpl;
import com.shilong.oa.domain.Department;
import com.shilong.oa.service.DepartmentService;
@Service("departmentService")
@Transactional
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService {
//	@Resource
//	private DepartmentDao deptDao;
	@Resource
	private SessionFactory sessionFactory;
//	
//	@Override
//	public List<Department> findAll() {
//		// TODO Auto-generated method stub
//		return deptDao.findAll();
//	}
//
//	@Override
//	public void add(Department model) {
//		// TODO Auto-generated method stub
//		deptDao.save(model);
//	}
//
//	@Override
//	public void update(Department dept) {
//		// TODO Auto-generated method stub
//		deptDao.update(dept);
//	}
//
//	@Override
//	public Department getById(Long id) {
//		// TODO Auto-generated method stub
//		return deptDao.getById(id);
//	}
//
//	@Override
//	public void delete(Long id) {
//		// TODO Auto-generated method stub
//		deptDao.delete(id);
//	}
//
	@Override
	public List<Department> findChildren(Long parentId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Department where parent.id=?").setParameter(0, parentId).list();
	}

	@Override
	public List<Department> findTopList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Department where parent is null").list();
	}
//	
	
	
}
