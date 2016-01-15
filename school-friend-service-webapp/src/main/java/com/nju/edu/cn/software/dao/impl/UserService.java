package com.nju.edu.cn.software.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.nju.edu.cn.software.domain.User;
import com.nju.edu.cn.software.mapper.Usermapper;
 

@Service
@Scope("prototype")
public class UserService {

	private static final Logger log = Logger.getLogger(UserService.class);
	
	public UserService(){
		log.info("init UserService class");
	}
	
	@Autowired
	private Usermapper userMapper;
	public User getUser(String userId){
		return userMapper.getUser(userId);
	}
	
	public void saveUser(User user){
		userMapper.saveUser(user);
	}
}
