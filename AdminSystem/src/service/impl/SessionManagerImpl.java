package service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import service.SessionManager;

public class SessionManagerImpl implements SessionManager {

	public boolean isSessionValid(HttpServletRequest request) {
		HttpSession sen = request.getSession(false);
		boolean isLogin = false;
		if (sen != null && sen.getAttribute("isLogin") != null )
			isLogin = (boolean)sen.getAttribute("isLogin");
		if(sen == null || !request.isRequestedSessionIdValid() || isLogin == false)
			return false;
		else
			return true;
	}

	@Override
	public void endSession(HttpServletRequest request) {
		if(request.getSession() != null)
			request.getSession().invalidate();
	}

}
