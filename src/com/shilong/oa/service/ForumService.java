package com.shilong.oa.service;

import com.shilong.oa.base.DaoSupport;
import com.shilong.oa.domain.Forum;
import com.shilong.oa.domain.PageBean;

public interface ForumService extends DaoSupport<Forum> {

	public void moveUp(Long id);

	public void moveDown(Long id);



}
