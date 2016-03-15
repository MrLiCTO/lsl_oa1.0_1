package com.shilong.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.shilong.oa.domain.PageBean;
import com.shilong.oa.domain.Reply;
import com.shilong.oa.util.QueryHelper;
@SuppressWarnings("unchecked")
@Transactional
public abstract class DaoSupportImpl<T> implements DaoSupport<T> {

	@Resource
	private SessionFactory sessionFactory;
	
	private Class<T>  clazz=null;
	public DaoSupportImpl(){
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class<T>) type.getActualTypeArguments()[0];
		//System.out.print("clazz is====="+clazz);
	}
	
	
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		this.getSession().save(t);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Object obj=getById(id);
		if(obj!=null){
			this.getSession().delete(obj);
		}
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		this.getSession().update(t);
	}

	@Override
	public T getById(Long id) {
		// TODO Auto-generated method stub
		if(id!=null){
		return (T) this.getSession().get(clazz, id);
		}else{
			return null;
		}
	}


	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return this.getSession()//
				.createQuery("from "+clazz.getSimpleName())//
				.list();
		
	}

	@Override
	public List<T> findByIds(Long[] ids) {
		// TODO Auto-generated method stub
		if(ids==null||ids.length==0){
			return Collections.EMPTY_LIST;
		}else{
		return (List<T>) this.getSession().createQuery("from "+clazz.getSimpleName()+" where id in (:ids)").setParameterList("ids", ids).list();
		}
	}


@Deprecated
	@Override
	public PageBean getPageBean(String hql, List<Object> parameters,
			int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		
		Query listQuery=getSession().createQuery(hql);
		
		
		for(int i=0;i<parameters.size();i++){
			listQuery.setParameter(i, parameters.get(i));
		}
		
		List list=listQuery//
				.setFirstResult((pageNum-1)*pageSize)//
				.setMaxResults(pageSize)//
				.list();
		
		
		Query countQuery=getSession().createQuery("select count(*) "+hql);
				
		
		for(int i=0;i<parameters.size();i++){
			countQuery.setParameter(i, parameters.get(i));
		}
		
		Long count=(Long) countQuery.uniqueResult();
		
		return new PageBean(pageNum,pageSize,count.intValue(),list);
	}
	public PageBean getPageBean(int pageNum, int pageSize, QueryHelper q){
		List<Object> parameters=q.getParameters();
		Query listQuery=getSession().createQuery(q.getListQueryHql());
		
		for(int i=0;i<parameters.size();i++){
			listQuery.setParameter(i, parameters.get(i));
		}
		
		List list=listQuery//
				.setFirstResult((pageNum-1)*pageSize)//
				.setMaxResults(pageSize)//
				.list();
		
		
		Query countQuery=getSession().createQuery(q.getCountQueryHql());
				
		
		for(int i=0;i<parameters.size();i++){
			countQuery.setParameter(i, parameters.get(i));
		}
		
		Long count=(Long) countQuery.uniqueResult();
		
		return new PageBean(pageNum,pageSize,count.intValue(),list);

	}
}
