<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <div class="page-header">
        <h1>All Products</h1>
        <p class="lead">Only Best goods!</p>
    </div>

    <table class="table table-striped table-hover">
        <thead>
        <tr class="bg-success">
            <th>Photo Thumb</th>
            <th>Product Name</th>
            <th>Category</th>
            <th>Condition</th>
            <th>Price</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td><img src="<c:url value="/images/${product.id}.jpg"/>" alt="image" style="width:100px;"/></td>
                <td>${product.name}</td>
                <td>${product.category}</td>
                <td>${product.condition}</td>
                <td>${product.price}</td>
                <td><a href="<spring:url value="/products/viewProduct/${product.id}"/>">
                    <i class="glyphicon glyphicon-info-sign"/></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
<%@include file="/WEB-INF/views/template/footer.jsp" %>