package com.sample.api.login;

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
	LoginService loginService;

	@RequestMapping(method = RequestMethod.POST)
	public HttpStatus postLogin(@RequestParam("id") String id, @RequestParam("password") String password) {

		return loginService.login(id, password);
	}
}
