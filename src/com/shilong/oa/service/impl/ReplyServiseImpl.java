package com.shilong.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shilong.oa.base.DaoSupportImpl;
import com.shilong.oa.domain.Forum;
import com.shilong.oa.domain.PageBean;
import com.shilong.oa.domain.Reply;
import com.shilong.oa.domain.Topic;
import com.shilong.oa.service.ReplyService;
@SuppressWarnings("unchecked")
@Service("replyServiseService")
@Transactional
public class ReplyServiseImpl extends DaoSupportImpl<Reply> implements
		ReplyService {
	@Deprecated
	@Override
	public List<Reply> findByTopic(Topic topic) {
		return getSession().createQuery(//
				"from Reply where topic=? order by postTime asc")//
				.setParameter(0, topic)//
				.list();
	}

	@Override
	public void save(Reply reply) {
		// TODO Auto-generated method stub
		getSession().save(reply);
		
		Topic topic =reply.getTopic();
		Forum forum=topic.getForum();
		topic.setReplyCount(topic.getReplyCount()+1);
		topic.setLastReply(reply);
		topic.setLastUpdateTime(reply.getPostTime());
		
		

		forum.setArticleCount(forum.getArticleCount()+1);
		
		getSession().update(topic);
		getSession().update(forum);
	}
@Deprecated
	@Override
	public PageBean getPageBeanByTopic(Topic topic, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		
		List<Reply> list=getSession().createQuery(//
				"from Reply where topic=? order by postTime asc")//
				.setParameter(0, topic)//
				.setFirstResult((pageNum-1)*pageSize)//
				.setMaxResults(pageSize)//
				.list();
		
		
		Long count=(long) getSession().createQuery(//
				"select count(*) from Reply where topic=?")//
				.setParameter(0, topic)//
				.uniqueResult();
		
		return new PageBean(pageNum,pageSize,count.intValue(),list);
	}


}
