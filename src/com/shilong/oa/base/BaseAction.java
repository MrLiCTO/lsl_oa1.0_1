package com.shilong.oa.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shilong.oa.domain.User;
import com.shilong.oa.service.DepartmentService;
import com.shilong.oa.service.ForumService;
import com.shilong.oa.service.PrivilegeService;
import com.shilong.oa.service.ReplyService;
import com.shilong.oa.service.RoleService;
import com.shilong.oa.service.TopicService;
import com.shilong.oa.service.UserService;

public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T> {
	private static final long serialVersionUID = -6432399937664483382L;
	
	@Resource
	protected DepartmentService deptService;
	@Resource
	protected RoleService roleService;
	
	@Resource
	protected UserService userService;
	
	
	@Resource
	protected PrivilegeService privilegeService;
	
	
	@Resource
	protected ForumService forumService;
	
	
	@Resource
	protected TopicService topicService;
	
	
	@Resource
	protected ReplyService replyService;
	protected int pageSize=10;
	protected int pageNum=1;
	
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public T model;
	protected BaseAction(){
		try {
			ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
			Class clazz=(Class) type.getActualTypeArguments()[0];
			model=(T) clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected User getCurrentUser(){
		return (User) ActionContext.getContext().getSession().get("user");
	}
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
