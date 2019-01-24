<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <div class="page-header">
        <h1>Edit Product</h1>
        <p class="lead">Here you may make your updates</p>
    </div>

    <form:form action="${pageContext.request.contextPath}/admin/product/editProduct/" method="post"
               modelAttribute="product" enctype="multipart/form-data">
    <form:hidden path="id" value="${product.id}"/>

    <div class="form-group">
        <label>Name</label>
        <form:input path="name" class="form-control" value="${product.name}"/>
        <form:errors path="name" cssStyle="color:red"/>

    </div>
    <div class="form-group">
        <label>Category</label>
        <label class="checkbox-inline">
            <form:radiobutton path="category" class="form-control" value="instrument" />Instrument</label>
        <label class="checkbox-inline">
            <form:radiobutton path="category" class="form-control" value="record"/>Record</label>
        <label class="checkbox-inline">
            <form:radiobutton path="category" class="form-control" value="accecory"/>Accessory</label>
    </div>
    <div class="form-group">
        <label>Description</label>
        <form:input path="description" class="form-control" value="${product.description}"/>
    </div>
    <div class="form-group">
        <label>Price</label>
        <form:input path="price" class="form-control" value="${product.price}"/>
        <form:errors path="price" cssStyle="color:red"/>

    </div>
    <div class="form-group">
        <label>Condition</label>
        <label class="checkbox-inline"><form:radiobutton path="condition" class="form-control"
                                                         value="used" id="condition"/>Used</label>
        <label class="checkbox-inline"><form:radiobutton path="condition" class="form-control"
                                                         value="new" id="condition"/>New</label>
    </div>
    <div class="form-group">
        <label>Status</label>
        <label class="checkbox-inline"><form:radiobutton path="status" class="form-control"
                                                         value="inactive"/>Inactive</label>
        <label class="checkbox-inline"><form:radiobutton path="status" class="form-control"
                                                         value="active"/>Active</label>
    </div>
    <div class="form-group">
        <label>UnitsInStock</label>
        <form:input path="unitsInStock" class="form-control" value="${product.unitsInStock}"/>
        <form:errors path="unitsInStock" cssStyle="color:red"/>

    </div>
    <div class="form-group">
        <label>Manufacturer</label>
        <form:input path="manufacturer" class="form-control" value="${product.manufacturer}"/>
    </div>
    <div class="form-group">
        <label>Product Image</label>
        <form:input path="image" class="form:input" type="file"/>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <a class="btn btn-default" href="<c:url value="/admin/productsInventory"/>">Cancel</a>

</form:form>


<%@include file="/WEB-INF/views/template/footer.jsp" %>