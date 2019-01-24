<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<jsp:useBean id="now" class="java.util.Date"/>


<div class="container">
    <div class="page-header">
        <h1>Order</h1>
        <p class="lead">Order confirmation</p>
    </div>

    <div class="container">
        <div class="row">
            <form:form commandName="customerOrder" class="form-horizontal">
                <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
                    <div class="text-center">
                        <h1>Receipt</h1>
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <address>
                                <strong>Shipping Address</strong>
                                ${customerOrder.cart.customer.shippingAddress.street}
                                <br>
                                ${customerOrder.cart.customer.shippingAddress.apartmentNumber}
                                <br>
                                ${customerOrder.cart.customer.shippingAddress.city}, ${customerOrder.cart.customer.shippingAddress.state}
                                <br>
                                ${customerOrder.cart.customer.shippingAddress.country}, ${customerOrder.cart.customer.shippingAddress.zipCode}
                            </address>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                            <p>Shipping date: <fmt:formatDate type="date" value="${now}"/></p>

                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <address>
                                <strong>billing Address</strong>
                                    ${customerOrder.cart.customer.billingAddress.street}
                                <br>
                                    ${customerOrder.cart.customer.billingAddress.apartmentNumber}
                                <br>
                                    ${customerOrder.cart.customer.billingAddress.city}, ${customerOrder.cart.customer.billingAddress.state}
                                <br>
                                    ${customerOrder.cart.customer.billingAddress.country}, ${customerOrder.cart.customer.billingAddress.zipCode}
                            </address>
                        </div>
                    </div>
                    <div class="row">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Product</th>
                                    <th></th>
                                    <th class="text-center">Price</th>
                                    <th class="text-center">Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="cartItem" items="${customerOrder.cart.cartItems}">
                                    <tr>
                                        <td class="col-md-9"><em>${cartItem.product.name}</em></td>
                                        <td class="col-md-1" style="text-align: center">${cartItem.quantity}</td>
                                        <td class="col-md-1" style="text-align: center">${cartItem.product.price}</td>
                                        <td class="col-md-1" style="text-align: center">${cartItem.totalPrice}</td>
                                    </tr>
                                </c:forEach>

                            <tr>
                                <td></td>
                                <td></td>
                                <td class="text-right">
                                    <h4><strong>Grand total:</strong></h4>
                                </td>
                                <td class="text-center text-danger">
                                    <h4><strong>${customerOrder.cart.grandTotal}</strong></h4>
                                </td>
                            </tr>

                            </tbody>
                        </table>
                    </div>

                    <input type="hidden" name="_flowExecutionKey"/>

                    <button class="btn btn btn-default" name="_eventId_backToCollectShippingDetail">Back</button>
                    <input type="submit" value="Submit Order" class="btn btn-primary" name="_eventId_orderConfirmed"></input>
                    <button class="btn btn btn-default" name="_eventId_cancel">Cancel</button>
                </div>
            </form:form>
        </div>
    </div>

    <%@include file="/WEB-INF/views/template/footer.jsp" %>
