<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<script src="<c:url value="/resources/js/controller.js" />"></script>


<div class="container">
    <div class="page-header">
        <h1>Product Details</h1>
        <p class="lead">This is some good</p>
    </div>

    <div class="container" ng-app="App">
        <div class="row">
            <div class="col-md-5">
                <img src="<c:url value="/images/${product.id}.jpg"/>" alt="image" style="width: 100%" height="300px">
            </div>
            <div class="col-md-5">
                <h3>${product.name}</h3>
                <p><strong>Category</strong>: ${product.category}</p>
                <p><strong>Manufacturer</strong>: ${product.manufacturer}</p>
                <p><strong>Condition</strong>: ${product.condition}</p>
                <p><strong>Description</strong>: ${product.description}</p>
                <p><strong>Status</strong>: ${product.status}</p>
                <p><strong>Price</strong>: ${product.price}</p>


                <c:set var="role" scope="page" value="${param.role}"/>
                <c:set var="url" scope="page" value="/product/productList"/>
                <c:if test="${role='admin'}">
                    <c:set var="url" scope="page" value="/admin/productInventory"/>
                </c:if>

                <p ng-controller="cartCtrl">
                    <a href="<c:url value="${url}"/>" class="btn btn-default">Back</a>
                    <a href="#" class="btn btn-warning btn-lg" ng-click="addToCart('${product.id}')">
                        <span class="glyphicon glyphicon-shopping-cart"></span>Order Now
                    </a>
                    <a href="<spring:url value="/customer/cart"/>" class="btn btn-default"><span class="glyphicon glyphicon-hand-right">View cart</span></a>

                </p>

            </div>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/views/template/footer.jsp" %>