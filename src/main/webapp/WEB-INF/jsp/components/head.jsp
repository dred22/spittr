<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, shrink-to-fit=no, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Simple Sidebar - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/public/css/bootstrap.min.css" rel="stylesheet">
    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"> -->
    
    <link href="${pageContext.request.contextPath}/public/css/languages.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/public/css/simple-sidebar.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


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
<div class=" navbar-fixed-top ">
   <div class="container">
   <div class="pull-right">   
   		<a href="${requestScope['javax.servlet.forward.request_uri']}?lang=en" class="lang-lg" lang="en"></a>
   		<a href="${requestScope['javax.servlet.forward.request_uri']}?lang=fr" class="lang-lg" lang="fr"></a>
   	</div>
	</div>
</div>
<div id="wrapper">