<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!Doctype>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html;charset=ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Show Employees</title>
</head>
<body>
<c:choose>
    <c:when test="${false == employeeResponse.success}">
        <div style="text-align: center">
            <p>
                <span style="color: red">
                    Data is not success. "${employeeResponse.errorMessage}"
                </span>
            </p>
        </div>
    </c:when>
    <c:when test="${null == employeeResponse.employees}">
        <div style="text-align: center">
            <p>
                <span style="color: red">
                    Data is not found. "${employeeResponse.errorMessage}"
                </span>
            </p>
        </div>
    </c:when>
    <c:when test="${empty employeeResponse.employees}">
        <div style="text-align: center">
            <p>
                <span style="color: red">
                    Data is empty. "${employeeResponse.errorMessage}"
                </span>
            </p>
        </div>
    </c:when>
    <c:otherwise>
        <div class="row">
            <div class="container">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th><%="Id"%>
                        </th>
                        <th><%="First Name"%>
                        </th>
                        <th><%="Last Name"%>
                        </th>
                        <th><%="Date of Birth"%>
                        </th>
                        <th><%="Email"%>
                        </th>
                        <th><%="Gender"%>
                        </th>
<%--                        <th><%="Active"%>--%>
<%--                        </th>--%>
                        <th><%="Position Id"%>
                        </th>
                        <th><%="Department Id"%>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${employeeResponse.employees}" var="employee">
                        <tr>
                            <td><c:out value="${employee.id}"/></td>
                            <td><c:out value="${employee.firstName}"/></td>
                            <td><c:out value="${employee.lastName}"/></td>
                            <td><c:out value="${employee.dateOfBirth}"/></td>
                            <td><c:out value="${employee.email}"/></td>
                            <td><c:out value="${employee.gender}"/></td>
<%--                            <td><c:out value="${employee.active}"/></td>--%>
                            <td><c:out value="${employee.positionId}"/></td>
                            <td><c:out value="${employee.departmentId}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>