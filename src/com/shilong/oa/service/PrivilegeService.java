package com.shilong.oa.service;

import java.util.Collection;
import java.util.List;

import com.shilong.oa.base.DaoSupport;
import com.shilong.oa.domain.Privilege;

public interface PrivilegeService extends DaoSupport<Privilege> {

	public List<Privilege> findTopList();

	public Collection<String> findAllUrls();

}
