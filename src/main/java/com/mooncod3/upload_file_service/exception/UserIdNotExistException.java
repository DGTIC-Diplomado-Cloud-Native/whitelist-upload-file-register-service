package com.mooncod3.upload_file_service.exception;

import org.bson.types.ObjectId;

public class UserIdNotExistException extends RuntimeException {
    public UserIdNotExistException(ObjectId userId) {
		super("The user id is not valid: " + userId.toString());
	}
}
