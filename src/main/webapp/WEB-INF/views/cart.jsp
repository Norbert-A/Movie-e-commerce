<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/views/patterns/header.jsp" %>


<div class="container-wrapper">
    <div class="container" ng-app="cartApp">
        <div ng-controller="cartController" ng-init="initCartId('${cartId}')">

            <div class="page-header">
                <h2>&nbsp;</h2>
                <h2>Cart</h2>

                <p class="lead">Movies you have added to your cart!</p>
            </div>


            <a href="<spring:url value="/movieList" />" class="btn btn-primary">Add More</a>

            <a href="<spring:url value="/order/${cartId}"/>" class="btn btn-success pull-right">Check out</a>

            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th></th>
                    <th>Movie</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total Price</th>
                    <th></th>
                </tr>
                </thead>
                <tr ng-repeat="item in cart.cartItems">
                    <td><img src="<c:url value="/resources/images/{{item.movie.movieId}}.jpg"/>"
                             alt="image" style="width: 50%"/></td>
                    <td>{{item.movie.movieTitle}}</td>
                    <td>{{item.movie.moviePrice}}</td>
                    <td>{{item.quantity}}</td>
                    <td>{{item.totalPrice}}</td>
                    <td>
                        <a href="#" ng-click="removeFromCart(item.movie.movieId)"> <i class="fa fa-trash"></i></a>
                        &nbsp;
                        <a href="#" ng-click="addToCart(item.movie.movieId)"><i class="fa fa-plus" aria-hidden="true"></i></a>
                    </td>

                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th>Grand Total</th>
                    <th><i style="color: yellow" class="fa fa-usd" aria-hidden="true"></i>&nbsp;{{calculateGrandTotal()}}</th>
                    <th></th>
                </tr>
            </table>

        </div>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.32/angular.min.js"></script>
    <script src="<c:url value="/resources/js/controller.js" /> "></script>

<%@include file="/WEB-INF/views/patterns/footer.jsp" %>