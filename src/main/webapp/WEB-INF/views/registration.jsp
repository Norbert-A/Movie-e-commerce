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
            <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/registration">
                <div class="form-group">
                    <label for="name" class="cols-sm-2 control-label">Your Full Name</label>
                    <form:errors path="customerName" cssStyle="color: #ff0000"/>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="name" id="name"  placeholder="Enter your Full Name" />
                        </div>
                    </div>
                    <label for="email" class="cols-sm-2 control-label">Your Email</label>
                    <span style="color: #ff0000">${emailMsg}</span>
                    <form:errors path="customerEmail" cssStyle="color: #ff0000"/>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <input type="email" class="form-control" name="email" id="email"  placeholder="Enter your Email"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="address" class="cols-sm-2 control-label">Address with zip-code</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-map-marker fa-lg"></i></span>
                            <input type="address" class="form-control" name="address" id="address"  placeholder="Enter your Address and zip-code"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="address" class="cols-sm-2 control-label"></label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-map-marker fa-lg">City</i></span>
                            <input type="city" class="form-control" name="city" id="city"  placeholder="Enter your City"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="address" class="cols-sm-2 control-label">Your Country</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-map-marker fa-lg"></i></span>
                            <input type="country" class="form-control" name="country" id="country"  placeholder="Enter your Country"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="cols-sm-2 control-label">Phone Number</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-phone-square fa-lg" aria-hidden="true"></i></span>
                            <input type="phone" class="form-control" name="phone" id="phone"  placeholder="Enter your Phone Number"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">Password</label>
                    <form:errors path="customerEmail" cssStyle="color: #ff0000"/>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-unlock fa-lg" aria-hidden="true"></i></span>
                            <input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
                        </div>
                    </div>
                </div>
                <div class="form-group ">
                    <button type="button" class="btn btn-primary btn-lg btn-block login-button" onclick="check()">Register</button>
                    <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
