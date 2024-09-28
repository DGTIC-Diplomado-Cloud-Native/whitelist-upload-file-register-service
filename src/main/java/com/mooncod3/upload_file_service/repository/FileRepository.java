package com.mooncod3.upload_file_service.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;

import com.mooncod3.upload_file_service.domain.File;

public interface FileRepository extends MongoRepository<File, ObjectId>{
    Optional<File> findByUserId(ObjectId userId);

    boolean existsByUserId(ObjectId userId);
}
