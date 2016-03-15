package com.shilong.oa.view.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shilong.oa.base.BaseAction;
import com.shilong.oa.domain.Forum;
import com.shilong.oa.domain.PageBean;
import com.shilong.oa.domain.Topic;
import com.shilong.oa.util.QueryHelper;
@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {
	private static final long serialVersionUID = 1641816361412169183L;
	/**
	 * 0 表示查看全部主题<br>
	 * 1 表示只看精华帖
	 */
	private int viewType = 0;

	/**
	 * 0 表示默认排序(所有置顶帖在前面，并按最后更新时间降序排列)<br>
	 * 1 表示只按最后更新时间排序<br>
	 * 2 表示只按主题发表时间排序<br>
	 * 3 表示只按回复数量排序
	 */
	private int orderBy = 0;

	/**
	 * true 表示升序<br>
	 * false 表示降序
	 */
	private boolean asc = false;
		
		public String list() throws Exception {
			// TODO Auto-generated method stub
			List<Forum> forumList=forumService.findAll();
			ActionContext.getContext().put("forumList", forumList);
			return "list";
		}
		
		public String show() throws Exception {
			// TODO Auto-generated method stub
			Forum forum=forumService.getById(model.getId());
			ActionContext.getContext().put("forum", forum);
			
			//1.0
//			List<Topic> topicList=topicService.findByForum(forum);
//			ActionContext.getContext().put("topicList", topicList);	
			
			//1.1
//			PageBean pageBean=topicService.getPageBeanByForum(forum,pageNum,pageSize);
//			ActionContext.getContext().getValueStack().push(pageBean);
			
			//2.0
//			String hql="from Topic t where t.forum=? order by (case t.type when 2 then 2 else 0 end) desc,t.lastUpdateTime desc";
//			List<Object> parameters=new ArrayList<Object>();
//			parameters.add(forum);
//			PageBean pageBean=replyService.getPageBean(hql, parameters, pageNum, pageSize);
//			ActionContext.getContext().getValueStack().push(pageBean);
			
			
			//2.1
//		String hql="from Topic t where t.forum=? ";
//			List<Object> parameters=new ArrayList<Object>();
//			if(viewType==1){
//				hql+=" and t.type=?  ";
//				parameters.add(Topic.TYPE_BEST);
//			}
//			
//			if(orderBy==1){
//				if(asc){
//					hql+="  order by t.lastUpdateTime asc  ";
//				}else{
//				hql+="  order by t.lastUpdateTime desc  ";
//				}
//			}else if(orderBy==2){
//				if(asc){
//					hql+="  order by t.postTime asc  ";
//				}else{
//					hql+="  order by t.postTime desc  ";
//				}
//				
//			}else if(orderBy==3){
//			
//					hql+="  order by t.replyCount  "+( asc ? " asc " : " desc ");
//				}else{
//						hql+="  order by (case t.type when 2 then 2 else 0 end) desc,t.lastUpdateTime desc";
//				}	
//			parameters.add(forum);
//			PageBean pageBean=replyService.getPageBean(hql, parameters, pageNum, pageSize);
			new QueryHelper(Topic.class,"t")//
			
			.addCondition("t.forum=?", forum)//
			
			.addCondition((viewType==1),"t.type=?", Topic.TYPE_BEST)//
	
			.addOrderProperty((orderBy==1),"t.updateLastTime", asc)//
	
			.addOrderProperty((orderBy==2),"t.postTime", asc)//
	
			.addOrderProperty((orderBy==3),"t.replyCount", asc)//
	
			.addOrderProperty((orderBy==3),"case t.type when 2 then 2 else 0 end",false)//
			
			.addOrderProperty((orderBy==3),"t.lastUpdateTime", false)//
			.preparePageBean(topicService, pageNum, pageSize);
//			PageBean pageBean=replyService.getPageBean( pageNum, pageSize,q);
//			ActionContext.getContext().getValueStack().push(pageBean);
			
			
			return "show";
		}

		public int getViewType() {
			return viewType;
		}

		public void setViewType(int viewType) {
			this.viewType = viewType;
		}

		public int getOrderBy() {
			return orderBy;
		}

		public void setOrderBy(int orderBy) {
			this.orderBy = orderBy;
		}

		public boolean isAsc() {
			return asc;
		}

		public void setAsc(boolean asc) {
			this.asc = asc;
		}
		
		
}
