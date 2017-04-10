<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>
  
</head>
<style>
body {
    background-color:#DAA520;
}

h1 {
    color: white;
    text-align: center;
}

p {
    font-family: verdana;
    font-size: 20px;
}
</style>
</head>
<body>

<h2> <center> Shopping Cart  </center></h2>
 <center> ${msg}</center>
 
  <center> ${role}</center>
 
  <center> ${successMessage}</center>
  
  <center> ${errorMessage}</center>
  
  
 ${loginMessage}
<hr>



<c:if test="${isAdmin==true }">
<jsp:include page="Admin/AdminHome.jsp"></jsp:include>

<jsp:include page="Admin/Category.jsp"></jsp:include>
<jsp:include page="Admin/Product.jsp"></jsp:include>
<jsp:include page="Admin/Supplier.jsp"></jsp:include>

</c:if>




<c:if test="${not empty loginMessage}">
<a href="logout">Logout</a> <br>


</c:if>

<c:if test="${isAdmin==false }">
<a href="Mycart"> My Carts</a>

</c:if>
<c:if test="${empty loginMessage}">

</c:if>
 <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">MY SHOPPING</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"  style="background:none border:none; ">
     <li> <a href="#">Home</a></li>
      <li><a href="Mycart">PRODUCTS</a></li>
      <li><a href="AboutUs">ABOUT US</a></li>
       <li><a href="#">CONTACT US</a></li>
         <li><a href="Login">LOGIN</a></li>
         <li><a href="Registration">REGISTER</a></li>
    </li>
 </nav>
 
      
    
<!--  <li><c:if test="${not empty loginMessage}"> 
<a href="logout">Logout </a>
<a href="register"> Register</a>
</c:if></li>-->






<br>
<br>
<br>
<br>
<c:if test="${isUserClickedLogin==true}">
	<jsp:include page="Login.jsp"></jsp:include>  
</c:if>

<c:if test="${not empty errorMessage}">
	<jsp:include page="Login.jsp"></jsp:include>  
</c:if>


<c:if test="${isUserClickedHome==true}">
	<jsp:include page="index.jsp"></jsp:include>  
</c:if>

<c:if test="${isUserClickedR==true}">
<jsp:include page="Registration.jsp"></jsp:include> 
</c:if>
<c:if test="${isUserClickedMycart==true}"><jsp:include page="Mycart.jsp"></jsp:include>   </c:if>



<c:if test="${isUserClickedRegistration==true}"><jsp:include page="Registration.jsp"></jsp:include></c:if>






<jsp:include page="menu/courosel.jsp"></jsp:include>
</body>
</html>








