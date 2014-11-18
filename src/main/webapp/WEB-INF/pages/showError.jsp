<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page isErrorPage="true" %>

<html>
    <head>
	   <link rel="stylesheet" type="text/css" href="<s:url value="/resources/css/main.css" /> ">
	</head>
	<body>
	    <jsp:include page="banner.jsp" />
	    <h2>There has been an error :( Go home: 	        <a href="<s:url value="/welcome" />">Main</a>
	    </h2>
	    
	    
	    Exception is: <%= exception %>  
	</body>
</html>
