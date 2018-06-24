package com.sample.api.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.db.dao.UserDao;
import com.sample.db.entity.User;

@Service
@Transactional
public class UserService {

  @Autowired
  UserDao userDao;

  public HttpStatus login(String id, String inputPw) {
	  User user = userDao.findById(id).get();
	  String dbPw = user.getPassword();
	  return dbPw.equals(inputPw) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
  }

  public void add(User user) {
	userDao.save(user);
  }

  public List<User> findAll() {
	  return userDao.findAll();
  }

  public User findById(String id) {
	  return userDao.findById(id).get();
  }
}