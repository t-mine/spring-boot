package com.sample.api.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.base.ResponseDto;
import com.sample.db.entity.User;

import lombok.SneakyThrows;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	HttpSession session;

	@Autowired
	UserService userService;

	/**
	 * ユーザ検索
	 */
	@SneakyThrows
	@RequestMapping(method = RequestMethod.GET)
	public UserResponseDto select(@RequestParam(name = "id", required = false) String id) {

		UserResponseDto responseDto = ResponseDto.createResponseDto(UserResponseDto.class);

		// 全件検索
		if (id == null) {
			List<User> userList = userService.findAll();
			responseDto.setUserList(userList);
			return  responseDto;
		}

		// ID検索
		List<User> userList = new ArrayList<User>();
		userList.add(userService.findById(id));
		responseDto.setUserList(userList);

		return responseDto;
	}

	/**
	 * ユーザ追加
	 */
	@SneakyThrows
	@RequestMapping(method = RequestMethod.POST)
	public UserResponseDto add(
		@RequestParam("id") String id,
		@RequestParam("password") String password,
		@RequestParam("firstName") String firstName,
		@RequestParam("lastName") String lastName
	) {
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);

		userService.add(user);

		return ResponseDto.createResponseDto(UserResponseDto.class);
	}
}
