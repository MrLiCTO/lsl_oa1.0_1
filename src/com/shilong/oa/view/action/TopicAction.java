package com.shilong.oa.view.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shilong.oa.base.BaseAction;
import com.shilong.oa.domain.Forum;
import com.shilong.oa.domain.PageBean;
import com.shilong.oa.domain.Reply;
import com.shilong.oa.domain.Topic;
import com.shilong.oa.domain.User;
import com.shilong.oa.util.QueryHelper;
@Controller
@Scope("prototype")
public class TopicAction  extends BaseAction<Topic>{
	private static final long serialVersionUID = 4036209627818762484L;
	private Long forumId;
	
	
	
	public String show() throws Exception {
		// TODO Auto-generated method stub
		Topic topic =topicService.getById(model.getId());
		ActionContext.getContext().put("topic", topic);
//		List<Reply> replyList=replyService.findByTopic(topic);
//		ActionContext.getContext().put("replyList", replyList);
		
//		PageBean pageBean=replyService.getPageBeanByTopic(topic,pageNum,pageSize);
//		ActionContext.getContext().getValueStack().push(pageBean);
		
//		String hql="from Reply where topic=? order by postTime asc";
//		List<Object> parameters=new ArrayList<Object>();
//		parameters.add(topic);
//		PageBean pageBean=replyService.getPageBean(hql, parameters, pageNum, pageSize);
//		ActionContext.getContext().getValueStack().push(pageBean);
		new QueryHelper(Reply.class,"r")//
		.addCondition("r.topic=?", topic)//
		.addOrderProperty("r.postTime", true)//
		.preparePageBean(replyService, pageNum, pageSize);
		
//		PageBean pageBean=replyService.getPageBean( pageNum, pageSize,q);
//		ActionContext.getContext().getValueStack().push(pageBean);
		return "show";
	}
	
	public String addUI() throws Exception {
		// TODO Auto-generated method stub
		Forum forum=forumService.getById(forumId);
		ActionContext.getContext().put("forum", forum);
		
		return "addUI";
	}
	
	public String add() throws Exception {
		// TODO Auto-generated method stub
		//Topic model=new Topic();
		
//		model.setTitle(title);
//		model.setContent(content);
		model.setForum(forumService.getById(forumId));
		
		
		model.setAuthor(getCurrentUser());
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		model.setPostTime(new Date());
		
		
		topicService.save(model);
		return "toShow";
	}

	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	
}
