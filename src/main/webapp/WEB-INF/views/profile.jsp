<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Your Profile</h1>
<div>username : <c:out value="${reference.username}" /></div>
<div>firstName : <c:out value="${reference.firstName}" /></div>
<div>lastName : <c:out value="${reference.lastName}" /></div>