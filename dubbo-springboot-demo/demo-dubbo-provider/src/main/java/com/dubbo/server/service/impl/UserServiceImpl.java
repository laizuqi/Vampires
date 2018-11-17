package com.dubbo.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.api.UserService;
import com.dubbo.entity.UserDO;

/**
* @类名称：UserServiceImpl
* @类描述：实现用户管理接口
* @作者：Lv Ming
* @日期：2018年6月17日
* @版本：V1.0
*/
@Service(interfaceClass = UserService.class) 
@Component
public class UserServiceImpl implements UserService {
	@SuppressWarnings("serial")
	private List<UserDO> users = new ArrayList<UserDO>(){{
	add(new UserDO(1L, "熊大", "123"));
	add(new UserDO(2L, "熊二", "234"));
	add(new UserDO(3L, "熊三", "456"));
	}};

	/** 
	* <p>覆盖方法：findById</p>
	* <p>描述：通过id查询用户</p>
	* @param id
	* @return
	* @see com.dubbo.api.UserService#findById(java.lang.Long)
	*/ 
	@Override
	public UserDO findById(Long id) {
	return users.stream().filter(user -> user.getId() == id).findFirst().get();
	}

	/** 
	* <p>覆盖方法：listUser</p>
	* <p>描述：查询用户列表</p>
	* @return
	* @see com.dubbo.api.UserService#listUser()
	*/ 
	@Override
	public List<UserDO> listUser() {
	return users;
	}
}
