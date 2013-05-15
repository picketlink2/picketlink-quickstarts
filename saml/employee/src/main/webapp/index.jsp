<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.picketlink.identity.federation.core.saml.v2.util.DocumentUtil" %>
<%@ page import="org.w3c.dom.Document" %>
<div align="center">
<h1>EmployeeDashboard</h1>
<br/>
Welcome to the Employee Tool, <b><%=request.getUserPrincipal().getName()%></b>.
<br/>
<% if (session.getAttribute("org.picketlink.sp.assertion") != null) { %>
<br/>
<b>Here is your SAML Assertion:</b>.
<br/>
<br/>
<%
	request.setAttribute("assertion", DocumentUtil.asString((Document) session.getAttribute("org.picketlink.sp.assertion")));
%>
<c:out value="${assertion}"/>
<br/>
<% } %>
<br/>
Here is your cartoon of the day:
<br/>
<img src="careermap.jpg"/>
<br/>
<a href="?GLO=true">Click to LogOut</a>

</div>
