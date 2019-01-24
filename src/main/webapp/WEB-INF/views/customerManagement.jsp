<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <div class="page-header">
        <h1>Customer Management</h1>
        <p class="lead">View Customer info</p>
    </div>

    <table class="table table-hover" style="cursor: pointer">
        <thead>
        <tr class="bg-success">
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Username</th>
            <th>Enabled</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerList}" var="customer">
            <tr class="clickable-row" data-href="<spring:url value="/product/viewProduct/${customer.id}"/>">
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.phone}</td>
                <td>${customer.userName}</td>
                <td>${customer.enabled}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <script>
        jQuery(document).ready(function($) {
            $(".clickable-row").click(function() {
                window.document.location = $(this).data("href");
            });
        });
    </script>

<%@include file="/WEB-INF/views/template/footer.jsp" %>