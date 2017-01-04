<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <div class="page-header">
        <h1>Customer</h1>
        <p class="lead">Customer Details</p>
    </div>

    <form:form commandName="order" class="form-horizontal">


    <h3>Shipping Address</h3>
    <div class="form-group">
        <label>Apartment Number</label>
        <form:input path="cart.customer.shippingAddress.apartmentNumber" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Street</label>
        <form:input path="cart.customer.shippingAddress.street" class="form-control"/>
    </div>
    <div class="form-group">
        <label>City</label>
        <form:input path="cart.customer.shippingAddress.city" class="form-control"/>
    </div>
    <div class="form-group">
        <label>State</label>
        <form:input path="cart.customer.shippingAddress.state" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Country</label>
        <form:input path="cart.customer.shippingAddress.country" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Zip Code</label>
        <form:input path="cart.customer.shippingAddress.zipCode" class="form-control"/>
    </div>

    <input type="hidden" name="_flowExecutionKey" />

    <button class="btn btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
    <input type="submit" value="Next" class="btn btn-primary" name="_eventId_shippingDetailCollected">Submit</input>
    <button class="btn btn btn-default" name="_eventId_cancel">Cancel</button>
    </form:form>

    <%@include file="/WEB-INF/views/template/footer.jsp" %>
