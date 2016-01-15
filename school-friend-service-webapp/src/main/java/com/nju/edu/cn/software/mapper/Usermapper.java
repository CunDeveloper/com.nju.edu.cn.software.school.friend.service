package com.nju.edu.cn.software.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.nju.edu.cn.software.dao.impl.User;

public interface Usermapper {

	@Select("SELECT * FROM mytable where id = #{userId}")
	User getUser(@Param("userId")String userId);
}
