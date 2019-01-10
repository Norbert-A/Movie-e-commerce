<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/views/patterns/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>&nbsp;</h2>
            <h2>Movie List</h2>

            <p class="lead">Watch the Trailers in the Details!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr style="background-color: #0c5460; color: #bee5eb">
                <th></th>
                <th>Title</th>
                <th>Category</th>
                <th>Rating</th>
                <th>Price</th>
                <th>Details</th>
            </tr>
            </thead>
            <c:forEach items="${movies}" var="movie">
                <tr>
                    <td><img src="<c:url value="/resources/images/${movie.movieId}.jpg"/>"
                             alt="image" style="width: 50%"/></td>
                    <td>${movie.movieTitle}</td>
                    <td>${movie.movieCategory}</td>
                    <td>${movie.movieRating}&nbsp;<span style="color: gold"><i class="fa fa-star"></i></span></td>
                    <td>${movie.moviePrice}&nbsp;$</td>
                    <td><a href="<spring:url value="/movieList/movieDetails/${movie.movieId}"/>">
                        <i class="fa fa-info-circle"></i></a></td>
                </tr>
            </c:forEach>

        </table>

<%@include file="/WEB-INF/views/patterns/footer.jsp" %>