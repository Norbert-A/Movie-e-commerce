<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/views/patterns/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>&nbsp;</h2>
            <h2>Administration</h2>

            <p class="lead">Welcome Admin!</p>
        </div>

        <h4><a href="<c:url value="/admin/movieInventory"/>"class="btn btn-primary">Movie Inventory</a></h4>


        <%@include file="/WEB-INF/views/patterns/footer.jsp" %>
