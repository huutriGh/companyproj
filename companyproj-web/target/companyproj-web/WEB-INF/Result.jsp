<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyen huu tri
  Date: 07/03/2023
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Employee Id: ${employee.employeeId}
<br>
- Name: ${employee.employeeName}
<br>
In company
<br>
<c:forEach items="${employee.companies}" var="comp">
    - ${comp.companyName}
    <br>
</c:forEach>
</body>
</html>
