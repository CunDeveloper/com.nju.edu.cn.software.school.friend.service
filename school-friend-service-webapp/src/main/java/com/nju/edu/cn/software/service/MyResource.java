package com.nju.edu.cn.software.service;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.nju.edu.cn.software.dao.impl.UserService;
import com.nju.edu.cn.software.domain.Author;
import com.nju.edu.cn.software.domain.User;
 
import com.nju.edu.cn.software.exception.EntityNotFoundMapper;
import com.nju.edu.cn.software.mapper.AuthorMapper;
import com.nju.edu.cn.software.mapper.BlogMapper;
import com.nju.edu.cn.software.mapper.TestMapper;
import com.nju.edu.cn.software.resource.RespAuthor;
import com.nju.edu.cn.software.resource.StatusInfo;
 

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	private static final Logger log = Logger.getLogger(MyResource.class);
	@Autowired
	private UserService dao;
	@Autowired
	private TestMapper mapper;
	@Autowired
	private BlogMapper blogMapper;
	@Autowired
	private AuthorMapper authorMapper;
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
    	Response response;
    	 try{
    		 User user =dao.getUser("22a");
    		 user.getName();
    		StatusInfo info = new StatusInfo();
    		info.setCode(200);
    		info.setMessage("OK");
    		RespAuthor rAuthor = new RespAuthor();
    		Author author = authorMapper.getAuthor().get(0);
    		rAuthor.setAuthor(author);
    		rAuthor.setStatusInfo(info);
         	response =Response.status(200).entity(rAuthor).build();
            
    	 }catch(Exception e){
    		response = new EntityNotFoundMapper().toResponse(e);
    	 }
    	 return response;
    }
    
    @POST
    @Path("saveUser")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String saveUser(@Valid User user){
    	log.info(user.getName());
    	dao.saveUser(user);
    	return "ok";
    }
    
   
}
