package com.nju.edu.cn.software.exception;

 
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class CustomNotFoundException extends WebApplicationException {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	  * Create a HTTP 404 (Not Found) exception.
	  */
	  public CustomNotFoundException() {
	    super(Response.noContent().build());
	  }
	 
	   
}
