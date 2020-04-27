<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>DOGS</title>
</head>
<body>

<h2>Dogs</h2>
<table>
    <tr>
        <th>name</th>
        <th>dateOfBirth</th>
        <th>height</th>
        <th>weight</th>
        <th>action</th>
    </tr>
    <c:forEach var="dog" items="${dogsList}">
        <tr>
            <td>${dog.name}</td>
            <td>${dog.dateOfBirth}</td>
            <td>${dog.height}</td>
            <td>${dog.weight}</td>
            <td>
                <a href="/edit/${dog.id}">edit</a>
                <a href="/delete/${dog.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url var="add" value="/add"/>
<a href="${add}">Add new dog</a>
</body>
</html>