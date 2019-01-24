/**
 * Created by eldar on 27/12/16.
 */
var cartApp = angular.module('App',[]);

cartApp.controller('cartCtrl',function ($scope,$http) {

    $scope.refreshCart = function () {
        $http.get('/musicStore/rest/cart/'+ $scope.cartId).then(function (response) {
            $scope.cart=response.data;
        })
    };

    $scope.clearCart = function () {
        $http.delete('/musicStore/rest/cart/' + $scope.cartId).success($scope.refreshCart());
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart();
    };

    $scope.addToCart = function (productId) {
        $http.put('/musicStore/rest/cart/add/'+productId).then(function (response) {
            $scope.refreshCart();
            alert('Product Successfully added to cart')
        })

    };

    $scope.removeFromCart = function (productId) {
        $http.put('/musicStore/rest/cart/remove/'+productId).then(function(response) {
            $scope.refreshCart();
        })
    };

    $scope.calGrandTotal = function () {
        var grandTotal = 0;

        for(var i = 0;i<$scope.cart.cartItems.length;i++){
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    }
});