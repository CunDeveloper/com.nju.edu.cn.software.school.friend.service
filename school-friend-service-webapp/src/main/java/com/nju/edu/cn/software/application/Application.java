package com.nju.edu.cn.software.application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public class Application extends ResourceConfig {

	public Application(){
		  register(org.glassfish.jersey.server.filter.UriConnegFilter.class);
		  register(com.nju.edu.cn.software.filter.PoweredByResponseFilter.class);
		  register(com.nju.edu.cn.software.filter.AuthorizationRequestFilter.class);
	      property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true);
	}
}
