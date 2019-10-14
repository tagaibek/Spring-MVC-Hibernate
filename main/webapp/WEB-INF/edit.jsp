<%--@elvariable id="user" type="com.javamaster.model"--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
</head>
<body>
    <form:form method="POST" action="/admin/users/edit" modelAttribute="user">
        <form:hidden path="id" />
        <table>
            <tr>
                <td><form:label path="login">login</form:label></td>
                <td><form:input path="login"/></td>
            </tr>
            <tr>
                <td><form:label path="password">Password</form:label></td>
                <td><form:input path="password"/></td>
            </tr>
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input path="name"/></td>
            </tr>
            <c:forEach items="${roleList}" var="role">
                ${role.roleName}
                <label>
                    <input type="checkbox" name="role[]" value="${role.roleName}"/>
                </label>
            </c:forEach>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
</form:form>
</body>
</html>