package com.celnet.webservice.webServiceImpl;

import javax.jws.WebService;
import com.celnet.webservice.UserWService;

@WebService(targetNamespace="http://webservice.celnet.com/",
endpointInterface = "com.celnet.webservice.UserWService")
public class UserWServiceImpl implements UserWService{

	public String sayHi(String name) {
		return "hello," + name;
	}

}