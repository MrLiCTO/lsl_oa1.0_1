package com.shilong.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.shilong.oa.base.DaoSupportImpl;
import com.shilong.oa.dao.UserDao;
import com.shilong.oa.domain.User;
@Deprecated
@Repository("userDao")
public class UserDaoImpl extends DaoSupportImpl<User> implements UserDao {
		

}
