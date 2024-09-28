package com.mooncod3.upload_file_service.service;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mooncod3.upload_file_service.domain.File;
import com.mooncod3.upload_file_service.repository.FileRepository;
import com.mooncod3.upload_file_service.exception.UserIdNotExistException;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
	private FileRepository fileRepository;

    private static final Logger LOG = LoggerFactory.getLogger(FileServiceImpl.class);

    @Transactional
    @Override
	public File saveFile(File file) {

		if (file.getUserId() == null) {
            throw new IllegalArgumentException("UserId cannot be null");
        }

        if (!userExists(file.getUserId())) {
            throw new UserIdNotExistException(file.getUserId());
        }

        try {
            File savedFile = fileRepository.save(file);
            LOG.info("File uploaded successfully: {}", savedFile.getUrl());
            return savedFile;
        } catch (Exception e) {
            LOG.error("Error uploading file: {}", file.getUrl(), e);
            throw new RuntimeException("Error upload file ", e);
        }
	}

    private boolean userExists(ObjectId userId) {
        return fileRepository.existsByUserId(userId);
    }

}
