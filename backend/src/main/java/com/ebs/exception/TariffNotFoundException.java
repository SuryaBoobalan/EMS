package com.ebs.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


public class TariffNotFoundException extends RuntimeException {
	
	public TariffNotFoundException(int tariffid) {
		super("Could not find the Id " + tariffid);
	}
}
