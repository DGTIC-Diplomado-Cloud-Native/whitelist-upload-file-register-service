package com.mooncod3.upload_file_service.service;
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

        File savedFile = fileRepository.save(file);
        LOG.info("File upload was successfully registered: {}", savedFile.getUrl());
        return savedFile;
	}

}
