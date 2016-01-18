package com.nju.edu.cn.software.service;

import java.io.File;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
 
@Produces("image/*")
public class PictureService {

	@GET
	@Path("images/{imageName}")
	public Response getImage(@PathParam("imageName") String imageName){
		File file = new File(imageName);
		if(!file.exists()){
			new WebApplicationException(404);
		}
		String mt = new MimetypesFileTypeMap().getContentType(file);
		return Response.ok(file, mt).build();
		 
	}
}
