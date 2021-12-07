<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login form</title>
</head>
<body>




<c:choose>
    <c:when test="${not empty sessionScope.user}">
        <form method="post" action="login">
            Login ID:<input type="text" name="login"/><br/>
            Password:<input type="text" name="password"/><br/>
            <input type="submit" value="login"/>
        </form>
    </c:when>
    <c:otherwise>
        <span>Hello ${sessionScope.user.name}</span>
    </c:otherwise>
</c:choose>



</body>
</html>
