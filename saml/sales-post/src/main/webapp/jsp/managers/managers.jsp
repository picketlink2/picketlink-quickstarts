<div align="center">
<h1> <a href="/sales-post">Sales World </a></h1>
	<%= request.getUserPrincipal() != null ? "<div align='right'> Logged as "+request.getUserPrincipal().getName()+" <a href='?GLO=true'>LogOut</a></div>" : "" %>
	<hr/>
<br/> 

<br/>

You can see this page because the user <%=request.getUserPrincipal().getName()%> has the role manager. 

<br/>

</div>
