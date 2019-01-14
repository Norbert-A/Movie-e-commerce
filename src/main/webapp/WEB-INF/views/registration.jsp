<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row main">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title">RESGISTER</h1>
                <hr />
            </div>
        </div>
        <div class="main-login main-center">
            <form:form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/registration"
            modelAttribute="user">
                <div class="form-group">
                    <label for="name" class="cols-sm-2 control-label">Your Full Name</label>
                    <form:errors path="name" cssStyle="color: #ff0000"/>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
                            <form:input type="text" class="form-control" path="name" id="name"  placeholder="Enter your Full Name" />
                        </div>
                    </div>
                    <label for="email" class="cols-sm-2 control-label">Your Email</label>
                    <span style="color: #ff0000">${emailMsg}</span>
                    <form:errors path="email" cssStyle="color: #ff0000"/>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <form:input type="email" class="form-control" path="email" id="email"  placeholder="Enter your Email"/>
                        </div>
                    </div>
                </div>
                <%--<div class="form-group">--%>
                    <%--<label for="address" class="cols-sm-2 control-label">Address with zip-code</label>--%>
                    <%--<div class="cols-sm-10">--%>
                        <%--<div class="input-group">--%>
                            <%--<span class="input-group-addon"><i class="fa fa-map-marker fa-lg"></i></span>--%>
                            <%--<form:input type="text" class="form-control" path="address" id="address"  placeholder="Enter your Address and zip-code"/>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<label for="address" class="cols-sm-2 control-label"></label>--%>
                    <%--<div class="cols-sm-10">--%>
                        <%--<div class="input-group">--%>
                            <%--<span class="input-group-addon"><i class="fa fa-map-marker fa-lg">City</i></span>--%>
                            <%--<form:input type="city" class="form-control" path="city" id="city"  placeholder="Enter your City"/>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<label for="address" class="cols-sm-2 control-label">Your Country</label>--%>
                    <%--<div class="cols-sm-10">--%>
                        <%--<div class="input-group">--%>
                            <%--<span class="input-group-addon"><i class="fa fa-map-marker fa-lg"></i></span>--%>
                            <%--<form:input type="country" class="form-control" path="country" id="country"  placeholder="Enter your Country"/>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <div class="form-group">
                    <label for="phone" class="cols-sm-2 control-label">Phone Number</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-phone-square fa-lg" aria-hidden="true"></i></span>
                            <form:input type="phone" class="form-control" path="phone" id="phone"  placeholder="Enter your Phone Number"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">Password</label>
                    <form:errors path="password" cssStyle="color: #ff0000"/>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-unlock fa-lg" aria-hidden="true"></i></span>
                            <form:password class="form-control" path="password" id="password"  placeholder="Enter your Password"/>
                        </div>
                    </div>
                </div>
                <div class="form-group ">
                    <button type="submit" value="submit" class="btn btn-primary btn-lg btn-block login-button">Register</button>
                    <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
