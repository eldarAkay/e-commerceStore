<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <div class="page-header">
        <h1>Register Customer</h1>
        <p class="lead">Please insert the customer details</p>
    </div>

    <form:form action="${pageContext.request.contextPath}/register/customer" method="post"
               modelAttribute="customer">

     <h3>Common Info</h3>

    <div class="form-group">
        <label>Name</label><form:errors path="name" cssStyle="color: red"/>
        <form:input path="name" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Email</label>
        <form:input path="email" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Phone</label>
        <form:input path="phone" class="form-control"/>
    </div>
    <div class="form-group">
        <label>User Name(Login)</label><span style="color:red">${userNameMsg}</span> <form:errors path="userName" cssStyle="color: red"/>
        <form:input path="userName" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Password</label>
        <form:input path="password" class="form-control"/>
    </div>


    <h3>Billing Address</h3>
    <div class="form-group">
        <label>Apartment Number</label>
        <form:input path="billingAddress.apartmentNumber" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Street</label>
        <form:input path="billingAddress.street" class="form-control"/>
    </div>
    <div class="form-group">
        <label>City</label>
        <form:input path="billingAddress.city" class="form-control"/>
    </div>
    <div class="form-group">
        <label>State</label>
        <form:input path="billingAddress.state" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Country</label>
        <form:input path="billingAddress.country" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Zip Code</label>
        <form:input path="billingAddress.zipCode" class="form-control"/>
    </div>



    <h3>Shipping Address</h3>

    <div class="form-group">
        <label>Apartment Number</label>
        <form:input path="shippingAddress.apartmentNumber" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Street</label>
        <form:input path="shippingAddress.street" class="form-control"/>
    </div>
    <div class="form-group">
        <label>City</label>
        <form:input path="shippingAddress.city" class="form-control"/>
    </div>
    <div class="form-group">
        <label>State</label>
        <form:input path="shippingAddress.state" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Country</label>
        <form:input path="shippingAddress.country" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Zip Code</label>
        <form:input path="shippingAddress.zipCode" class="form-control"/>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
    <a class="btn btn-default" href="<c:url value="/"/>">Cancel</a>
    </form:form>


<%@include file="/WEB-INF/views/template/footer.jsp" %>
