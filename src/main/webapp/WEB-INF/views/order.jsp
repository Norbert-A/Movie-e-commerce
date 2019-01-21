<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="date" class="java.util.Date" />

<%@include file="/WEB-INF/views/patterns/header.jsp" %>


<style>
    <%@include file="/WEB-INF/resources/css/registration.css" %>
</style>
<div class="container">
    <div class="d-flex justify-content-center h-100">
        <div class="card">
            <div class="card-header">
                <h3>Confirm Reciept</h3>
                <div class="d-flex justify-content-end social_icon">
                    <span><i class="fa fa-pencil-square-o"></i></span>
                </div>
            </div>
            <div class="card-body">
                <form:form modelAttribute="order">

                    <div class="text-center">
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <address>
                                <strong>Address</strong><br>
                                    ${order.cart.user.name}
                                <br>
                                    ${order.cart.user.address.address}
                                <br>
                                    ${order.cart.user.address.city}
                                <br>
                                    ${order.cart.user.address.country}
                                <br>
                            </address>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                            <p>Order Date: <fmt:formatDate value="${date}" /></p>
                        </div>
                    </div>

                    <div class="row">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>Movie</th>
                                <th>#</th>
                                <th class="text-center">Price</th>
                                <th class="text-center">Total</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="cartItem" items="${order.cart.cartItems}" >
                                <tr>
                                    <td class="col-md-9"><em>${cartItem.movie.movieTitle}</em></td>
                                    <td class="col-md-1" style="text-align: center">${cartItem.quantity}</td>
                                    <td class="col-md-1" style="text-align: center">${cartItem.movie.moviePrice}</td>
                                    <td class="col-md-1" style="text-align: center">${cartItem.totalPrice}</td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td></td>
                                <td></td>
                                <td class="text-right">
                                    <strong>Grand Total: </strong>
                                </td>
                                <td class="text-center">
                                    <strong><i style="color: yellow" class="fa fa-usd" aria-hidden="true"></i>&nbsp;${order.cart.grandTotal}</strong>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <h2>&nbsp;</h2>
                    <p>
                        <a href="<c:url value="/cart" />" class="btn btn-light">Back to Cart&nbsp;<i class="fa fa-shopping-cart" aria-hidden="true"></i></a>&nbsp;

                        <a href="<spring:url value="/order/confirm/${cartId}" />"
                           class="btn btn-warning pull-right"></span>Confirm&nbsp;<i class="fa fa-check" aria-hidden="true"></i></a>
                    </p>
                </form:form>
            </div>
        </div>
    </div>
<%@include file="/WEB-INF/views/patterns/footer.jsp" %>