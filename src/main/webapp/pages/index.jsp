<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Report Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container-lg">
        <h2 class="pb-3 pt-3">Report Application</h2>

        <!-- Spring Form -->
        <form:form action="/search" modelAttribute="search" method="POST">
            <table class="table">
                <tr>
                    <td>PlanName</td>
                    <td>
                        <form:select path="planName">
                            <form:option value="">-select-</form:option>
                            <form:options items="${names}"/>
                        </form:select>
                    </td>
                    <td>PlanStatus</td>
                    <td>
                        <form:select path="planStatus">
                            <form:option value="">-select-</form:option>
                            <form:options items="${status}"/>
                        </form:select>
                    </td>
                    <td>Gender</td>
                    <td>
                        <form:select path="gender">
                            <form:option value="">-select-</form:option>
                            <form:option value="Male">Male</form:option>
                            <form:option value="Fe- male">Female</form:option>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>Start Date:</td>
                    <td><form:input type="date" path="planStartDate"></form:input></td>
                    <td>End Date:</td>
                    <td><form:input type="date" path="planEndDate"></form:input></td>
                </tr>
            </table>
            <hr />
            <td><a href="/" class="btn btn_secondary">Reset</a></td>
            <td><button type="submit" class="btn btn-primary">Search</button></td>
            <hr />
            <p>Export: <a href="">Excel</a> <a href="">PDF</a></p>
        </form:form>

        <!-- Table -->
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Holder Name</th>
                    <th>Plan Name</th>
                    <th>Plan Status</th>
                     <th>Gender</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                </tr>
            </thead>
            <tbody>
                <!-- Dynamically populate rows based on the search results -->
                <c:forEach var="plan" items="${plans}" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${plan.citezenName}</td>
                        <td>${plan.planName}</td>
                        <td>${plan.planStatus}</td>
                         <td>${plan.gender}</td>
                        <td>${plan.planStartDate}</td>
                        <td>${plan.planEndDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</body>
</html>