package com.nju.edu.cn.software.helper;

public interface Constant {

	int UNAUTHORIZED_CODE = 401;
	String UNAUTHORIZED_MEG = "You do not have the appropriate privileges to access this resource";
	
	int INTERNAL_SYSTEM_ERROR_CODE = 500;
	String INTERNAL_SYSTEM_ERROR_MSG = "Internal System error";
	
	int CREDENTIALS_INCORRECT = 401;
	String CREDENTIALS_INCORRECT_MSG = "Client Credentials were incorrect";
	
	int NOT_AUTHORIZED_CODE = 403;
	String NOT_AUTHORIZED_MSG = "Not authorized";
	
}
