package com.mooncod3.upload_file_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mooncod3.upload_file_service.domain.File;
import com.mooncod3.upload_file_service.dto.FileDto;
import com.mooncod3.upload_file_service.service.FileService;

@RestController
public class FileController implements FileApi {
    @Autowired
	private FileService fileService;
	
	@Override
	public File saveFile(FileDto request) {
		return fileService.saveFile(
			request.getFile());
	}
}
