<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>MovieLandia</title>


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>

    <!--Bootsrap 4 CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">

</head>
<body>
<style>
    .nav-link:hover {
        font-weight: bold;
    }
    .navbar {
        background: rgba(0,0,0,0.5);
    }
    <%@include file="/WEB-INF/resources/css/background.css" %>
</style>

    <div class="navbar-wrapper">
        <nav class="navbar navbar-expand-md navbar-dark sticky-top">
            <div class="navbar-brand" style="text-shadow:3px 3px 2px black"><i style="color:yellow" class="fa fa-film"></i>&nbsp;&nbsp;<strong>MovieLandia</strong></div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" style="text-shadow:3px 3px 2px black, 0 0 40px yellow, 0 0 10px darkblue;" href="/">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" style="text-shadow:3px 3px 2px black, 0 0 40px yellow, 0 0 10px darkblue;" href="<c:url value="/movieList"/>">Movies</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav pull-right">
                    <li class="nav-item">
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <c:if test="${pageContext.request.userPrincipal.name  == 'admin@admin.com'}">
                    <li><a class="nav-link" style="color: orange; text-shadow:3px 3px 2px black, 0 0 40px yellow, 0 0 10px darkblue;" href="<c:url value="/admin" />">Admin</a></li>
                    </c:if>
                    <li><a class="nav-link" style="color: yellow; text-shadow:3px 3px 2px black, 0 0 40px yellow, 0 0 10px darkblue;" href="<c:url value="/logout" />">Logout</a></li>
                    </c:if>
                    </li>
                    <li  class="nav-item">
                        <c:if test="${pageContext.request.userPrincipal.name  == null}">
                    <li><a class="nav-link" style="color: yellow; text-shadow:3px 3px 2px black, 0 0 40px yellow, 0 0 10px darkblue;" href="<c:url value="/login" />">Login</a></li>
                    <li><a class="nav-link" style="color: orange; text-shadow:3px 3px 2px black, 0 0 40px yellow, 0 0 10px darkblue;" href="<c:url value="/registration" />">Register</a></li>
                    </c:if>
                    </li>
                </ul>
            </div>
        </nav>
    </div>


