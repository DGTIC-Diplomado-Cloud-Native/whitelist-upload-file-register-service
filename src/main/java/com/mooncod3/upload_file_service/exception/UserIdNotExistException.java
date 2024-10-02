package com.mooncod3.upload_file_service.exception;

public class UserIdNotExistException extends RuntimeException {
    public UserIdNotExistException(String userId) {
		super("The user id is not valid: " + userId);
	}
}
