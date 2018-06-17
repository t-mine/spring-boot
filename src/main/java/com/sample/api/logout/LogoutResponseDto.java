package com.sample.api.logout;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class LogoutResponseDto {
	HttpStatus status;
}
