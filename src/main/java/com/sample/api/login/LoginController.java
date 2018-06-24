package com.sample.api.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.base.ResponseDto;

import lombok.SneakyThrows;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	HttpSession session;

	@Autowired
	LoginService loginService;

	@SneakyThrows
	@RequestMapping(method = RequestMethod.POST)
	public LoginResponseDto login(@RequestParam("id") String id, @RequestParam("password") String password) {

		// ログイン処理
		loginService.login(id, password);

		// レスポンス
		LoginResponseDto responseDto = ResponseDto.createResponseDto(LoginResponseDto.class);
		responseDto.setSessionId(session.getId());

		return responseDto;
	}
}
