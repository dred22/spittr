<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Reference</title>
        <link rel="stylesheet"
        type="text/css"
        href="<c:url value="/resources/style.css" />" >
    </head>
    <body>
        <h1><s:message code="reference.welcome" /></h1>
        <a href="<c:url value="/references" />">References</a> |
        <a href="<c:url value="/reference/register" />">Register</a>
    </body>
    <footer>
      <p>The profile is <strong>${profiles[0]}<strong></p>
    </footer>
</html>