package com.mooncod3.upload_file_service.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mooncod3.upload_file_service.domain.File;

public interface FileRepository extends MongoRepository<File, String>{
    Optional<File> findByUserId(String userId);

    boolean existsByUserId(String userId);
}
