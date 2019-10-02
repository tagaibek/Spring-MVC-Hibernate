<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test.jsp</title>
</head>
<body>
Add User
</body>
</html>

<%--@elvariable id="user" type="com.javamaster.model"--%>

    <form:form action="/users/add" modelAttribute="user">
        Login : <form:input path="login" />
        <br><br>
        Password : <form:input path="password" />
        <br><br>
        Name : <form:input path="name" />
        <br><br>
        <input type="submit" value="submit"/>
    </form:form>