<head>
	<title>Sales Application</title>	
</head>
<body>
<div align="center">
	<h1> <a href="/sales-post">Sales World </a></h1>
	<%= request.getUserPrincipal() != null ? "<div align='right'> Logged as "+request.getUserPrincipal().getName()+" <a href='?GLO=true'>LogOut</a></div>" : "" %>
	<hr/>

	<ul>
		<li>Sales area: <a href="jsp/sales/sales.jsp">here</a></li>
		<li>Employeers area: <a href="jsp/employers/employers.jsp">here</a></li>
		<li>Managers area: <a href="jsp/managers/managers.jsp">here</a></li>
	</ul>
	
</div>
</body>