package com.sample.api.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LogoutService {
  public HttpStatus logout(HttpServletRequest request) {
	  HttpSession session = request.getSession(false);
	  if (session == null) {
		  return HttpStatus.UNAUTHORIZED;
	  }
	  session.invalidate();
	  return HttpStatus.OK;
  }
}