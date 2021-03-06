<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <div class="page-header">
        <h1>All Products</h1>
        <p class="lead">Only Best goods!</p>
    </div>

    <table class="table table-hover" style="cursor: pointer">
        <thead>
        <tr class="bg-success">
            <th>Image</th>
            <th>Product Name</th>
            <th>Category</th>
            <th>Condition</th>
            <th>Price</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr class="clickable-row" data-href="<spring:url value="/product/viewProduct/${product.id}"/>">
                <td><img src="<c:url value="/images/${product.id}.jpg"/>" alt="image" style="width:100px;"/></td>
                <td>${product.name}</td>
                <td>${product.category}</td>
                <td>${product.condition}</td>
                <td>${product.price}</td>
                <td><a href="<spring:url value="/admin/product/deleteProduct/${product.id}"/>">
                        <i class="glyphicon glyphicon-remove"/>
                    </a></td>
                <td><a href="<spring:url value="/admin/product/editProduct/${product.id}"/>">
                    <i class="glyphicon glyphicon-edit"/>
                </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="<c:url value="/admin/product/addProduct"/>">Add Product</a>

    <script>
        jQuery(document).ready(function($) {
            $(".clickable-row").click(function() {
                window.document.location = $(this).data("href");
            });
        });
    </script>

<%@include file="/WEB-INF/views/template/footer.jsp" %>