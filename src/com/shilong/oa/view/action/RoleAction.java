package com.shilong.oa.view.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shilong.oa.base.BaseAction;
import com.shilong.oa.domain.Privilege;
import com.shilong.oa.domain.Role;
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{

	/**
	 * 岗位管理
	 */
	private static final long serialVersionUID = -34460467921348311L;
	
	
	private Long[] privilegeIds;
	

	public String list(){
		List<Role> list=roleService.findAll();
		ActionContext.getContext().put("roleList", list);
		return "list";
	}
	
	
	public String addUI(){
		return "saveUI";
	}
	
	public String editUI(){
		Role role=roleService.getById(model.getId());
//		this.name=role.getName();
//		this.description=role.getDescription();
		ActionContext.getContext().getValueStack().push(role);
		//model=roleService.getById(model.getId());
		return "saveUI";
	}
	
	public String add(){
		roleService.save(model);
		return "toList";
	}
	
	public String delete(){
		roleService.delete(model.getId());
		return "toList";
	}
	
	public String edit(){
		Role role=roleService.getById(model.getId());
		role.setDescription(model.getDescription());
		role.setName(model.getName());
		roleService.update(role);
		return "toList";
	}
	
	
	public String setPrivilegeUI(){
		Role role=roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		
		if(role.getPrivileges()!=null){
			privilegeIds=new Long[role.getPrivileges().size()];
			int index=0;
			for(Privilege p:role.getPrivileges()){
				privilegeIds[index++]=p.getId();
			}
			
		}
		
		List<Privilege> privs=privilegeService.findAll();
		ActionContext.getContext().put("privilegeList", privs);
		
		return "setPrivilegeUI";
	}
	
	
	public String setPrivilege(){
		Role role=roleService.getById(model.getId());
		
		List<Privilege> privilegeList=privilegeService.findByIds(privilegeIds);
		
		role.setPrivileges(new HashSet(privilegeList));
		
		roleService.update(role);
		return "toList";
	}


	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}


	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}


	

	



	
	
	
	
}
