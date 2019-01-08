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

            <p class="lead">Pick your movies</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr style="background-color: #0c5460; color: #bee5eb">
                <th></th>
                <th>Title</th>
                <th>Trailer</th>
                <th>Category</th>
                <th>Rating</th>
                <th>Price</th>
                <th>Details</th>
            </tr>
            </thead>
            <c:forEach items="${movies}" var="movie">
                <tr>
                    <td><img src="#" alt="image"/></td>
                    <td>${movie.movieTitle}</td>
                    <td>&nbsp;&nbsp;<a href="#videoPopup" class="button more" id="video">
                        <i class="fa fa-play-circle"></i></a>
                        <div id="videoPopup" class="mfp-hide" style="max-width: 75%; margin: 0 auto;">
                            <iframe width="853" height="480"
                                    src="https://www.youtube.com/embed/${movie.movieTrailerId}"
                                    frameborder="0"
                                    allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                                    allowfullscreen>
                            </iframe>
                            <script>
                                $('#video').magnificPopup({})
                            </script>
                        </div>
                    </td>
                    <td>${movie.movieCategory}</td>
                    <td>${movie.movieRating}&nbsp;<span style="color: gold"><i class="fa fa-star fa-border"></i></span></td>
                    <td>${movie.moviePrice}&nbsp;$</td>
                    <td>&nbsp;&nbsp;&nbsp;<a href="<spring:url value="/movieList/movieDetails/${movie.movieId}"/>">
                        <i class="fa fa-info-circle"></i></a></td>
                </tr>
            </c:forEach>

        </table>

<%@include file="/WEB-INF/views/patterns/footer.jsp" %>