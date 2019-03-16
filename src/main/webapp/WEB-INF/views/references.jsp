<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h2>List of references</h2>
<c:forEach items="${referenceList}" var="reference" >
    <li id="reference_<c:out value="reference.id"/>">
        <div class="referenceMessage">
            <c:out value="${reference.username}" />
        </div>
        <div>
            <span class="referenceTime"><c:out value="${reference.ts}" /></span>
            <span class="referenceLocation">
                (<c:out value="${reference.firstName}" />,
                <c:out value="${reference.lastName}" />)
            </span>
            <security:authorize access="hasRole('ROLE_USER')">
              <p>Password is <c:out value="${reference.password}" /></p>
            </security:authorize>
        </div>
    </li>
</c:forEach>