package com.celnet.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface UserWService {
	
    @WebMethod
    String sayHi(@WebParam(name = "name") String name);

}