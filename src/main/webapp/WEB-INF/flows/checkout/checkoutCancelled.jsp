<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container">
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1 class="alert alert-danger">Check out cancelled!</h1>

                <p>Your checkout cancelled</p>
            </div>
        </div>
    </section>

    <section>
        <a href="<spring:url value="/product/productList"/>" class="btn btn-default">Products</a>
    </section>


</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>