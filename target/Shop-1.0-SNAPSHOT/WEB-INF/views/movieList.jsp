<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Movie List</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">


    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
</head>
<body>
<div class="navbar-wrapper">
    <nav class="navbar navbar-expand-sm navbar-dark sticky-top bg-dark">
        <a class="navbar-brand" href="#">Movielandia</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="true" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="/"/>">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/movieList"/>">Movies</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
            </ul>
            <form class="form-inline mt-2 mt-md-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>



<a href="#play" onclick="trailerPopup('WDkg3h8PCVU')">Trailer</a>

<script>
    function trailerPopup(id) {
        window.open('https://www.youtube.com/embed/'+id, 'popup', config='height=315,width=560')
    }
</script>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2></h2>

            <p class="lead">Let's get rollin'!!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr style="background-color: #0c5460">
                <th>Picture</th>
                <th>Title</th>
                <th>Category</th>
                <th>Rating</th>
                <th>Price</th>
            </tr>
            </thead>
            <c:forEach items="${movies}" var="movie">
                <tr>
                    <td>---</td>
                    <td>${movie.movieTitle}</td>
                    <td>${movie.movieCategory}</td>
                    <td>${movie.movieRating}</td>
                    <td>${movie.moviePrice} $</td>
                </tr>
            </c:forEach>

        </table>


        <!-- FOOTER -->
        <footer class="container">
            <p class="float-right"><a href="#">Back to top</a></p>
            <p>&copy; 2017-2018 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
        </footer>

    </div>

</div><!-- /.container -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>""><\/script>')</script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>