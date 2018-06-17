package com.sample.api.logout;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logout")
public class LogoutController {

	@Autowired
	LogoutService logoutService;

	@RequestMapping(method = RequestMethod.DELETE)
	public LogoutResponseDto logout(HttpServletRequest request) {
		// ログアウト処理
		HttpStatus status = logoutService.logout(request);
		// レスポンス
		LogoutResponseDto responseDto = new LogoutResponseDto();
		responseDto.setStatus(status);
		return responseDto;
	}
}
