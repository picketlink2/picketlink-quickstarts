<html>
<head>
    <title>PicketLink Example Application</title>
</head>
<body>
<p>
    Hi <%= request.getUserPrincipal().getName() %>, you're now authenticated.
</p>

<p>
    This is the default entry page, try to access some of the protected resources:
    <ul>
        <li><a href="<%= request.getContextPath() + "/admin"%>">Admin pages</a></li>
        <li><a href="<%= request.getContextPath() + "/protected"%>">Some protected pages</a></li>
    </ul>
</p>
</body>
</html>