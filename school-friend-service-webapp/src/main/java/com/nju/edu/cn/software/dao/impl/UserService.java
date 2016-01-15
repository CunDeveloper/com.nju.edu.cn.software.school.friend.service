package com.nju.edu.cn.software.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.nju.edu.cn.software.domain.User;
import com.nju.edu.cn.software.mapper.Usermapper;
 

@Service
@Scope("prototype")
public class UserService {

	@Autowired
	private Usermapper userMapper;
	public User getUser(String userId){
		return userMapper.getUser(userId);
	}
}
