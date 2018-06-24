package com.sample.api.login;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.db.dao.UserDao;
import com.sample.db.entity.User;
import com.sample.exception.UnauthorizedException;

@Service
@Transactional
public class LoginService {

  @Autowired
  UserDao userDao;

  public void login(String id, String inputPw) throws UnauthorizedException {

	  User user = userDao.findById(id).get();
	  String dbPw = user.getPassword();

	  if (!dbPw.equals(inputPw)) {
		  throw new UnauthorizedException();
	  }
  }
}