package com.sample.api.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	HttpSession session;

	@Autowired
	LoginService loginService;

	@RequestMapping(method = RequestMethod.POST)
	public LoginResponseDto postLogin(@RequestParam("id") String id, @RequestParam("password") String password) {
		// ログイン処理
		HttpStatus status = loginService.login(id, password);
		// レスポンス
		LoginResponseDto responseDto = new LoginResponseDto();
		responseDto.setStatus(status);
		responseDto.setSessionId(session.getId());
		return responseDto;
	}
}
