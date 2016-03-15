package com.shilong.oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shilong.oa.base.BaseAction;
import com.shilong.oa.domain.Forum;
@Controller
@Scope("prototype")
public class ForumManageAction extends BaseAction<Forum> {
	private static final long serialVersionUID = 6756293125374244414L;
	
	
		public String list(){
			List<Forum> forumList=forumService.findAll();
			ActionContext.getContext().put("forumList", forumList);
			return "list";
		}
		
		
		public String addUI(){

			return "saveUI";
		}
		
		public String add(){
			forumService.save(model);
			return "toList";
		}
		
		public String delete(){
			forumService.delete(model.getId());
			return "toList";
		}
		public String editUI(){
			Forum forum=forumService.getById(model.getId());
			ActionContext.getContext().getValueStack().push(forum);
			return "saveUI";
		}
		public String edit(){
			Forum forum=forumService.getById(model.getId());
			forum.setName(model.getName());
			forum.setDescription(model.getDescription());
			forumService.update(forum);
			return "toList";
		}
		
		public String moveUp(){
			forumService.moveUp(model.getId());
			return "toList";
		}
		public String moveDown(){
			forumService.moveDown(model.getId());
			return "toList";
		}
		
}
