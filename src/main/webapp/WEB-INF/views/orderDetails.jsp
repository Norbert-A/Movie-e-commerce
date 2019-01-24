<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/views/patterns/header.jsp" %>


<style>
    <%@include file="/WEB-INF/resources/css/registration.css" %>
</style>
<div class="container">
    <div class="d-flex justify-content-center h-100">
        <div class="card">
            <div class="card-header">
                <h3>Order</h3>
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
                            <p>Order Date: ${order.orderDate}</p>
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
                            <c:forEach var="savedItems" items="${order.cart.savedItems}" >
                                <tr>
                                    <td class="col-md-9"><em>${savedItems.movie.movieTitle}</em></td>
                                    <td class="col-md-1" style="text-align: center">${savedItems.quantity}</td>
                                    <td class="col-md-1" style="text-align: center">${savedItems.movie.moviePrice}</td>
                                    <td class="col-md-1" style="text-align: center">${savedItems.totalPrice}</td>
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
                        <a href="<c:url value="/admin/orders" />" class="btn btn-light">Back&nbsp;<i class="fa fa-shopping-cart" aria-hidden="true"></i></a>&nbsp;

                        <a href="<spring:url value="/admin/orders/removeOrder/${order.orderId}/${order.cart.cartId}" />"
                           class="btn btn-danger pull-right"></span>Delete Order&nbsp;<i class="fa fa-trash" aria-hidden="true"></i></a>
                    </p>
                </form:form>
            </div>
        </div>
    </div>
<%@include file="/WEB-INF/views/patterns/footer.jsp" %>