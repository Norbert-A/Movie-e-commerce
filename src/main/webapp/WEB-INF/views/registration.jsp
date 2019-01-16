<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/views/patterns/header.jsp" %>

<style>
    <%@include file="/WEB-INF/resources/css/registration.css" %>
</style>
<div class="container">
    <div class="d-flex justify-content-center h-100">
        <div class="card">
            <div class="card-header">
                <h3>Register</h3>
                <div class="d-flex justify-content-end social_icon">
                    <span><i class="fa fa-pencil-square-o"></i></span>
                </div>
            </div>
            <div class="card-body">
                <form:form method="post" action="${pageContext.request.contextPath}/registration"
                           modelAttribute="user">
                    <div class="form-group">
                        <form:errors path="name" cssStyle="color: #ff0000"/>

                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
                            <form:input type="text" class="form-control" path="name" id="name"
                                        placeholder="Full Name"/>
                        </div>

                    </div>
                    <div class="form-group">

                        <span style="color: #ff0000">${emailMsg}</span>
                        <form:errors path="email" cssStyle="color: #ff0000"/>
                        <div class="cols-sm-10">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fa fa-envelope fa"
                                                                  aria-hidden="true"></i></span>
                                <form:input type="email" class="form-control" path="email" id="email"
                                            placeholder="Email"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">

                        <div class="cols-sm-10">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fa fa-map-marker fa-lg"></i></span>
                                <form:input type="text" class="form-control" path="address.address" id="address"
                                            placeholder="Address"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">

                        <div class="cols-sm-10">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fa fa-map-marker fa-lg"></i></span>
                                <form:input type="city" class="form-control" path="address.city" id="city"
                                            placeholder="Zip Code and City"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">

                        <div class="cols-sm-10">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fa fa-map-marker fa-lg"></i></span>
                                <form:input type="country" class="form-control" path="address.country" id="country"
                                            placeholder="Country"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">

                        <div class="cols-sm-10">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fa fa-phone-square fa-lg"
                                                                  aria-hidden="true"></i></span>
                                <form:input type="phone" class="form-control" path="phone" id="phone"
                                            placeholder="Phone Number"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">

                        <form:errors path="password" cssStyle="color: #ff0000"/>
                        <div class="cols-sm-10">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fa fa-unlock fa-lg"
                                                                  aria-hidden="true"></i></span>
                                <form:password class="form-control" path="password" id="password"
                                               placeholder="Password"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group ">
                        <button type="submit" value="submit" class="btn btn-primary btn-lg btn-block login-button">
                            Register
                        </button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
