<%@ page import="java.util.List" %>
<%@ page import="ui.common.SessionLogin" %>

<%
	HttpSession sen = request.getSession(false);
	
	if(!SessionLogin.sessionLogin(sen)){
		System.out.println("session");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
%>