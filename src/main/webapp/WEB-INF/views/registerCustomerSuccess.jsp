<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container">
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Customer is registered successfully</h1>
            </div>
        </div>
    </section>

    <section>


        <a href="<spring:url value="/product/productList"/>" class="btn btn-default">Continue Shopping</a>
    </section>


</div>

<script src="<c:url value="/resources/js/controller.js" />"></script>
<%@include file="/WEB-INF/views/template/footer.jsp" %>