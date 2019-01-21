<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/views/patterns/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="container" style="background: rgba(0,0,0,0.5)">
            <div class="page-header">
                <h2>&nbsp;</h2>
                <h2>Movie Details</h2>

                <p class="lead">Here you can read more about the movie</p>
            </div>

            <div class="container" ng-app="cartApp">
                <div ng-controller="cartController">
                    <div class="row">
                        <div class="col-md-5">
                            <img src="<c:url value="/resources/images/${movie.movieId}.jpg"/>"
                                 alt="image" style="width: 70%"/>
                        </div>
                        <div class="col-md-5">
                            <h3>${movie.movieTitle}</h3>
                            <p>${movie.movieDescription}</p>
                            <p>
                                <a href="#videoPopup" class="button more" id="video">
                                    <strong style="color: yellow">Play Trailer</strong> <i style="color:orange;"
                                                                                           class="fa fa-play-circle"></i></a>
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
                            <p><span><strong>Rating:&nbsp;</strong>

                        <span class="imdbRatingPlugin" data-user="ur26317997" data-title="${movie.movieRating}"
                              data-style="p2"><a
                                href="https://www.imdb.com/title/${movie.movieRating}/?ref_=plg_rt_1"><img
                                src="https://ia.media-imdb.com/images/G/01/imdb/plugins/rating/images/imdb_31x14.png"
                                alt=" Aquaman(2018) on IMDb"/></a></span>
                        <script>(function (d, s, id) {
                            var js, stags = d.getElementsByTagName(s)[0];
                            if (d.getElementById(id)) {
                                return;
                            }
                            js = d.createElement(s);
                            js.id = id;
                            js.src = "https://ia.media-imdb.com/images/G/01/imdb/plugins/rating/js/rating.js";
                            stags.parentNode.insertBefore(js, stags);
                        })(document, "script", "imdb-rating-api");</script>
                        </span>
                            </p>
                            <h4>${movie.moviePrice}&nbsp;<strong>$</strong></h4

                            <p>
                                <a href="<c:url value="/movieList" />" class="btn btn-light">Back</a>&nbsp;
                                <a href="#" class="btn btn-warning"
                                   ng-click="addToCart(${movie.movieId})">Add to <i class="fa fa-shopping-cart" aria-hidden="true"></i></a>&nbsp;
                                <a href="<spring:url value="/cart" />"
                                   class="btn btn-primary"><span class="glyphicon glyphicon-hand-right"></span>View <i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.32/angular.min.js"></script>
        <script src="<c:url value="/resources/js/controller.js" /> "></script>

        <%@include file="/WEB-INF/views/patterns/footer.jsp" %>

