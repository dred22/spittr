<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="components/head.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

	<%@ include file="components/side-bar.jsp"%>


	<!-- Page Content -->
	
	<div id="page-content-wrapper">
		<div class="container">
		
		
					<c:choose>
					<c:when test="${deleted != 'ok'}">	
			<table class="table table-hover">
				<thead>
					<tr>
						<th><spring:message code="show-all.reference.table.firstName"/></th>
						<th><spring:message code="show-all.reference.table.lastName"/></th>
						<th><spring:message code="show-all.reference.table.username"/></th>
						<th><spring:message code="show-all.reference.table.password"/></th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${referenceList}" var="entity">
					<tr>
						<td>${entity.firstName }</td>
						<td>${entity.lastName }</td>
						<td>${entity.username }</td>
						<td>
              <security:authorize access="hasRole('ROLE_USER')">
                ${entity.password }
              </security:authorize>
             </td>

						<td><a href="${pageContext.request.contextPath}/delete?id=${entity.id}" class="btn btn-danger" role="button"><spring:message code="show-all.reference.table.action.delete"/></a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
				</c:when>
					<c:otherwise>
					<div class="alert alert-success text-center" role="alert"><spring:message code="show-all.reference.message.delete.ok"/></div>
					</c:otherwise>
				</c:choose>		
			
		</div><a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>
	</div>
	<!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->

<%@ include file="components/script-block.jsp"%>
<%@ include file="components/foot.jsp"%>
