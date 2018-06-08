package com.sample.api.login;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class LoginResponseDto {
	HttpStatus status;
	String sessionId;
}
