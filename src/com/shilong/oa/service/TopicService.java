package com.shilong.oa.service;

import java.util.List;

import com.shilong.oa.base.DaoSupport;
import com.shilong.oa.domain.Forum;
import com.shilong.oa.domain.PageBean;
import com.shilong.oa.domain.Topic;

public interface TopicService extends DaoSupport<Topic> {
	@Deprecated
	public List<Topic> findByForum(Forum forum);
	@Deprecated
	public PageBean getPageBeanByForum(Forum forum, int pageNum, int pageSize); 
}
