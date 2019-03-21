<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="components/head.jsp"%>

<!-- <div id="wrapper"> -->
	<%@ include file="components/side-bar.jsp"%>


	<!-- Page Content -->
	<div id="page-content-wrapper">
		<div class="container">

			<div class="col-sm-offset-3 col-sm-6">
				<c:choose>
					<c:when test="${logined !='ok'}">
						<div class="panel panel-warning">

							<div class="panel-heading"><spring:message code="authentication"/></div>
							<div class="panel-body">
								<form:form method="post" modelAttribute="user">
									<div class="form-group">
										<label for="username"><spring:message code="authentication.username"/></label>
										<form:input path="userName" class="form-control" />
										<!-- <input id="firstName" name="firstName" class="form-control" type="text" /> -->
									</div>
									<div class="form-group">
										<label for="password"><spring:message code="authentication.password"/></label>
										<form:input class="form-control" path="password" />
									</div>
									<button type="submit" class="btn btn-default"><spring:message code="authentication.login"/></button>
								</form:form>
								
							</div>

						</div>
					</c:when>
					<c:otherwise>
				<div class="alert alert-success text-center" role="alert"><spring:message code="authentication.logined.message"/> </div>
					</c:otherwise>
				</c:choose>

			</div>


		</div>
		<a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle
			Menu</a>
	</div>
	<!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->

<%@ include file="components/script-block.jsp"%>
<%@ include file="components/foot.jsp"%>
