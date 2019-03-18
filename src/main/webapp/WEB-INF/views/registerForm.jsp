<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Spittr</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
        <style>
            div.errors {
            background-color: #ffcccc;
            border: 2px solid red;
            }
            label.error {
            color: red;
            }
            input.error {
            background-color: #ffcccc;
            }
        </style>
    </head>
<body>
    <h1>Register</h1>
    <h2>Hello <security:authentication property="principal.username" />!</h2>
    <!-- enctype="multipart/form-data" -->
    <sf:form method="POST" commandName="reference" >
    <sf:errors path="*" element="div" cssClass="errors" />
        <sf:label path="firstName" cssErrorClass="error">First Name</sf:label>: <sf:input path="firstName" /><br/>
        <sf:label path="lastName" cssErrorClass="error">Last Name</sf:label>: <sf:input path="lastName" /><br/>
        <sf:label path="username" cssErrorClass="error">Username</sf:label>: <sf:input path="username" /><br/>
        <sf:label path="password" cssErrorClass="error">Password</sf:label>: <sf:password path="password" /><br/>
        <sf:label path="email" cssErrorClass="error">Email</sf:label>: <sf:input path="email" /><br/>
        <!--File to upload: <input type="file" name="profilePicture"><br />-->
        <input type="submit" value="Register" />
    </sf:form>
</body>
</html>