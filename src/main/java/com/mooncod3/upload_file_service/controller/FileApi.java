package com.mooncod3.upload_file_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import com.mooncod3.upload_file_service.domain.File;
import com.mooncod3.upload_file_service.dto.FileDto;

@RequestMapping(path="files", produces="application/json")
@CrossOrigin(origins="*")
@Tag(name="file", description="API of File resource")
public interface FileApi {
    @Operation(summary = "File upload and registry")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", 
		description = "File upload an registry sussesfull", 
	    content = { 
	    	@Content(mediaType="application/json", 
	    	schema = @Schema(implementation=File.class)) 
        }),
    })

	@PostMapping(path="upload", consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	File saveFile(
		@NotNull @Valid @RequestBody FileDto request);
}
