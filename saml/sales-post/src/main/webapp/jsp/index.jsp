<head>
	<title>Sales Application</title>	
</head>
<body>
<div align="center">
	<h1> <a href="/sales-post">Sales World </a></h1>
	<%= request.getUserPrincipal() != null ? "<div align='right'> Logged as "+request.getUserPrincipal().getName()+" <a href='?GLO=true'>LogOut</a></div>" : "" %>
	<hr/>

	<ul>
		<li><a href="jsp/sales/sales.jsp">Sales area</a></li>
		<li><a href="jsp/employers/employers.jsp">Employeers area</a></li>
		<li><a href="jsp/managers/managers.jsp">Managers area</a></li>
	</ul>
	
	<br/>
		
	<ul>
		<%= request.isUserInRole( "manager" ) ?  " <li>User has role <strong>manager</strong> </li>" : "" %>
		<%= request.isUserInRole( "employee" ) ? "<li>User has role <strong>employee</strong> </li> " : "" %>
		<%= request.isUserInRole( "sales" ) ? 	 " <li>User has role <strong>sales</strong> </li> " : "" %>
	</ul>

</div>

<style type="text/css"> 
	ul li {
		list-style: none;
	}
</style>

</body>