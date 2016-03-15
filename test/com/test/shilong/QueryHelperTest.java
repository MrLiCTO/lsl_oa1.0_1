package com.test.shilong;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.shilong.oa.domain.Forum;
import com.shilong.oa.domain.Topic;
import com.shilong.oa.util.QueryHelper;

public class QueryHelperTest {
	/**
	 * 0 表示查看全部主题<br>
	 * 1 表示只看精华帖
	 */
	private int viewType = 1;

	/**
	 * 0 表示默认排序(所有置顶帖在前面，并按最后更新时间降序排列)<br>
	 * 1 表示只按最后更新时间排序<br>
	 * 2 表示只按主题发表时间排序<br>
	 * 3 表示只按回复数量排序
	 */
	private int orderBy = 2;

	/**
	 * true 表示升序<br>
	 * false 表示降序
	 */
	private boolean asc = false;
	private Forum forum=new Forum();
	@Test
	public void test() {
	
		//String hql="from Topic t where t.forum=? ";
		List<Object> parameters=new ArrayList<Object>();
		QueryHelper q=new QueryHelper(Topic.class,"t")//
		
			.addCondition("t.forum=?", forum)//
			
			.addCondition((viewType==1),"t.type=?", Topic.TYPE_BEST)//
	
			.addOrderProperty((orderBy==1),"t.updateLastTime", asc)//
	
			.addOrderProperty((orderBy==2),"t.postTime", asc)//
	
			.addOrderProperty((orderBy==3),"t.replyCount", asc)//
	
			.addOrderProperty((orderBy==3),"case t.type when 2 then 2 else 0 end",false)//
			
			.addOrderProperty((orderBy==3),"t.lastUpdateTime", false);
			System.out.println(q.getListQueryHql());
			System.out.println(q.getCountQueryHql());
			System.out.println(q.getParameters());
	
	}

}
