package com.ebs.exception;

public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(int userId) {
		super("Could not find the Id " + userId);
	}
}
