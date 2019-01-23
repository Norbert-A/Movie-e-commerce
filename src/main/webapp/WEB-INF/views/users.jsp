<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/views/patterns/header.jsp" %>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>

<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>

<script>$(document).ready(function() {
    $.noConflict();
    $('#table').DataTable( {
        "paging":   false,
        "ordering": false,
        "info":     false
    } );
} );</script>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>&nbsp;</h2>
            <h2>Users</h2>

            <p class="lead">Here you can check user details </p>
        </div>

        <table id="table" class="table table-striped table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Address</th>
                <th><div class="error" style="font-weight:bold; color: #ff0000;">${error}</div></th>
            </tr>
            </thead>
            <c:forEach items="${users}" var="user">
                <c:if test="${user.email != 'admin@admin.com'}">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td>${user.address.address}<br>${user.address.city}<br>${user.address.country}</td>
                    <td>
                        <a href="<spring:url value="/admin/users/deleteUser/${user.userId}"/>">
                            <i class="fa fa-trash"></i></a>
                    </td>
                </tr>
                </c:if>
            </c:forEach>
        </table>

<%@include file="/WEB-INF/views/patterns/footer.jsp" %>