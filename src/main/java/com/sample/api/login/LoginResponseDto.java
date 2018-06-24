package com.sample.api.login;

import com.sample.base.ResponseDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class LoginResponseDto extends ResponseDto {
	String sessionId;
}
