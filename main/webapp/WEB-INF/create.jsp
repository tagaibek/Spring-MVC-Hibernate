<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>test.jsp</title>
</head>
<body>
Add User
</body>
</html>

<%--@elvariable id="user" type="com.javamaster.model.User"--%>
    <form:form action="/users/add" modelAttribute="user">
        Login : <form:input path="login" />
        <br><br>
        Password : <form:password path="password" />
        <br><br>
        Name : <form:input path="name" />
        <br><br>
        <c:forEach items="${roleList}" var="role">
            ${role.roleName}
            <label>
                <input type="checkbox" name="role[]" value="${role.roleName}"/>
            </label>
        </c:forEach>
        <input type="submit" value="submit"/>
    </form:form>



