<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container">
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Thank you for making your customerOrder!</h1>

                <p>Your customerOrder will be shipped in 3 days</p>
            </div>
        </div>
    </section>

    <section>
        <a href="<spring:url value="/"/>" class="btn btn-default">Ok</a>
    </section>


</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>