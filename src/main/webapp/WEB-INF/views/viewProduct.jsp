<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container">
    <div class="page-header">
        <h1>Product Details</h1>
        <p class="lead">This is some good</p>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-5">
                <img src="<c:url value="/images/${product.id}.jpg"/>" alt="image" style="width: 100%" height="300px">
            </div>
            <div class="col-md-5">
                <h3>${product.name}</h3>
                <p><strong>Category</strong>:   ${product.category}</p>
                <p><strong>Manufacturer</strong>:   ${product.manufacturer}</p>
                <p><strong>Condition</strong>:   ${product.condition}</p>
                <p><strong>Description</strong>:   ${product.description}</p>
                <p><strong>Status</strong>:   ${product.status}</p>
                <p><strong>Price</strong>:  ${product.price}</p>
            </div>
        </div>
    </div>


<%@include file="/WEB-INF/views/template/footer.jsp"%>