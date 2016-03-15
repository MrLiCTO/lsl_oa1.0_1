package com.shilong.oa.base;

import java.util.List;

import com.shilong.oa.domain.PageBean;
import com.shilong.oa.domain.Topic;
import com.shilong.oa.util.QueryHelper;

public interface DaoSupport <T>{
		public void save(T t); 
		public void delete(Long id);
		public void update(T t);
		
		
		public T  getById(Long id);
		public List<T>  findAll();
		public List<T>  findByIds(Long[] ids);
		/*
		 * 
		 * 参数列表与hql中的？
		 * 一一对应
		 */
		@Deprecated
		public PageBean getPageBean(String hql,List<Object> parameters, int pageNum, int pageSize); 
		
		public PageBean getPageBean(int pageNum, int pageSize, QueryHelper q); 
}
