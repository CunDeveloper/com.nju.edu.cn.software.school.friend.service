package com.nju.edu.cn.software.mapper;

import com.nju.edu.cn.software.domain.User;
 

public interface Usermapper {
	//@Select("SELECT * FROM mytable where id = #{userId}")@Param("userId")
	User getUser( String userId);
	void saveUser(User user);
}
