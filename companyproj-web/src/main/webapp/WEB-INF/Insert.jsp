<%--
  Created by IntelliJ IDEA.
  User: nguyen huu tri
  Date: 06/03/2023
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert</title>
</head>
<body>
<h2>Insert employee</h2>
<form action="employee" method="POST">
    <p>
        <input name="empId" type="text" placeholder="Employee Id">
    </p>
    <p>
        <input name="empName" type="text" placeholder="Employee Name">
    </p>
    <fieldset>
        <legend>Company exist in DB</legend>
        <p>

            <input name="comId" type="text" placeholder="Company Id"/>
        </p>
    </fieldset>
    <fieldset>
        <legend>Company not exist in DB</legend>
        <p>

            <input name="comIdNew" type="text" placeholder="Company Id"/>
            <input name="compName" type="text" placeholder="Company Name"/>
        </p>
    </fieldset>
    <p>
        <input type="submit" value="ADD" name="action">
    </p>

</form>
</body>
</html>
