
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ include file="./bootstrap.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container  mt-5 mb-3" >
<h3 class="text-center ">${Train_Search}</h3>
<form action="search">
  <div class="row border-left-0">
  
    <div class="col ">
      <input type="text" name="bookingId" class="form-control" placeholder="Train Name " >
    </div>
    
  </div>
  <table class="table">
  <thead>
    <tr>
      <th scope="col">Train Name</th>
      <th scope="col">Source</th>
      <th scope="col">Destination</th>
      
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${trainsName}" var="train">
  <tr>
  <td>${trainsName[0]}</td>
  <td>${trainsName[1]}</td>
  <td>${trainsName[2]}</td>
  </tr>
  </c:forEach>
    
  </tbody>
</table>
  
  <button type="submit" class="btn btn-primary mt-5 " name="inputSearch" >Search</button>
</form>


<table class="table">
  <thead>
    <tr>
      <th scope="col">Train Name</th>
      <th scope="col">Train ID</th>
      <th scope="col">Train No</th>
      <th scope="col">Source</th>
      <th scope="col">Destination</th>
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${getTrain}" var="train">
    <tr class="overflow-auto">
      <td scope="row">${train.trianName}</td>
      <td id="trainId">${train.trainId}</td>
      <td>${train.trainNo}</td>
      <td>${train.source}</td>
      <td>${train.destination}</td>
       <td><a href="update/${train.trainId}"><button type="button">Update</button></a></td>
      <td><a href="delete/${train.trainId}"><button type="button">Remove</button></a></td>
     
    </tr>
    </c:forEach>
    
  </tbody>
</table>

<script type="text/javascript">

</script>

<a href="${pageContext.request.contextPath  }/trainBookingPage">
<button type="button" class="btn btn-primary float-right px-md-5">Add Train</button> </a>
<a href="${pageContext.request.contextPath  }/journeyBookingPage">
<button type="button" class="btn btn-primary float-right mr-5">Add Journey</button> </a>	
</div>

</body>
</html>