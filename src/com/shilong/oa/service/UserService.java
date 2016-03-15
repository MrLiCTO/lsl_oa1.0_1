package com.shilong.oa.service;

import com.shilong.oa.base.DaoSupport;
import com.shilong.oa.domain.User;

public interface UserService extends DaoSupport<User> {

	public User findByLoginNameAndPassword(String loginName, String password);

}
