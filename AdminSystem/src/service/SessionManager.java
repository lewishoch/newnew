package service;

import javax.servlet.http.HttpServletRequest;

public interface SessionManager {
	public boolean isSessionValid(HttpServletRequest request);
	public void endSession(HttpServletRequest request);

}
