package com.mooncod3.upload_file_service.dto;

import com.mooncod3.upload_file_service.domain.File;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class FileDto {
    @NotNull
	@Valid
	private File file;
}
