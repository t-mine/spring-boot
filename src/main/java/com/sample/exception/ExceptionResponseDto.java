package com.sample.exception;

import com.sample.base.ResponseDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ExceptionResponseDto extends ResponseDto {
	private String error;
}
