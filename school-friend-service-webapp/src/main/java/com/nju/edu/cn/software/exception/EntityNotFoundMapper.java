package com.nju.edu.cn.software.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.nju.edu.cn.software.resource.StatusInfo;

@Provider
public class EntityNotFoundMapper implements ExceptionMapper<Exception> {
	@Override
	public Response toResponse(Exception e) {
		// TODO Auto-generated method stub
		AppException ex = new AppException();
		StatusInfo statusInfo = new StatusInfo();
		statusInfo.setCode(9999);
		statusInfo.setMessage(e.getMessage());
		ex.setStatusInfo(statusInfo);
		return Response.ok().entity(ex).type(MediaType.APPLICATION_JSON).build();
	}
}
