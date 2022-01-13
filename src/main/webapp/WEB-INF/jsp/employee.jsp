<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container">
	<div class="page-header">
	  <h1>Employee Details</h1>
	</div>
	<form class="form-horizontal" action="/employee/add" method="post">
		<input type="hidden" id="id" name="id" value="${employee.id}" />
        <!-- first name -->
		<div class="form-group">
			<label class="col-md-2 control-label" for="firstName">First Name</label>
			<div class="col-md-8">
				<input type="text" name="firstName" class="form-control" id="firstName"
					value="${employee.firstName}" required="required"
					placeholder="First Name" /> 
			</div>
		</div>
        <!-- last name -->
		<div class="form-group">
			<label class="col-md-2 control-label" for="lastName">Last Name</label>
			<div class="col-md-8">
				<input type="text" name="lastName" class="form-control" id="lastName"
					value="${employee.lastName}" required="required"
					placeholder="Last Name" /> 
			</div>
		</div>		
		<!-- Gender -->
		<div class="form-group">
			<label class="col-md-2 control-label" for="gender">Gender</label>
			<div class="col-md-8">
				<div class="form-check input-adjust">
					<input type="hidden" id="genderVal" value="${employee.gender}"/>										
					<c:forEach items="${genders}" var="gender">
						<label class="form-check-label">
							<input type="radio" class="form-check-input" name="gender" id="gender_${gender}" value="${gender}">&nbsp;${gender}     
						</label>&nbsp;&nbsp;
					</c:forEach>											
				</div>
			</div>
		</div>
        <!-- address -->
		<div class="form-group">
			<label class="col-md-2 control-label" for="address">Address</label>
			<div class="col-md-8">
				<input type="text" name="address" class="form-control" id="address"
					value="${employee.address}" required="required"
					placeholder="Address" /> 
			</div>
		</div>
        <!-- contactNumber -->
		<div class="form-group">
			<label class="col-md-2 control-label" for="contactNumber">Contact Number</label>
			<div class="col-md-8">
				<input type="text" name="contactNumber" class="form-control" id="contactNumber"
					value="${employee.contactNumber}" required="required"
					placeholder="Contact Number" /> 
			</div>
		</div>	
		<!-- Email Address -->
		<div class="form-group">
			<label class="col-md-2 control-label" for="emailAddress">Email</label>
			<div class="col-md-8">
				<input type="email" name="emailAddress" class="form-control" id="emailAddress"
					value="${employee.emailAddress}" placeholder="username@email.com" /> 
			</div>
		</div>	
		<!-- Status -->
		<div class="form-group">
			<label class="col-md-2 control-label" for="status">Status</label>
			<div class="col-md-8">
				<div class="form-check input-adjust">
					<input type="hidden" id="statusVal" value="${employee.status}"/>										
					<c:forEach items="${statuses}" var="status">
						<label class="form-check-label">
							<input type="radio" class="form-check-input" name="status" id="status_${status}" value="${status}">&nbsp;${status}     
						</label>&nbsp;&nbsp;
					</c:forEach>											
				</div>
			</div>
		</div>
		<!-- Position -->
		<div class="form-group">
			<label class="col-md-2 control-label" for="positionStatus">Position</label>
			<div class="col-md-8">
				<input type="hidden" id="positionVal" value="${employee.position}"/>
				<select name="position" value="${employee.position}" id="position" 
					class="form-control">
					<option value=""></option>
					<c:forEach items="${positions}" var="position">
						<option value="${position}">${position}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-5"></div>
			<div class="col-md-5">
        		<button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-floppy-disk"></i> Save Employee</button>
        	</div>
       	</div>	
    </form>
</div>
<script>
	$('.navbar-nav li').removeClass('active');
	$('#employeeNav').addClass('active');
	$('#gender_'+$('#genderVal').val()).attr('checked',true);
	$('#status_'+$('#statusVal').val()).attr('checked',true);
	$('#position').val($('#positionVal').val());
</script>
<%@include file="common/footer.jspf" %>