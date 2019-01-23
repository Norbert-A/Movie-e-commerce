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
            <h2>Orders</h2>

            <p class="lead">Here you can check orders</p>
        </div>

        <table id="table" class="table table-striped table-hover">
            <thead>
            <tr>
                <th>Order</th>
                <th>Name</th>
                <th>Order date</th>
                <th>Details</th>
            </tr>
            </thead>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.orderId}</td>
                    <td>${order.user.name}</td>
                    <td>${order.orderDate}</td>
                    <td>
                        <a href="<spring:url value="/admin/orders/details/${order.orderId}"/>">
                            <i class="fa fa-info-circle"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

<%@include file="/WEB-INF/views/patterns/footer.jsp" %>