package com.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.apachecommons.CommonsLog;

@RestControllerAdvice
@CommonsLog
public class ApiExceptionHandler {

	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ExceptionResponseDto handleUnauthorizedException(UnauthorizedException exception) {
		ExceptionResponseDto responseDto = new ExceptionResponseDto();
		responseDto.setStatus(HttpStatus.UNAUTHORIZED.value());
		responseDto.setStatusMsg(HttpStatus.UNAUTHORIZED);
		return responseDto;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponseDto handleException(Exception exception) {
		log.error("ApiExceptionHandler", exception);
		ExceptionResponseDto responseDto = new ExceptionResponseDto();
		responseDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		responseDto.setStatusMsg(HttpStatus.INTERNAL_SERVER_ERROR);
		responseDto.setError(exception.getClass().getName());
		return responseDto;
	}
}
