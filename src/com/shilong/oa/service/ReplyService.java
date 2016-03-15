package com.shilong.oa.service;

import java.util.List;

import com.shilong.oa.base.DaoSupport;
import com.shilong.oa.domain.PageBean;
import com.shilong.oa.domain.Reply;
import com.shilong.oa.domain.Topic;
import com.shilong.oa.util.QueryHelper;

public interface ReplyService  extends DaoSupport<Reply>{

	public List<Reply> findByTopic(Topic topic);
	@Deprecated
	public PageBean getPageBeanByTopic(Topic topic, int pageNum, int pageSize);
	

	
		
}
