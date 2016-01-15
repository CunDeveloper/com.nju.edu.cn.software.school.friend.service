package com.nju.edu.cn.software.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.nju.edu.cn.software.domain.User;
 

public interface Usermapper {
	//@Select("SELECT * FROM mytable where id = #{userId}")@Param("userId")
	User getUser( String userId);
}
