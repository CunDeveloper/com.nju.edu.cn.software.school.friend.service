package com.nju.edu.cn.software.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.nju.edu.cn.software.dao.impl.UserService;
import com.nju.edu.cn.software.domain.User;
import com.nju.edu.cn.software.entity.Student;
 

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	private static final Logger log = Logger.getLogger(MyResource.class);
	@Autowired
	private UserService dao;
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@Context UriInfo info) {
    	User user = dao.getUser("2");
    	User user1 = new User();
    	user1.setId(3);
    	user1.setName("zhangxiaojun");
    	log.info("get resource from getIt hello world");
    	//dao.saveUser(user1);
        return "Got it!"+info.getPath()+"====="+user.getName();
    }
    
    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(){
    	Student student = new Student();
    	student.setAge(22);
    	student.setId(1);
    	student.setName("cunzhang");
    	return student;
    }
}
