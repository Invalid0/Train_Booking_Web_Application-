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
<h4 class="text-center mt-5">Update TRAIN</h4>

<div class="container border border-dark rounded bg-light rounded mt-4 ">

<form action="trainbookingform" method="post">
  <div class="form-row d-flex justify-content-between mt-2 shadow p-3 mb-5 bg-white rounded">
    <div class="form-group col-md-3">
      <label for="inputEmail4">Train No</label>
      <input type="text" class="form-control" id="inputEmail4" placeholder="Train No" name="trainNo">
    </div>
    <div class="form-group col-md-3">
      <label for="inputPassword4">Train Name</label>
      <input type="text" class="form-control" id="inputPassword4" placeholder="Train Name" name="trianName">
    </div>
  </div>
  
  <div class="form-row d-flex justify-content-between mt-2 shadow p-3 mb-2 bg-white rounded">
    <div class="form-group col-md-3">
      <label for="inputCity">Source</label>
      <input type="text" class="form-control" id="inputCity" placeholder="Source" name="source">
    </div>
    
    <div class="form-group col-md-3">
      <label for="inputZip">Destination</label>
      <input type="text" class="form-control" id="inputZip" placeholder="Destination"  name="destination">
    </div>
  </div>
  </div>
  <div class="d-flex justify-content-end mr-5">
  <div>
    <button type="submit" class=" btn btn-primary mt-5 mr-1" data-toggle="modal" data-target="#myModal"  >Submit</button>
    <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Modal Heading</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          Data Insert Successfully 
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
    </div>
    
    <a href="${pageContext.request.contextPath  }/"class="btn btn-primary mt-5 mr-1">Cancel</a>
  </div>
</form>
</body>

</html>