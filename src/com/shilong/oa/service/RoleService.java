package com.shilong.oa.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shilong.oa.base.DaoSupport;
import com.shilong.oa.domain.Role;


public interface RoleService extends DaoSupport<Role> {

public 	List<Role> findAll();

public void delete(Long id);

public void save(Role role);

public Role getById(Long id);

public void update(Role role);


}
