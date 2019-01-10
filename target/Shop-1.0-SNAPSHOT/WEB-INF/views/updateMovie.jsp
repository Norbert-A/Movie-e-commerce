<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/views/patterns/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>&nbsp;</h2>
            <h2>Update Movie</h2>

            <p class="lead">Make your changes</p>
        </div>

        <form:form method="post" modelAttribute="movie" enctype="multipart/form-data">

            <form:hidden path="movieId" value="${movie.movieId}"/>

        <div class="form-group">
            <label for="title">Title</label>
            <form:input path="movieTitle" id="title" class="form-Control" value="${movie.movieTitle}"/>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="movieDescription" id="description" class="form-Control" value="${movie.movieDescription}"/>
        </div>

        <div class="form-group">
            <label for="trailer">Trailer url ending</label>
            <form:input path="movieTrailerId" id="trailer" class="form-Control" value="${movie.movieTrailerId}"/>
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <form:input path="movieCategory" id="category" class="form-Control" value="${movie.movieCategory}"/>
        </div>


        <div class="form-group">
            <label for="director">Director</label>
            <form:input path="movieDirector" id="director" class="form-Control" value="${movie.movieDirector}"/>
        </div>

        <div class="form-group">
            <label for="stars">Movie Stars</label>
            <form:input path="movieStars" id="stars" class="form-Control" value="${movie.movieStars}"/>
        </div>

        <div class="form-group">
            <label for="duration">Duration (min)</label>
            <form:input path="movieDuration" id="duration" class="form-Control" value="${movie.movieDuration}"/>
        </div>

        <div class="form-group">
            <label for="rating">Rating</label>
            <form:input path="movieRating" id="rating" class="form-Control" value="${movie.movieRating}"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <form:input path="moviePrice" id="price" class="form-Control" value="${movie.moviePrice}"/>
        </div>

        <div class="form-group">
            <label class="control-box" for="Image">Upload Image</label>
            <form:input path="movieImage" id="Image" type="file" class="form:input-medium"/>
        </div>

        <div class="form-group">
            <label for="status">Status:&nbsp;</label>
            <label class="checkbox-inline"><form:radiobutton path="movieStatus" id="status"
                                                             value="active"/>Available&nbsp;</label>
            <label class="checkbox-inline"><form:radiobutton path="movieStatus" id="status"
                                                             value="inactive"/>Unavailable</label>
        </div>

        <input type="submit" value="Submit" class="btn btn-success">
        <a href="<c:url value="/admin/movieInventory" />" class="btn btn-warning">Cancel</a>
        </form:form>


        <%@include file="/WEB-INF/views/patterns/footer.jsp" %>
