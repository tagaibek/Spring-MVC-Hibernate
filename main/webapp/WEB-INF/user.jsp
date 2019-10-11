<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h3> User Information </h3>
<c:if test="${!empty loadUser}">
    <table>
        <tr>
            <td> <a>, Name: </a><c:out value="${loadUser.login}"/></td>
            <td> <a>, Name: </a><c:out value="${loadUser.password}"/></td>
            <td><a>, SecondName : </a><c:out value="${loadUser.password}"/></td>
            <td><a>, SecondName : </a><c:out value="${loadUser.role}"/></td>
        </tr>
    </table>
</c:if>
