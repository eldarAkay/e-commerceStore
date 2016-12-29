<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container">
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Your Shopping cart</h1>
            </div>
        </div>
    </section>
    <section class="container" ng-app="App">
        <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">

            <div>
                <a class="btn btn-danger pull-left" ng-click="clearCart()"><span
                        class="glyphicon glyphicon-remove-sign"></span>Clean Cart</a>
            </div>

            <table class="table table-hover">
                <tr>
                    <td>Product</td>
                    <td>Unit Price</td>
                    <td>Quantity</td>
                    <td>Price</td>
                    <td>Action</td>
                </tr>
                <tr ng-repeat="item in cart.cartItems">
                    <td>{{item.product.name}}</td>
                    <td>{{item.product.price}}</td>
                    <td>{{item.quantity}}</td>
                    <td>{{item.totalPrice}}</td>
                    <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.id)">
                        <span class="glyphicon glyphicon-remove"></span>Remove</a></td>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th>grand total</th>
                    <th>{{cart.grandTotal}}</th>
                    <th></th>
                </tr>
            </table>

            <a href="<spring:url value="/products"/>" class="btn btn-default">Continue Shopping</a>

        </div>
    </section>
</div>

<script src="<c:url value="/resources/js/controller.js" />"></script>
<%@include file="/WEB-INF/views/template/footer.jsp" %>