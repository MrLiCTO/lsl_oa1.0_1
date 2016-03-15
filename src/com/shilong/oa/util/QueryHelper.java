package com.shilong.oa.util;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.shilong.oa.base.DaoSupport;
import com.shilong.oa.domain.PageBean;

public class QueryHelper {
			private String fromClause;
			private String whereClause="";
			private String orderByClause="";
			private List<Object> parameters=new ArrayList<Object>();
			public QueryHelper(Class clazz,String alias){
				fromClause=" from "+clazz.getSimpleName()+" "+alias;
			}
			
			public  QueryHelper addCondition(String condition ,Object...  params){
				if(whereClause.length()==0){
					whereClause=" where "+condition;
				}else{
					whereClause+=" and "+condition;
				}
				if(params!=null){
					for(Object p:params){
						parameters.add(p);
					}
				}
				return this;
			}
			public QueryHelper addCondition(boolean append,String condition ,Object...  params){
				if(append){
					this.addCondition(condition, params);
				}
				return this;
			}
			public QueryHelper addOrderProperty(String propertyName,boolean asc){
				if(orderByClause.length()==0){
					orderByClause=" order by "+propertyName+" "+(asc ? "asc" : "desc");
				}else{
					orderByClause+=" , "+propertyName+(asc ? " asc " : " desc ");
				}
				return this;
			}
			public  QueryHelper addOrderProperty(boolean append,String propertyName,boolean asc){
				if(append){
					this.addOrderProperty(propertyName, asc);
				}
				return this;
			}
			public List<Object> getParameters() {
				return parameters;
			}
			public String getListQueryHql(){
				return fromClause+whereClause+orderByClause;
			}
			public String getCountQueryHql(){
				return"select count(*) "+ fromClause+whereClause;
			}
			
			public void preparePageBean(DaoSupport<?> service,int pageNum, int pageSize){
				PageBean pageBean=service.getPageBean( pageNum, pageSize,this);
				ActionContext.getContext().getValueStack().push(pageBean);
			}
}
