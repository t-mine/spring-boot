package com.sample.base;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.SneakyThrows;

@Data
public class ResponseDto {
	private int status;
	private HttpStatus statusMsg;

	@SneakyThrows
	public static <T extends ResponseDto> T createResponseDto(Class<T> type) {
		T responseDto = type.newInstance();
		responseDto.setStatus(HttpStatus.OK.value());
		responseDto.setStatusMsg(HttpStatus.OK);
		return  responseDto;
	}
}
