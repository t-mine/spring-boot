package com.sample.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sample.exception.UnauthorizedException;

/**
 * 認証機能
 * 参考：https://qiita.com/kazuki43zoo/items/757b557c05f548c6c5db
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);

		if (session == null) {
			throw new UnauthorizedException();
		}

        return true;
    }
}
