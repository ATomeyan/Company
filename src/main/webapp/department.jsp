<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html;charset=ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
    <title>Show Departments</title>
</head>
<body>
<c:choose>
    <c:when test="${false == departmentResponse.success}">
        <div style="text-align: center">
            <p>
                <span style="color: red">
                    Data is not success. "${departmentResponse.errorMessage}"
                </span>
            </p>
        </div>
    </c:when>
    <c:when test="${null == departmentResponse.departments}">
        <div style="text-align: center">
            <p>
                <span style="color: red">
                    Data not found. "${departmentResponse.errorMessage}"
                </span>
            </p>
        </div>
    </c:when>
    <c:when test="${empty departmentResponse.departments}">
        <div style="text-align: center">
            <p>
                <span style="color: red">
                    Data is empty. "${departmentResponse.errorMessage}"
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
                        <th>
                            <%="ID"%>
                        </th>
                        <th>
                            <%="Name"%>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${departmentResponse.departments}" var="department">
                        <tr>
                            <td><c:out value="${department.id}"/></td>
                            <td><c:out value="${department.name}"/></td>
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