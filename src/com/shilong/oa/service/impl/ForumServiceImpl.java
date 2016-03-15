package com.shilong.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shilong.oa.base.DaoSupportImpl;
import com.shilong.oa.domain.Forum;
import com.shilong.oa.domain.PageBean;
import com.shilong.oa.service.ForumService;
@Service("forumService")
@Transactional
public class ForumServiceImpl extends DaoSupportImpl<Forum> implements
		ForumService {

	
	
	@Override
	public List<Forum> findAll() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Forum order by position").list();
	}

	@Override
	public void moveUp(Long id) {
		// TODO Auto-generated method stub
		Forum forum=this.getById(id);
		Forum upForum=(Forum) getSession().createQuery(//
				"from Forum where position <? order by position desc")//
				.setParameter(0, forum.getPosition())//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
		if(upForum==null){
			return;
		}
		int position=forum.getPosition();
		forum.setPosition(upForum.getPosition());
		upForum.setPosition(position);
		//以下代码可以不写，因为事物还未提交，对象还在session中；写上也没事
		this.update(forum);
		this.update(forum);
	}

	@Override
	public void moveDown(Long id) {
		// TODO Auto-generated method stub
		Forum forum=this.getById(id);
		Forum downForum=(Forum) getSession().createQuery(//
				"from Forum where position >? order by position asc")//
				.setParameter(0, forum.getPosition())//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
		if(downForum==null){
			return;
		}
		int position=forum.getPosition();
		forum.setPosition(downForum.getPosition());
		downForum.setPosition(position);
		//以下代码可以不写，因为事物还未提交，对象还在session中；写上也没事
		this.update(forum);
		this.update(forum);
	}

	@Override
	public void save(Forum t) {
		// TODO Auto-generated method stub
		super.save(t);
		t.setPosition(t.getId().intValue());
		//不用在写更新，因为事物还未提交，session还未关闭
	}

	
	

}
