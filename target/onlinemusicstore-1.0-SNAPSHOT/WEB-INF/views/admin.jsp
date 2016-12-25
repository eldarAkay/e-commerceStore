<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <div class="page-header">
        <h1>Welcome to Admin Page</h1>
        <p class="lead"></p>
    </div>

    <h3><a href="<c:url value="/admin/productsInventory"/>">Product Inventory</a></h3>

<%@include file="/WEB-INF/views/template/footer.jsp" %>