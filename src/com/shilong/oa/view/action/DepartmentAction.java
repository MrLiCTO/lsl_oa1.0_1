package com.shilong.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shilong.oa.base.BaseAction;
import com.shilong.oa.domain.Department;
import com.shilong.oa.service.DepartmentService;
import com.shilong.oa.util.DepartmentUtils;
@Controller
@Scope("prototype")
public class DepartmentAction  extends BaseAction<Department>{
		/**
	 * 部门管理
	 */
	private static final long serialVersionUID = -1244610693143457043L;
	
		
		
		private Long parentId;
		
		public String list(){
			List<Department> deptList=null;
		    if(parentId!=null){
		    	deptList=deptService.findChildren(parentId);
		    	Department parent=deptService.getById(parentId);
		    	 ActionContext.getContext().put("parent",parent);	
		    }else{
		    	deptList=deptService.findTopList();
		    }
		    ActionContext.getContext().put("departmentList", deptList);		
			return "list";
		}
		
		
		public String addUI(){
			List<Department> topList=deptService.findTopList();
			List<Department> deptList=DepartmentUtils.getAllDepartments(topList);
			ActionContext.getContext().put("departmentList", deptList);
			return "saveUI";
		}
		
		public String editUI(){
			List<Department> topList=deptService.findTopList();
			List<Department> deptList=DepartmentUtils.getAllDepartments(topList);
			ActionContext.getContext().put("departmentList", deptList);
			Department dept =deptService.getById(model.getId());
			ActionContext.getContext().getValueStack().push(dept);
			if(dept.getParent()!=null){
				parentId=dept.getParent().getId();
			}
			return "saveUI";
		}
		
		public String add(){
			Department parent =deptService.getById(parentId);
			model.setParent(parent);
			deptService.save(model);
			return "toList";
		}
		
		public String delete(){
			deptService.delete(model.getId());
			return "toList";
		}
		
		public String edit(){
			Department dept =deptService.getById(model.getId());
			dept.setDescription(model.getDescription());
			dept.setName(model.getName());
			if(model.getId()!=parentId){
				Department parent =deptService.getById(parentId);
				dept.setParent(parent);
			}
			deptService.update(dept);
			return "toList";
		}

		
		
		
		
		
		
		
	

	public Long getParentId() {
			return parentId;
		}


		public void setParentId(Long parentId) {
			this.parentId = parentId;
		}




}
