package com.shilong.oa.view.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shilong.oa.base.BaseAction;
import com.shilong.oa.domain.Reply;
import com.shilong.oa.domain.Topic;
@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply> {
	private static final long serialVersionUID = -3355773190366233915L;
	private Long topicId;
	
	public String addUI() throws Exception {
		// TODO Auto-generated method stub
		Topic topic =topicService.getById(topicId);
		ActionContext.getContext().put("topic", topic);
		return "addUI";
	}
	
	public String add() throws Exception {
		// TODO Auto-generated method stub
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		model.setPostTime(new Date());
		model.setAuthor(this.getCurrentUser());
		
//		model.setTitle(title);
//		model.setContent(content);
		model.setTopic(topicService.getById(topicId));
		replyService.save(model);
		return "toTopicShow";
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	
	
	
}
