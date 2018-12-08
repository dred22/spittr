<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Your Profile</h1>
<div>username : <c:out value="${spitter.username}" /></div>
<div>firstName : <c:out value="${spitter.firstName}" /></div>
<div>lastName : <c:out value="${spitter.lastName}" /></div>