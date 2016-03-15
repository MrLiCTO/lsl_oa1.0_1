package com.shilong.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.shilong.oa.base.DaoSupportImpl;
import com.shilong.oa.dao.DepartmentDao;
import com.shilong.oa.domain.Department;
@Deprecated
@Repository("departmentDao")
public class DepartmentDaoImpl extends DaoSupportImpl<Department> implements
		DepartmentDao {

}
