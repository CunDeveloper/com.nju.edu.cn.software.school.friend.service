package com.nju.edu.cn.software.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSouce(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public void save(){
		System.out.println("save ok");
	}
	
	public void doExecute(){
		this.jdbcTemplate.execute("create table mytable (id integer, name varchar(100))");
	}
}
