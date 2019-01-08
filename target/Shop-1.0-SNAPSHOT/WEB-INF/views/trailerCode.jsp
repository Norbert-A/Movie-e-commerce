<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>
</head>
<body>

<div>

    <div class="content">
        <a href="#videostory" class="button more" id="videolink">
            Trailer <i class="fa fa-play-circle">&nbsp;</i>
        </a>
    </div>

    <div id="videostory" class="mfp-hide" style="max-width: 75%; margin: 0 auto;">

        <iframe width="853" height="480" src="https://www.youtube.com/embed/WDkg3h8PCVU"
                frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                allowfullscreen>
        </iframe>
    </div>

    <script>
        $('#videolink').magnificPopup({})
    </script>

</div>

</body>
</html>
