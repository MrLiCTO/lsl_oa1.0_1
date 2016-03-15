package com.shilong.oa.view.action;

import java.util.HashSet;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shilong.oa.base.BaseAction;
import com.shilong.oa.domain.Department;
import com.shilong.oa.domain.Privilege;
import com.shilong.oa.domain.Role;
import com.shilong.oa.domain.User;
import com.shilong.oa.util.DepartmentUtils;
import com.shilong.oa.util.QueryHelper;
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	private static final long serialVersionUID = 1760239092466102423L;
	
	private Long departmentId;
	private Long[] roleIds;
	
	public String list(){
//	List<User> users=userService.findAll();
//	ActionContext.getContext().put("userList", users);
		new QueryHelper(User.class,"u").preparePageBean(userService, pageNum, pageSize);;
		return "list";
	}
	
	
	public String addUI(){
		List<Department> topList=deptService.findTopList();
		List<Department> deptList=DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", deptList);
		
		List<Role> list=roleService.findAll();
		ActionContext.getContext().put("roleList", list);
		return "saveUI";
	}
	
	public String editUI(){
		List<Department> topList=deptService.findTopList();
		List<Department> deptList=DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", deptList);
		
		List<Role> list=roleService.findAll();
		ActionContext.getContext().put("roleList", list);
		
		User user=userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		
		if(user.getDepartment()!=null){
			departmentId=user.getDepartment().getId();
		}
		roleIds=new Long[user.getRoles().size()];
		if(user.getRoles()!=null){
			int index=0;
			for(Role r:user.getRoles()){
				roleIds[index++]=r.getId();
			}
		}
		return "saveUI";
	}
	
	public String add(){
		model.setDepartment(deptService.getById(departmentId));
		List<Role> roles=roleService.findByIds(roleIds);
		model.setRoles(new HashSet<Role>(roles));
		model.setPassword(DigestUtils.md5Hex("123456"));
		 userService.save(model);
		
		return "toList";
	}
	
	public String delete(){
		userService.delete(model.getId());
		return "toList";
	}
	
	public String edit(){
		User user=userService.getById(model.getId());
		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		user.setGender(model.getGender());
		user.setPhoneNumber(model.getPhoneNumber());
		user.setEmail(model.getEmail());
		user.setDescription(model.getDescription());
		
		user.setDepartment(deptService.getById(departmentId));
		List<Role> roles=roleService.findByIds(roleIds);
		user.setRoles(new HashSet<Role>(roles));
		
		userService.update(user);
		return "toList";
	}
	
	public String initPassword(){
		User user=userService.getById(model.getId());
		user.setPassword(DigestUtils.md5Hex("123456"));
		userService.update(user);
		return "toList";
	}


	public String loginUI(){
	
	
	
		return "loginUI";
	
	}


	public String login(){
		
		User user=userService.findByLoginNameAndPassword(model.getLoginName(),model.getPassword());
		if(user==null){
			addFieldError("login","用户名密码错误！");
			return "loginUI";
		}else{
//			for(Role r:user.getRoles()){
//				String name=r.getName();
//				for(Privilege p:r.getPrivileges()){
//					String pname=p.getName();
//				}
//			}
		ActionContext.getContext().getSession().put("user", user);
		return "index";
	}
	
	
	
}


	public String logout(){
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	
}


public Long getDepartmentId() {
	return departmentId;
}


public void setDepartmentId(Long departmentId) {
	this.departmentId = departmentId;
}


public Long[] getRoleIds() {
	return roleIds;
}


public void setRoleIds(Long[] roleIds) {
	this.roleIds = roleIds;
}

}
