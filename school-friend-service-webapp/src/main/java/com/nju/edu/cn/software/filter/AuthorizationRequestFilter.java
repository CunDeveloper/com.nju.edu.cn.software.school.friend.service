package com.nju.edu.cn.software.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
 

@Priority(Priorities.AUTHENTICATION)
@Provider
public class AuthorizationRequestFilter implements ContainerRequestFilter {
 
	@Override
	public void filter(ContainerRequestContext arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
