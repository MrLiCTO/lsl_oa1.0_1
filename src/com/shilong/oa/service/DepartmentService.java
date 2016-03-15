package com.shilong.oa.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shilong.oa.base.DaoSupport;
import com.shilong.oa.domain.Department;

public interface DepartmentService extends DaoSupport<Department>{

	public List<Department> findAll();

	public void save(Department model);

	public void update(Department dept);

	public Department getById(Long id);

	public void delete(Long id);

	public List<Department> findChildren(Long parentId);

	public List<Department> findTopList();
		
}
