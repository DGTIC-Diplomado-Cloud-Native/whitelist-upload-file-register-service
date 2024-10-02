package com.mooncod3.upload_file_service.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@NoArgsConstructor
@Document(collection = "files")
@Schema(description = "Representa un archivo almacenado en el sistema")
public class File {

    @Id
    @Schema(description = "Identificador único del archivo", example = "60f1a5b2c0e1a23d68d65a7e")
    private String id;

    @NotBlank(message = "Url is required")
    @Size(max = 255, message = "URL must not exceed 255 characters")
    @Schema(description = "URL donde se puede acceder al archivo", 
            example = "https://storage.googleapis.com/my-bucket/document.pdf",
            requiredMode = Schema.RequiredMode.REQUIRED,
            maxLength = 255)
    private String url;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    @Schema(description = "Nombre del archivo, incluyendo su extensión", 
            example = "document.pdf",
            requiredMode = Schema.RequiredMode.REQUIRED,
            maxLength = 100)
    private String name;

    @NotBlank(message = "Format is required")
    @Size(max = 10, message = "Format must not exceed 10 characters")
    @Schema(description = "Formato o extensión del archivo", 
            example = "pdf",
            requiredMode = Schema.RequiredMode.REQUIRED,
            maxLength = 10)
    private String format;

    @NotBlank(message = "Located service is required")
    @Size(max = 50, message = "Located service must not exceed 50 characters")
    @Schema(description = "Nombre del servicio donde está almacenado el archivo", 
            example = "Google Cloud Storage",
            requiredMode = Schema.RequiredMode.REQUIRED,
            maxLength = 50)
    private String locatedService;

    @Indexed(unique = true)
    @NotBlank(message = "User id is required")
    @Schema(description = "Identificador único del usuario propietario del archivo", 
            example = "user123",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String userId;
}