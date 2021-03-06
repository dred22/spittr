<!-- Sidebar -->
<div id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<li class="sidebar-brand"><a href="${pageContext.request.contextPath}/"> CRUD </a></li>
		<li><a href="${pageContext.request.contextPath}/reference/register"><spring:message code="side-bar.create"/></a></li>
		<li><a href="${pageContext.request.contextPath}/references"><spring:message code="side-bar.show_all"/></a></li>
    <security:authorize access="isAuthenticated()" var="isAuthenticated" />
        <c:choose>
           <c:when test="${isAuthenticated}">
              <li><a href="${pageContext.request.contextPath}/logout"><spring:message code="authentication.logout"/></a></li>
           </c:when>
           <c:otherwise>
              <li><a href="${pageContext.request.contextPath}/login"><spring:message code="authentication.login"/></a></li>
           </c:otherwise>
        </c:choose>
		<!-- 		<li><a href="#">Events</a></li>
		<li><a href="#">About</a></li>
		<li><a href="#">Services</a></li>
		<li><a href="#">Contact</a></li> -->
		
	</ul>
</div>
<!-- /#sidebar-wrapper -->