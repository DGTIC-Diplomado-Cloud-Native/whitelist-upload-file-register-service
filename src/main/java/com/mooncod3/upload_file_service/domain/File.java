package com.mooncod3.upload_file_service.domain;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Anotación de Lombok que genera automáticamente getters, setters, toString(), equals(), y hashCode() para todos los campos.
@NoArgsConstructor // Anotación de Lombok que genera un constructor sin argumentos.
@Document(collection = "files") // Esta anotación de Spring Data MongoDB indica que esta clase representa un documento en la colección "files" de MongoDB.
public class File {
    @Id
    private ObjectId id;

    @NotBlank(message = "Url is required")
    @Size(max = 255, message = "URL must not exceed 255 characters")
    private String url;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must not   exceed 100 characters")
    private String name;

    @NotBlank(message = "Format is required")
    @Size(max = 10, message = "Format must not exceed 10 characters")
    private String format;

    @NotBlank(message = "Located service is required")
    @Size(max = 50, message = "Located service must not exceed 50 characters")
    private String locatedService;

    @Indexed(unique = true)
    @NotBlank(message = "User id is required")
    private ObjectId userId;

}
