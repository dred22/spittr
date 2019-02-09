<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>List of spitters</h1>
<c:forEach items="${spitterList}" var="spitter" >
    <li id="spitter_<c:out value="spitter.id"/>">
        <div class="spitterMessage">
            <c:out value="${spitter.message}" />
        </div>
        <div>
            <span class="spitterTime"><c:out value="${spitter.ts}" /></span>
            <span class="spitterLocation">
                (<c:out value="${spitter.firstName}" />,
                <c:out value="${spitter.lastName}" />)
            </span>
        </div>
    </li>
</c:forEach>