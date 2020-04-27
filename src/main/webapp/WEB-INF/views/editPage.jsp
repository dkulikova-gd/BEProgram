<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        .error{
            color: red;
        }
        .errorblock{
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
    <title>Edit</title>
</head>
<body>
<c:url value="/edit" var="var"/>
<form action="${var}" method="POST">
    <form:errors path="*" cssClass="errorblock" element="div" />
    <input type="hidden" name="id" value="${dog.id}">
    <label for="name">Name</label>
    <input type="text" name="name" id="name" value = "${dog.name}">
    <label for="dateOfBirth">Date Of Birth</label>
    <input type="text" name="dateOfBirth" id="dateOfBirth" placeholder="yyyy-MM-DD" value = "${dog.dateOfBirth} ">
    <label for="height">Height</label>
    <input type="text" name="height" id="height" value = "${dog.height}">
    <label for="weight">Weight</label>
    <input type="text" name="weight" id="weight" value = "${dog.weight}">
    <input type="submit" value="Edit dog">
</form>
</body>
</html>