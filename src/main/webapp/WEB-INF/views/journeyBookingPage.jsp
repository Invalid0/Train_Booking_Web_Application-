<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="./bootstrap.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
<%@include file="./Stylr.css"%>
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css"
	rel="stylesheet" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>

<body>
	<h4 class="text-center mt-2">ADD JOURNEY</h4>
	<form action="journeyPage" method="post">
		<div class="form-row mx-auto justify-content-around text-center mt-5" >
			<div class="form-group col-md-2">
				<label for="inputEmail4">Booking ID</label> <input type="number"
					class="form-control text-center" id="inputEmail4" placeholder="Booking ID"
					name="bookingID" value="${journeyBookingId}">
			</div>
			<div class="form-group col-md-2">
				<label for="inputPassword4">Agency</label> <input type="text"
					class="form-control text-center" id="inputPassword4" placeholder="Agency"
					name="agency">
			</div>
			<div class="form-group">
				<label for="inputAddress">Phone No</label> <input type="text"
					class="form-control text-center" id="inputAddress" placeholder="Phone No"
					name="phoneNumber">
			</div>

		</div>
		<h3 class="text-center mt-5" >Daily Report</h3>
		<div id="searchBorder">
			<div class="form-row mx-auto d-flex justify-content-start " id="newinput">
				<div class="form-group col-md-2 ">
					<label for="inputState">Train Name</label> <select id="inputState"
					name="trianName"
						class="form-control">
						<option value="" >Choose Train...</option>
						<c:forEach items="${gettraindet}" var="train">
							<option value="${train.trianName}">${train.trianName}</option>
							
						</c:forEach>
					</select>
				</div>

				<div class="form-row justify-content-around">
					<div class="form-group col-md-2">
						<label for="inputCity">From</label> <input type="text"
							class="form-control" id="inputCity" name="from1">
					</div>

					<div class="form-group col-md-2">
						<label for="inputZip">To</label> <input type="text"
							class="form-control" id="inputZip" name="to1">
					</div>
					<!--  <div id="date-picker-example"
							class="md-form md-outline input-with-post-icon datepicker"
							inline="true">
							<input placeholder="Select date" type="text" id="example"
								class="form-control" name="date1"> <label for="example" >Da
								te...</label> <i class="fas fa-calendar input-prefix"></i>
						</div>-->


					<div class=" form-group col-md-2">
						<label>Date
							<div class="row" id="container">
								<div class="col">
									<input type="text" data-date-format="dd/mm/yyyy"
										id="datepicker" name="date1">
								</div>
							</div>
						</label>
					</div>
					
					
				</div>
			</div>
		</div>
		
					<button type="button" onclick="myFunction()">Try it</button>
		<div class="form-group d-flex justify-content-end m-5" id="submit">
			<a href="${pageContext.request.contextPath  }/"><button type="submit" class="btn btn-primary mr-1">Submit</button></a>
			<a href="${pageContext.request.contextPath  }/">
			<button type="button" class="btn btn-primary ml-1">Cancle</button></a>
		</div>
		


	</form>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

	<script type="text/javascript">
		$('#datepicker').datepicker({
			weekStart : 1,
			daysOfWeekHighlighted : "6,0",
			autoclose : true,
			todayHighlight : true,
		});
		$('#datepicker').datepicker("setDate", new Date());
	</script>

	<!--   <script type="text/javascript">	$('.datepicker').datepicker({
  inline: true
});
</script> -->

<script>
function myFunction() {
	newRowAdd =
		'				<div class="form-row justify-content-around">'+ 
		'<label for="inputState">Train Name</label> <select class="form-control form-group col-md-2"> <option value="" >Choose Train...</option>'+
					'<div class="form-group col-md-2"> <label for="inputCity">From</label> <input type="text" class="form-control" id="inputCity" name="from1"> </div>'+

					'<div class="form-group col-md-2"> <label for="inputZip">To</label> <input type="text" class="form-control" id="inputZip" name="to1"> </div>' +



					'<div class=" form-group col-md-2"> <label>Date <div class="row" id="container"> <div class="col"> <input type="text" data-date-format="dd/mm/yyyy" id="datepicker" name="date1"> </div> </div> </label> </div>	</div>'

		$('#newinput').append(newRowAdd);
	}
</script>
</body>
</html>

