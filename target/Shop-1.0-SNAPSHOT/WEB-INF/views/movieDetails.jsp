<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/views/patterns/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>&nbsp;</h2>
            <h2>Movie Details</h2>

            <p class="lead">Here you can read more about the movie</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="#" alt="image" style="width: 100%; height: 77%;"/>
                </div>
                <div class="col-md-5">
                    <h3>${movie.movieTitle}</h3>
                    <p>${movie.movieDescription}</p>
                    <p>
                        <a href="#videoPopup" class="button more" id="video">
                            <strong>Play Trailer</strong> <i class="fa fa-play-circle"></i></a>
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
                    </p>
                    <p><strong>Category:&nbsp;</strong>${movie.movieCategory}</p>
                    <p><strong>Director:&nbsp;</strong>${movie.movieDirector}</p>
                    <p><strong>Stars:&nbsp;</strong>${movie.movieStars}</p>
                    <p><strong>Duration:&nbsp;</strong>${movie.movieDuration}&nbsp;min</p>
                    <p><span><strong>Rating:&nbsp;</strong>${movie.movieRating}&nbsp;<span style="color: gold"><i class="fa fa-star"></i></span></p>
                    <h4>${movie.moviePrice}&nbsp;$</h4>

            </div>

        </div>



<%@include file="/WEB-INF/views/patterns/footer.jsp" %>