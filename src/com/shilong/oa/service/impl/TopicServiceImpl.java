package com.shilong.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shilong.oa.base.DaoSupportImpl;
import com.shilong.oa.domain.Forum;
import com.shilong.oa.domain.PageBean;
import com.shilong.oa.domain.Reply;
import com.shilong.oa.domain.Topic;
import com.shilong.oa.service.TopicService;
@Service("topicService")
@Transactional
public class TopicServiceImpl extends DaoSupportImpl<Topic> implements
		TopicService {

	@Override
	public void save(Topic topic) {
		// TODO Auto-generated method stub
		topic.setType(topic.TYPE_NORMAL);
		topic.setLastReply(null);
		topic.setLastUpdateTime(topic.getPostTime());
		topic.setReplyCount(0);
		getSession().save(topic);
		
		Forum forum=topic.getForum();
		forum.setTopicCount(forum.getTopicCount()+1);
		forum.setLastTopic(topic);
		forum.setArticleCount(forum.getArticleCount()+1);
		
		
		getSession().update(forum);
		
	}
@Deprecated
	@Override
	public List<Topic> findByForum(Forum forum) {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"from Topic t where t.forum=? order by (case t.type when 2 then 2 else 0 end) desc,t.lastUpdateTime desc")//
				.setParameter(0, forum)//
				.list();
	}
@Deprecated
	@Override
	public PageBean getPageBeanByForum(Forum forum, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		List<Topic> list=getSession().createQuery(//
				"")//
				.setParameter(0, forum)//
				.setFirstResult((pageNum-1)*pageSize)//
				.setMaxResults(pageSize)//
				.list();
		
		
		Long count=(long) getSession().createQuery(//
				"select count(*) from Topic where forum=?")//
				.setParameter(0, forum)//
				.uniqueResult();
		
		return new PageBean(pageNum,pageSize,count.intValue(),list);
	}

	

}
