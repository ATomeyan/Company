<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html;charset=ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Show Attendance Records</title>
</head>
<body>
<c:choose>
    <c:when test="${false == attendanceRecordResponse.success}">
        <div style="text-align: center">
            <p>
                <span style="color: red">
                    Data is not success. "${attendanceRecordResponse.errorMessage}"
                </span>
            </p>
        </div>
    </c:when>
    <c:when test="${null == attendanceRecordResponse.attendanceRecords}">
        <div style="text-align: center">
            <p>
                <span style="color: red">
                    Data not found. "${attendanceRecordResponse.errorMessage}"
                </span>
            </p>
        </div>
    </c:when>
    <c:when test="${empty attendanceRecordResponse.attendanceRecords}">
        <div style="text-align: center">
            <p>
                <span style="color: red">
                    Data is empty. "${attendanceRecordResponse.errorMessage}"
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
                        <th>ID</th>
                        <th>Entrance Time</th>
                        <th>Exit Time</th>
                        <th>Employee Id</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="attendanceRecord" items="${attendanceRecordResponse.attendanceRecords}">
                        <tr>
                            <td>
                                <c:out value="${attendanceRecord.id}"/>
                            </td>
                            <td>
                                <c:out value="${attendanceRecord.entranceTime}"/>
                            </td>
                            <td>
                                <c:out value="${attendanceRecord.exitTime}"/>
                            </td>
                            <td>
                                <c:out value="${attendanceRecord.employeeId}"/>
                            </td>
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