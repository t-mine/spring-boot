package com.sample.api.login;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sample.db.dao.UserDao;
import com.sample.db.entity.User;

@Service
@Transactional
public class LoginService {

  @Autowired
  UserDao userDao;

  public List<User> findAll(){
    return userDao.findAll(new Sort(Sort.Direction.ASC, "id"));
  }

  public HttpStatus login(String id, String inputPw) {

	  User user = userDao.findById(id).get();

	  String dbPw = user.getPassword();

	  if (dbPw.equals(inputPw)) {
		  return HttpStatus.OK;
	  }

	  return HttpStatus.UNAUTHORIZED;
  }
}