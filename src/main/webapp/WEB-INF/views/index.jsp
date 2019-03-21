<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ include file="components/head.jsp" %>

<!--     <div id="wrapper"> -->
		<%@ include file="components/side-bar.jsp" %>


        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1>My CRUD web site</h1>
                        <p>profile is ${profiles[0]}</p>
                        <p><spring:message code="reference.welcome"/></p>
                        <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->

<%@ include file="components/script-block.jsp" %>
<%@ include file="components/foot.jsp" %>
