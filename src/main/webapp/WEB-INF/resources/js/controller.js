var cartApp = angular.module('cartApp', [])

cartApp.controller('cartController', function ($scope, $http){


    $scope.updateCart = function () {
        $http.get('rest/cart/' + $scope.cartId).success(function (data) {
            $scope.cart = data;
        });
    };

    $scope.addToCart = function (movieId) {
        $http.put('/rest/cart/add/' + movieId).success(function (data) {
            $scope.updateCart();
        });
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.updateCart(cartId);
    };

    $scope.removeFromCart = function (movieId) {
        $http.put('/rest/cart/remove/'+ movieId).success(function (data) {
            $scope.updateCart();
        });
    };

    $scope.calculateGrandTotal = function () {
        var grandTotal = 0;

        for (var i = 0; i < $scope.cart.cartItems.length; i++) {
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    };
});