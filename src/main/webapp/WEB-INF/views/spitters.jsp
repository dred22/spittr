<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h2>List of spitters</h2>
<c:forEach items="${spitterList}" var="spitter" >
    <li id="spitter_<c:out value="spitter.id"/>">
        <div class="spitterMessage">
            <c:out value="${spitter.username}" />
        </div>
        <div>
            <span class="spitterTime"><c:out value="${spitter.ts}" /></span>
            <span class="spitterLocation">
                (<c:out value="${spitter.firstName}" />,
                <c:out value="${spitter.lastName}" />)
            </span>
            <security:authorize access="hasRole('ROLE_USER')">
              <p>Password is <c:out value="${spitter.password}" /></p>
            </security:authorize>
        </div>
    </li>
</c:forEach>