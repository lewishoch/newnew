<%@page import="service.impl.SessionManagerImpl"%>
<%@page import="service.SessionManager"%>
<%@ page import="java.util.List" %>


<%
	SessionManager sm = new SessionManagerImpl();
	
	if(!sm.isSessionValid(request)){
		System.out.println("session");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
%>